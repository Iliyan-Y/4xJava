package com.x.game.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Routing and Response
@RestController
@RequestMapping(path = "api/player")
public class PlayerController {

  private final PlayerService playerService;

  @Autowired
  public PlayerController(PlayerService playerService) {
    this.playerService = playerService;
  }

  @GetMapping
  public List<Player> getPlayer() {
    return playerService.getPlayer();
  }

  @PostMapping
  public void registerNewPlayer(@RequestBody Player player) {
    playerService.addNewPlayer(player);
  }

  @DeleteMapping(path = "{playerId}")
  public void  deletePlayer(@PathVariable("playerId") Long playerId){
      playerService.deletePlayer(playerId);
  }
}
