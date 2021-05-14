package com.gabrielpeixoto.musicapi.service;

import com.gabrielpeixoto.musicapi.document.Musics;
import com.gabrielpeixoto.musicapi.repository.MusicsRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MusicsService {
    private final MusicsRepository musicsRepository;

    public MusicsService(MusicsRepository musicsRepository)
    {
        this.musicsRepository = musicsRepository;
    }

    public Flux<Musics> findAll()
    {
        return Flux.fromIterable(this.musicsRepository.findAll());
    }

    public Mono<Musics> findByIdMusic(String id)
    {
        return Mono.justOrEmpty(this.musicsRepository.findById(id));
    }

    public Mono<Musics> save(Musics music)
    {
        return Mono.justOrEmpty(this.musicsRepository.save(music));
    }

    public Mono<Boolean> deleteByIdHero(String id)
    {
        musicsRepository.deleteById(id);
        return Mono.just(true);
    }
}
