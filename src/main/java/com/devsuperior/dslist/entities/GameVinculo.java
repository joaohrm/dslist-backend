package com.devsuperior.dslist.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_game_vinculo")
public class GameVinculo {

    @EmbeddedId
    private GameVinculoPk gameVinculoPk = new GameVinculoPk();

    private Integer position;

    public GameVinculo() {
    }

    public GameVinculo(final Game game, final GameList gameList) {
        gameVinculoPk.setGame(game);
        gameVinculoPk.setGameList(gameList);
    }

    public GameVinculoPk getGameVinculoPk() {
        return gameVinculoPk;
    }

    public void setGameVinculoPk(GameVinculoPk gameVinculoPk) {
        this.gameVinculoPk = gameVinculoPk;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameVinculo that = (GameVinculo) o;
        return Objects.equals(gameVinculoPk, that.gameVinculoPk) && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameVinculoPk, position);
    }
}
