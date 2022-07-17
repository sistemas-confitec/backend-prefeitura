package com.app.prefeitura.resources;

import com.app.prefeitura.dto.Output.PodcastDTO;
import com.app.prefeitura.entities.podcast.Podcast;
import com.app.prefeitura.services.PodcastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/podcast")
@Api(value = "Podcast da prefeitura.")
public class PodcastResources {

    @Autowired
    private PodcastService podcastService;

//    @Autowired(required=true)
    private ModelMapper modelMapper;

    @PostMapping
    @ApiOperation(value = "Realiza o post do podcast.")
    public PodcastDTO criar(@RequestBody final PodcastDTO dto) {
        final Podcast podcast = modelMapper.map(dto, Podcast.class);
        final Podcast podcastSalvo = podcastService.criar(podcast);
        return modelMapper.map(podcastSalvo, PodcastDTO.class);
    }

    @GetMapping(path = "/{page}")
    @ApiOperation(value = "Realiza o get dos podcasts inativos.")
    public Page<PodcastDTO> listarInativos(@PathVariable final Pageable pageable) {
        final Page<Podcast> podcast = podcastService.listarInativos(pageable);
        final List<PodcastDTO> podcasts = podcast.stream().map(pod -> modelMapper.map(pod, PodcastDTO.class)).collect(Collectors.toList());
        return new PageImpl<PodcastDTO>(podcasts, pageable, podcasts.size());
    }

    @GetMapping
    @ApiOperation(value = "Realiza a listagem geral de podcast.")
    public List<PodcastDTO> listar() {
        final List<Podcast> podcasts = podcastService.listarTodos();
        return podcasts.stream().map(podcast -> modelMapper.map(podcast, PodcastDTO.class))
                .collect(Collectors.toList());
    }

    @PutMapping
    @ApiOperation(value = "Realiza a atualização(edição) do podcast.")
    public PodcastDTO atualizar(@RequestBody final PodcastDTO dto) {
        final Podcast podcast = modelMapper.map(dto, Podcast.class);
        final Podcast podcastAtualizado = podcastService.editar(podcast);
        return modelMapper.map(podcastAtualizado, PodcastDTO.class);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Deleta o podcast.")
    public void deletar(@PathVariable final Long id) {
        podcastService.deletar(id);
    }

}
