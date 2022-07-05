package com.app.prefeitura.services;

import com.app.prefeitura.entities.podcast.Enum.Status;
import com.app.prefeitura.entities.podcast.Podcast;
import com.app.prefeitura.repositories.PodcastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PodcastService {

    @Autowired
    private PodcastRepository podcastRepository;

    public Podcast criar(final Podcast podcast) {
        return podcastRepository.save(podcast);
    }

    public List<Podcast> listarTodos(){
        List<Podcast> podcasts = podcastRepository.findAll();
        return podcasts;
    }

    public Page<Podcast> listarInativos(final Pageable pageable){
        return podcastRepository.findByStatus(Status.INATIVO, pageable);

    }

    public Podcast editar(final Podcast podcast){
        return podcastRepository.save(podcast);
    }

    public void deletar(final Long id){
        podcastRepository.deleteById(id);
    }
}
