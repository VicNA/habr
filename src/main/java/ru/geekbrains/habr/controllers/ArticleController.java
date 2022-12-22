package ru.geekbrains.habr.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.habr.converters.ArticleConverter;
import ru.geekbrains.habr.dtos.ArticleDto;
import ru.geekbrains.habr.services.ArticleService;

@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;
    private final ArticleConverter articleConverter;

    @GetMapping
    public Page<ArticleDto> findArticles(@RequestParam(name = "page") Integer page) {
        return articleService.findArticles(page - 1, 5);
    }
}
