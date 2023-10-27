package com.nishant.playerDB.dto;

import com.nishant.playerDB.model.Player;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class AllPlayerDTO implements Serializable {

    int size;
    List<Player> playerList;

    public AllPlayerDTO(int size, List<Player> playerList) {
        this.size = size;
        this.playerList = playerList;
    }
}
