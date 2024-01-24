package com.meme.meme.Repository;

import com.meme.meme.Meme;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface MemeRepository extends R2dbcRepository<Meme, Long> {
    Flux<Meme> findAll();
}