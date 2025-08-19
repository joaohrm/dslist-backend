package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameSimplificadoDto;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> findAll(){
        final List<Game> gameList = gameRepository.findAll();
        return gameList;
    }
}
