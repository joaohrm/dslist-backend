package com.devsuperior.dslist.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name = "game_year")
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    @Column(columnDefinition = "TEXT")
    private String shortDescription;
    @Column(columnDefinition = "TEXT")
    private String longDescription;

    public Game(){}

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlatforms() {
        return platforms;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public Double getScore() {
        return score;
    }
    public void setId(final Long id) {
        this.id = id;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setYear(final Integer year) {
        this.year = year;
    }

    public void setGenre(final String genre) {
        this.genre = genre;
    }

    public void setPlatforms(final String platforms) {
        this.platforms = platforms;
    }

    public void setImgUrl(final String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setShortDescription(final String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setLongDescription(final String longDescription) {
        this.longDescription = longDescription;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    //TODO: usar builder/dto
    public Game(final Long id, final String title, final Integer year, final String genre, final String platforms, final String imgUrl, final String shortDescription, final String longDescription, final Double score) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.platforms = platforms;
        this.imgUrl = imgUrl;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.score = score;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
