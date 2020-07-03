package com.example.marilyn_api.repository.gallery;

import com.example.marilyn_api.Domain.galery.GalleryImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalleryImageRepo extends JpaRepository<GalleryImage,String> {
}
