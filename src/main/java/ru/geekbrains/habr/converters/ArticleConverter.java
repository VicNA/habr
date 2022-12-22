package ru.geekbrains.habr.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.habr.dtos.ArticleDto;
import ru.geekbrains.habr.entities.Article;

@Component
public class ArticleConverter {

    public ArticleDto entityToDto(Article article) {
        return new ArticleDto(article.getId(), article.getTitle(), article.getContent(), article.getCreatedAt());
    }
}
