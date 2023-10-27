package com.nishant.playerDB.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(indexes = @Index(name = "playerIndex", columnList = "playerID"))
@Getter
@Setter
public class Player implements Serializable {

    @Id
    private String playerID;
    private Integer birthYear;
    private Integer birthMonth;
    private Integer birthDay;
    private String birthCountry;
    private String birthState;
    private String birthCity;
    private Integer deathYear;
    private Integer deathMonth;
    private Integer deathDay;
    private String deathCountry;
    private String deathState;
    private String deathCity;
    private String nameFirst;
    private String nameLast;
    private String nameGiven;
    private Integer weight;
    private Integer height;
    private String bats;
    private String doesThrows;
    private Date debut;
    private Date finalGame;
    private String retroID;
    private String bbrefID;

    // For JPA requirement
    private Player(){

    }
}
