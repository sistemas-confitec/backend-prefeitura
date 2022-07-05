package com.app.prefeitura.repositories;

import com.app.prefeitura.entities.podcast.Enum.Status;
import com.app.prefeitura.entities.podcast.Podcast;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PodcastRepository extends JpaRepository<Podcast, Long> {

    Page<Podcast> findByStatus(final Status status, final Pageable pageable);

}
