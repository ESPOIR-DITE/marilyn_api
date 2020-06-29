package com.example.marilyn_api.repository.gallery;

import com.example.marilyn_api.Domain.galery.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalleryRepo extends JpaRepository<Gallery,String> {
}
