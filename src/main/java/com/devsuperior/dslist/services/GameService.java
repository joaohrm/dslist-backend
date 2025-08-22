package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameDto;
import com.devsuperior.dslist.dto.GameSimplificadoDto;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameSimplificadoDto> findAll(){
        final List<Game> gameList = gameRepository.findAll();
        return gameList.stream().map(GameSimplificadoDto::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDto findById(final Long id){
        final Game game = gameRepository.findById(id).get();
        final GameDto gameDto = new GameDto(game);
        return gameDto;
    }

    @Transactional(readOnly = true)
    public List<GameSimplificadoDto> findByList(final Long listId){
        final List<GameMinProjection> gameMinProjectionList = gameRepository.searchByList(listId);
        return gameMinProjectionList.stream().map(GameSimplificadoDto::new).toList();
    }
}
