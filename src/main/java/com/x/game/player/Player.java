package com.x.game.player;

import com.x.game.buildings.Buildings;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player {
  @Id
  @SequenceGenerator(
      name = "player_sequence",
      sequenceName = "player_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "player_sequence"
  )
  @Column(name = "id")
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "buildings_id", referencedColumnName = "id")
  private Buildings buildings;
  private String name;
  private String email;

  public Player() {
  }

  public Player(Long id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  public Player(String name, String email) {
    this.name = name;
    this.email = email;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Buildings getBuildings() {
    return buildings;
  }

  public String displayTownName() {return  buildings.getTownName(); }

  public void setBuildings(Buildings buildings) {
    this.buildings = buildings;
  }

  @Override
  public String toString() {
    return "Player{" +
        "id=" + id +
        ", buildings=" + buildings +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
}
