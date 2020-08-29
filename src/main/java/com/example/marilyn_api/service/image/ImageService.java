package com.example.marilyn_api.service.image;

import com.example.marilyn_api.Domain.image.Images;
import com.example.marilyn_api.factory.image.ImageFactory;
import com.example.marilyn_api.repository.image.ImageRepo;
import com.example.marilyn_api.service.Iservice;
import com.example.marilyn_api.util.ImageResizer;
import com.example.marilyn_api.util.ImageResizer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.*;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService implements Iservice<Images,String> {

    private String fileName = Paths.get("").toAbsolutePath().toString()+"output.jpg";
    //private ClassLoader classLoader = ImageResizer.class.getClassLoader();
    private File file_save_path = new File(fileName);

    private String fileName1 = Paths.get("").toAbsolutePath().toString()+"resized.gif";
    // private ClassLoader classLoader1 = ImageResizer.class.getClassLoader();
    private File file_read_path = new File(fileName1);

    private static ImageService imageService;
    @Autowired
    private ImageRepo imageRepo;

    public static ImageService getImageService() {
        if (imageService == null) {
            imageService = new ImageService();
        }
        return imageService;
    }

    @Override
    public Images create(Images picture) throws IOException {
        System.out.println(picture.getDescription());
        // When a picture gets in here we first write it as a jpg file
        pictureWriter(picture.getImage());
        //Then we resize the picture
        ImageResizer2.getResizedImage();
        //Now we convert to byte array so that we can save it
        byte[] resizedPicture= convertToBytes();
        //Lastly we have to delete the file
        //deleteFile();
        // In this line we encode the byteArray so that we can save a small data
        Images imageObject = ImageFactory.getImages(encodeIntoByteArray(resizedPicture), picture.getDescription());
        //System.out.println(picture.toString());
        return imageRepo.save(imageObject);
    }

    @Override
    public Images update(Images picture) throws IOException {
        System.out.println("we are updating image: "+picture.toString());
        // When a picture gets in here we first write it as a jpg file
        pictureWriter(picture.getImage());
        //Then we resize the picture
        ImageResizer2.getResizedImage();
        //Now we convert to byte array so that we can save it
        byte[] resizedPicture= convertToBytes();
        //Lastly we have to delete the file
        //deleteFile();
        // In this line we encode the byteArray so that we can save a small data
        Images imageObject = ImageFactory.getImageToUpdate(picture.getId(),encodeIntoByteArray(resizedPicture), picture.getDescription());
        //System.out.println(picture.toString());
        return imageRepo.save(imageObject);
    }

    @Override
    public Images read(String id) {
        Images images = get(id);
        byte[] fack =convertStringTOBytes(images.getDescription()); // just send an empty byte array.
        if (images.getId() != null) {
            Images images1 = ImageFactory.getImageToUpdate(images.getId(),fack,decodeIntoString(images.getImage()));
            return images1;
        }
        return null;
    }

    @Override
    public Boolean delete(String id) {
        Images images1 = get(id);
        if (images1 != null) {
            imageRepo.delete(images1);
            return true;
        }
        return false;
    }

    @Override
    public List<Images> readAll() {
        return imageRepo.findAll();
    }

    @Override
    public Images get(String id) {
       Optional<Images>imagesOptional= imageRepo.findById(id);
        return imagesOptional.orElse(null);
    }

    @Override
    public List<Images> readAllOf(String id) {
        return null;
    }
    /****
     * This method first converts byte array to a file
     * and write it in util directory
     * naming it output.jpg
     * so that the method that resize picture can read it from that location.
     * @param bytes
     * @throws IOException
     */
    public void pictureWriter(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        BufferedImage bImage2 = ImageIO.read(bis);
        ImageIO.write(bImage2, "jpg", file_save_path);
        System.out.println("image created");
    }

    public byte[] convertStringTOBytes(String description){
        return description.getBytes();
    }

    public byte[] convertToBytes() throws IOException {
        // File file = new File("src/main/java/company/ac/za/studentbookstore/util/resized.jpg");
        FileInputStream fis = new FileInputStream(file_read_path);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1; ) {
                bos.write(buf, 0, readNum); //no doubt here is 0
                //Writes len bytes from the specified byte array starting at offset off to this byte array output stream.
                //System.out.println("read " + readNum + " bytes,");
            }
        } catch (IOException ex) {
            System.out.println("failed to convert to byte array");
        }
        bos.close();
        fis.close();
        return bos.toByteArray();
    }
    public byte[] encodeIntoByteArray(byte[] image) {
        String encodedString = Base64.getEncoder().encodeToString(image);
        byte[] byteArrray = encodedString.getBytes();
        return byteArrray;
    }
    /**
     * Now we first decode the Byte Array
     * then convert into a string
     **/

    public String decodeIntoString(byte[] picture) {
        byte[] byteArrayPicture = Base64.getDecoder().decode(picture);
        String stringPicture = Base64.getEncoder().encodeToString(byteArrayPicture);
        return stringPicture;
    }

//    public void writeFile() throws IOException {
//        BufferedImage outputImage = new BufferedImage(400, 300, BufferedImage.TYPE_INT_RGB);
//
//        // writes to output file
//        //String fileName1 = Paths.get("").toAbsolutePath().toString()+"resized.jpg";
//        WritableRaster raster = outputImage.getRaster();
//        for (int i=0; i<400; i++ ) {
//            for ( int j=0; j<300; j++ ) {
//                int[] colorArray = getColorForPixel(pixels[i][j]);
//                raster.setPixel(i, j, colorArray);
//            }
//        }
//
//        ImageIO.write(image, "gif", new File("CardImage"));
//    }
}
