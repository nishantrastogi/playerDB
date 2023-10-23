package com.nishant.playerDB.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.sql.Date;

@Entity
public class Player {
    @Id @Getter @Setter
    private String playerID;
    @Getter @Setter
    private Integer birthYear;
    @Getter @Setter
    private Integer birthMonth;
    private Integer birthDay;
    @Getter @Setter
    private String birthCountry;
    @Getter @Setter
    private String birthState;
    @Getter @Setter
    private String birthCity;
    @Getter @Setter
    private Integer deathYear;
    @Getter @Setter
    private Integer deathMonth;
    @Getter @Setter
    private Integer deathDay;
    @Getter @Setter
    private String deathCountry;
    @Getter @Setter
    private String deathState;
    @Getter @Setter
    private String deathCity;
    @Getter @Setter
    private String nameFirst;
    @Getter @Setter
    private String nameLast;
    @Getter @Setter
    private String nameGiven;
    @Getter @Setter
    private Integer weight;
    @Getter @Setter
    private Integer height;
    @Getter @Setter
    private String bats;
    @Getter @Setter
    private String doesThrows;
    @Getter @Setter
    private Date debut;
    @Getter @Setter
    private Date finalGame;
    @Getter @Setter
    private String retroID;
    @Getter @Setter
    private String bbrefID;

    // For JPA requirement
    private Player(){

    }
}
