package com.meme.meme;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("meme")
public record Meme(
        @Id Long id, String name
) {

}
