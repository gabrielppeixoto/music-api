package com.gabrielpeixoto.musicapi.repository;

import com.gabrielpeixoto.musicapi.document.Musics;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface MusicsRepository extends CrudRepository<Musics, String>{
}
