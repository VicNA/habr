package ru.geekbrains.habr.repositories.specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.geekbrains.habr.entities.Article;
import ru.geekbrains.habr.entities.Category;

import javax.persistence.criteria.JoinType;

public class ArticlesSpecifications {

    public static Specification<Article> categoryEquals(Long id) {
        return (root, query, criteriaBuilder) -> {
//            query.from(Article.class).join("id", JoinType.INNER).
            return criteriaBuilder.equal(root.get("categories"), id);
        };
    }
}
