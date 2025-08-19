package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;
import jakarta.persistence.Column;

import java.lang.module.ModuleDescriptor;
import java.util.Locale;

public class GameSimplificadoDto {

    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameSimplificadoDto() {
    }

    public GameSimplificadoDto(final Game entidade) {
        id = entidade.getId();
        title = entidade.getTitle();
        year = entidade.getYear();
        imgUrl = entidade.getImgUrl();
        shortDescription = entidade.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    //TODO: simplificar builder com build e from
    public static class Builder {
        private Long id;
        private String title;
        private Integer year;
        private String imgUrl;
        private String shortDescription;

        public GameSimplificadoDto create() {
            return new GameSimplificadoDto();
        }

        public Builder id(final Long id) {
            this.id = id;
            return this;
        }

        public Builder title(final String title) {
            this.title = title;
            return this;
        }

        public Builder year(final Integer year) {
            this.year = year;
            return this;
        }

        public Builder imgUrl(final String imgUrl) {
            this.imgUrl = imgUrl;
            return this;
        }

        public Builder shortDescription(final String shortDescription) {
            this.shortDescription = shortDescription;
            return this;
        }

    }

}
