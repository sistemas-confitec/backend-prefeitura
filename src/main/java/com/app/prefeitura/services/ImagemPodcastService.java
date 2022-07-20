package com.app.prefeitura.services;

import com.app.prefeitura.entities.ImagemPodcast;
import com.app.prefeitura.repositories.ImagemPodcastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImagemPodcastService {

    @Autowired
    private ImagemPodcastRepository imagemPodcastRepository;

    public ImagemPodcastService(ImagemPodcastRepository imagemPodcastRepository) {
        this.imagemPodcastRepository = imagemPodcastRepository;
    }

    public ImagemPodcast upload(final MultipartFile arquivo) throws IOException {
        final ImagemPodcast imagemPodcast = new ImagemPodcast(
                null,
                arquivo.getOriginalFilename(),
                arquivo.getContentType(),
                arquivo.getBytes());
        return imagemPodcastRepository.save(imagemPodcast);
    }
}
