package ru.geekbrains.habr.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.habr.dtos.ArticleDto;
import ru.geekbrains.habr.entities.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Page<ArticleDto> findAllDtoedBy(Pageable pageable);
}
