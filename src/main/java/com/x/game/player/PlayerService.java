package com.x.game.player;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

  public List<Player> getPlayer() {
    return List.of(new Player(1L, "okto"));
  }
}
