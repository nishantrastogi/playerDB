package com.nishant.playerDB.controller;

import com.nishant.playerDB.model.Player;
import com.nishant.playerDB.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("")
    public List<Player> findAll() {
        return playerService.findAll();
    }

    @RequestMapping("/{playerId}")
    public Optional<Player> findById(@PathVariable String playerId) {
        return playerService.findById(playerId);
    }

    @RequestMapping("/paginate")
    public Page<Player> findBypage(@RequestParam(defaultValue = "0") Integer pageNumber, @RequestParam(defaultValue = "25") Integer pageSize) {
        return playerService.findPlayerWithPagination(pageNumber, pageSize);
    }

}
