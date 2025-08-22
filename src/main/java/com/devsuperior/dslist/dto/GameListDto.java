package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.GameList;
import org.springframework.beans.BeanUtils;

public class GameListDto {
    private Long id;
    private String name;

    public GameListDto() {}

    public GameListDto(final GameList entidade) {
        id = entidade.getId();
        name = entidade.getName();
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
