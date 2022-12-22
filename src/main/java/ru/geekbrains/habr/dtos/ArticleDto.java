package ru.geekbrains.habr.dtos;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class ArticleDto {
    private Long id;
    private String title;
    private String content;
    private String publishedAt;

    public ArticleDto(Long id, String title, String content, LocalDateTime publishedAt) {
        this.id = id;
        this.title = title;
        this.content = content;

        if (publishedAt != null) {
            this.publishedAt = publishedAt.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }
    }
}
