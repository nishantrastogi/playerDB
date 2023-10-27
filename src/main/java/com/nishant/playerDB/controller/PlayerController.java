package com.nishant.playerDB.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.nishant.playerDB.dto.AllPlayerDTO;
import com.nishant.playerDB.model.Player;
import com.nishant.playerDB.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping("")
    public ResponseEntity findAll() {
        try{
            List<Player> playerList = playerService.findAll();
            AllPlayerDTO dtoObject = new AllPlayerDTO(playerList.size(), playerList);
            ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String responseString = objectWriter.writeValueAsString(dtoObject);
            return ResponseEntity.ok(responseString);
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(e);
        }
    }

    @RequestMapping("/{playerId}")
    public ResponseEntity findById(@PathVariable String playerId) {
        try{
            return ResponseEntity.ok(playerService.findById(playerId));
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @RequestMapping("/paginate")
    public ResponseEntity findBypage(@RequestParam(defaultValue = "0") Integer pageNumber, @RequestParam(defaultValue = "25") Integer pageSize) {
        try {
            return ResponseEntity.ok(playerService.findPlayerWithPagination(pageNumber, pageSize));
        } catch (IllegalArgumentException e){
            System.out.println(e);
            return ResponseEntity.badRequest().body("Illegal arguments.");
        }
    }

}
