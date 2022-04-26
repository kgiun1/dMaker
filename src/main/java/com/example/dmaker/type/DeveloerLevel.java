package com.example.dmaker.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DeveloerLevel {
    NEW("신입 개발자"),
    JUNIOR("주니어 개발자"),
    JUGNIOR("중니어 개발자"),
    SENIOR("시니어 개발자")
    ;

    private final String description;
}
