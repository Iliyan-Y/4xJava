package com.x.game.buildings;

import com.x.game.player.Player;

import javax.persistence.*;

@Entity
@Table(name = "buildings")
public class Buildings {
  @Id
  @SequenceGenerator(name = "buildings_seq",
      sequenceName = "buildings_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE,
      generator = "buildings_seq")
  @Column(name = "id")
  private Long id;

  @OneToOne(mappedBy = "buildings")
  private Player player;

  private String townName;
  private int population = 100;

  public Buildings() {
  }

  public Buildings(String townName, int population) {
    this.townName = townName;
    this.population = population;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTownName() {
    return townName;
  }

  public void setTownName(String townName) {
    this.townName = townName;
  }

  public int getPopulation() {
    return population;
  }

  public void setPopulation(int population) {
    this.population = population;
  }

  @Override
  public String toString() {
    return "Buildings{" +
        "id=" + id +
        ", townName='" + townName + '\'' +
        ", population=" + population +
        '}';
  }
}
