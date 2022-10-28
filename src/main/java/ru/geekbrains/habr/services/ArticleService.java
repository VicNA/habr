package ru.geekbrains.habr.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.geekbrains.habr.entities.Article;
import ru.geekbrains.habr.entities.Category;
import ru.geekbrains.habr.repositories.ArticleRepository;
import ru.geekbrains.habr.repositories.specifications.ArticlesSpecifications;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<Article> findArticles(Specification<Article> spec) {
        return articleRepository.findAll(spec);
    }

    public Specification<Article> createSpecByFilters(Long id) {
        Specification<Article> spec = Specification.where(null);
        if (id != null) {
            spec = spec.and(ArticlesSpecifications.categoryEquals(id));
        }

        return spec;
    }
}
