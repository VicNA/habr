package ru.geekbrains.habr.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.habr.entities.Article;
import ru.geekbrains.habr.services.ArticleService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public List<Article> findArticles(@RequestParam(required = false, name = "category_id") Long category_id) {
        Specification<Article> spec = articleService.createSpecByFilters(category_id);
        return articleService.findArticles(spec);
    }
}
