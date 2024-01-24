package com.meme.meme.controller;

import com.meme.meme.Meme;
import com.meme.meme.Repository.MemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/meme")
public class MemeController {
    @Autowired
    MemeRepository memeRepository;

    @PostMapping
    Mono<Meme> create(@RequestBody Meme meme) {
        return memeRepository.save(meme);
    }

    @GetMapping
    Flux<Meme> list() {
        WebClient.create().get().uri("https://jsonplaceholder.typicode.com/todos")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(System.out::println);
        return memeRepository.findAll();
    }
}