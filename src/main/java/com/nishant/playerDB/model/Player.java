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
    @Getter @Setter
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

    @Override
    public String toString() {
        return "Player{" +
                "playerID='" + playerID + '\'' +
                ", birthYear=" + birthYear +
                ", birthMonth=" + birthMonth +
                ", birthDay=" + birthDay +
                ", birthCountry='" + birthCountry + '\'' +
                ", birthState='" + birthState + '\'' +
                ", birthCity='" + birthCity + '\'' +
                ", deathYear=" + deathYear +
                ", deathMonth=" + deathMonth +
                ", deathDay=" + deathDay +
                ", deathCountry='" + deathCountry + '\'' +
                ", deathState='" + deathState + '\'' +
                ", deathCity='" + deathCity + '\'' +
                ", nameFirst='" + nameFirst + '\'' +
                ", nameLast='" + nameLast + '\'' +
                ", nameGiven='" + nameGiven + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", bats='" + bats + '\'' +
                ", doesThrows='" + doesThrows + '\'' +
                ", debut=" + debut +
                ", finalGame=" + finalGame +
                ", retroID='" + retroID + '\'' +
                ", bbrefID='" + bbrefID + '\'' +
                '}';
    }

    // For JPA requirement
    private Player(){

    }
}
