package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameDto;
import com.devsuperior.dslist.dto.GameListDto;
import com.devsuperior.dslist.dto.GameSimplificadoDto;
import com.devsuperior.dslist.dto.ReplacementDto;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDto> findAll(){
        final List<GameListDto> gameList = gameListService.findAll();
        return gameList;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameSimplificadoDto> findByList(@PathVariable final Long listId){
        final List<GameSimplificadoDto> gameList = gameService.findByList(listId);
        return gameList;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable final Long listId, @RequestParam final ReplacementDto body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
