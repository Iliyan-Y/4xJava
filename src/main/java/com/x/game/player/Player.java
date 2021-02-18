package com.x.game.player;

public class Player {
  private Long id;
  private String name;

  public Player() {
  }

  public Player(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Player(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Player{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
