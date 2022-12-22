package ru.geekbrains.habr.services.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Filter {
    PUBLISHED_AT("publishedAt");

    private final String name;
}
