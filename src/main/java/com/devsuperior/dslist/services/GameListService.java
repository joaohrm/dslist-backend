package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameDto;
import com.devsuperior.dslist.dto.GameListDto;
import com.devsuperior.dslist.dto.GameSimplificadoDto;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDto> findAll(){
        final List<GameList> gameList = gameListRepository.findAll();
        return gameList.stream().map(item -> new GameListDto(item)).toList();
    }

    @Transactional(readOnly = true)
    public GameListDto findById(final Long id){
        final GameList gameList = gameListRepository.findById(id).get();
        final GameListDto gameListDto = new GameListDto(gameList);
        return gameListDto;
    }
}
