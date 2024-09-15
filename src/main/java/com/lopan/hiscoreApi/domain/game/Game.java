package com.lopan.hiscoreApi.domain.game;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import java.util.UUID;

@Getter
public class Game {

    private UUID id;
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String key;
    private String defaultSortingField;

    public Game(@NonNull String name, @NonNull String key, String defaultSortingField) {
        this.name = name;
        this.key = key;
        this.defaultSortingField = defaultSortingField;
        this.id = UUID.randomUUID();
    }

    public Game updateGame(Game updated) {
        this.name = updated.getName();
        this.key = updated.getKey();
        this.defaultSortingField = updated.getDefaultSortingField();
        return this;
    }

}
