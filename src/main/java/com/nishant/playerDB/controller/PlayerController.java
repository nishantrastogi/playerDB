package com.nishant.playerDB.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.nishant.playerDB.dto.AllPlayerDTO;
import com.nishant.playerDB.model.Player;
import com.nishant.playerDB.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@EnableCaching
public class PlayerController {

    PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
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


    @Cacheable(cacheNames="playerCache", key="#playerId")
    @RequestMapping(value = "/{playerId}", method = RequestMethod.GET)
    public ResponseEntity findById(@PathVariable String playerId) {
        try{
            return ResponseEntity.ok(playerService.findById(playerId));
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @RequestMapping(value = "/paginate", method = RequestMethod.GET)
    public ResponseEntity findBypage(@RequestParam(defaultValue = "0") Integer pageNumber, @RequestParam(defaultValue = "25") Integer pageSize) {
        try {
            return ResponseEntity.ok(playerService.findPlayerWithPagination(pageNumber, pageSize));
        } catch (IllegalArgumentException e){
            System.out.println(e);
            return ResponseEntity.badRequest().body("Illegal arguments.");
        }
    }

    @CachePut(cacheNames="playerCache", key="#player.playerID")
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity createPlayer(@RequestBody Player player){
        try{
            return ResponseEntity.ok().body(playerService.createPlayer(player));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Error creating new user.");
        }
    }

    @CacheEvict(cacheNames="playerCache", key="#playerId")
    @RequestMapping(value = "/{playerId}", method = RequestMethod.DELETE)
    public ResponseEntity createPlayer(@PathVariable String playerId){
        try{
            playerService.deletePlayer(playerId);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Error while deleting player");
        }
        return ResponseEntity.ok(null);
    }
}
