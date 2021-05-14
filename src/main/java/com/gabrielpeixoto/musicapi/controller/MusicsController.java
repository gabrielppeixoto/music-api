package com.gabrielpeixoto.musicapi.controller;

import com.gabrielpeixoto.musicapi.document.Musics;
import com.gabrielpeixoto.musicapi.repository.MusicsRepository;
import com.gabrielpeixoto.musicapi.service.MusicsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static com.gabrielpeixoto.musicapi.constants.MusicsConstant.MUSICS_ENDPOINT_LOCAL;

@RestController
@Slf4j
public class MusicsController {
    MusicsService musicsService;
    MusicsRepository musicsRepository;

    private static final org.slf4j.Logger logg = org.slf4j.LoggerFactory
            .getLogger(MusicsController.class);

    public MusicsController(MusicsService musicsService, MusicsRepository musicsRepository)
    {
        this.musicsRepository = musicsRepository;
        this.musicsService = musicsService;
    }

    @GetMapping(MUSICS_ENDPOINT_LOCAL)
    public Flux<Musics> getAllItems()
    {
        log.info("requesting the list of all musics");
        return musicsService.findAll();
    }

    @GetMapping(MUSICS_ENDPOINT_LOCAL + "/id")
    public Mono<ResponseEntity<Musics>> findByIDMusic(@PathVariable String id)
    {
        log.info("requesting the music with id {}", id);
        return musicsService.findByIdMusic(id)
                .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(MUSICS_ENDPOINT_LOCAL)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mono<Musics> createMusic(@RequestBody Musics musics)
    {
        log.info("a new music was created");
        return musicsService.save(musics);
    }

    @DeleteMapping(MUSICS_ENDPOINT_LOCAL + "/id")
    @ResponseStatus(code = HttpStatus.CONTINUE)
    public Mono<HttpStatus> deleteByIdMusic(@PathVariable String id)
    {
        musicsService.deleteByIdHero(id);
        log.info("deleting the music with id {}", id);
        return Mono.just(HttpStatus.NOT_FOUND);
    }
}
