package com.nishant.playerDB.controller;

import com.nishant.playerDB.model.Player;
import com.nishant.playerDB.service.PlayerService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    PlayerService playerService;
    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping("/")
    public List<Player> findAll(){
        return playerService.findAll();
    }

    @RequestMapping("/{playerId}")
    public Optional<Player> findById(@PathVariable String playerId){
        return playerService.findById(playerId);
    }

}
