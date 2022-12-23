package ru.geekbrains.habr.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
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
    public Page<ArticleDto> findAllPage(@RequestParam(name = "page") Integer page) {
        return articleService.findAllPage(page - 1, 5);
    }

    @GetMapping("/{id}")
    public ArticleDto findById(@PathVariable Long id) {
        return articleService.findById(id);
    }
}
