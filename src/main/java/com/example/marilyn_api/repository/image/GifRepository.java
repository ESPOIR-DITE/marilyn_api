package com.example.marilyn_api.repository.image;

import com.example.marilyn_api.Domain.image.Gifs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GifRepository extends JpaRepository<Gifs,String> {
}
