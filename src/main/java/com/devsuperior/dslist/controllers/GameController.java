package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameDto;
import com.devsuperior.dslist.dto.GameSimplificadoDto;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;


    @GetMapping
    public List<GameSimplificadoDto> findAll(){
        final List<GameSimplificadoDto> gameList = gameService.findAll();
        return gameList;
    }

    @GetMapping(value = "/{id}")
    public GameDto find(@PathVariable final Long id){
        final GameDto game = gameService.findById(id);
        return game;
    }
}
