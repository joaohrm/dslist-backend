package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameListDto;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
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

    @Autowired
    private GameRepository gameRepository;

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

    @Transactional
    public void move(final Long listId, final int sourceIndex, final int destinationIndex){
        final List<GameMinProjection> gameMinProjectionList = gameRepository.searchByList(listId);
        final GameMinProjection repositionedGame = gameMinProjectionList.remove(sourceIndex);
        gameMinProjectionList.add(destinationIndex, repositionedGame);

        final int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        final int max = sourceIndex > destinationIndex ? sourceIndex : destinationIndex;

        for(int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, gameMinProjectionList.get(i).getId(), i);
        }
    }
}
