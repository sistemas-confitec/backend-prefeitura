package com.app.prefeitura.repositories;

import com.app.prefeitura.entities.podcast.ImagemPodcast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagemPodcastRepository extends JpaRepository<ImagemPodcast, String> {
}
