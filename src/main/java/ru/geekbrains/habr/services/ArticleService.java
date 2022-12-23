package ru.geekbrains.habr.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.geekbrains.habr.dtos.ArticleDto;
import ru.geekbrains.habr.repositories.ArticleRepository;
import ru.geekbrains.habr.repositories.CategoryRepository;
import ru.geekbrains.habr.services.enums.Filter;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;

    public Page<ArticleDto> findAllPage(Integer page, Integer size) {
        return articleRepository.findAllDtoedBy(
                PageRequest.of(page, size, Sort.by(Filter.PUBLISHED_AT.getName()).descending()));
    }

    public ArticleDto findById(Long id) {
        return articleRepository.findDtoedById(id);
    }
}
