package com.codecool.springbootproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
public class Song {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id", updatable=false, nullable=false)
  private int id;

  @Column(name="name")
  private String name;

  @Column(name="date")
  private LocalDate date;

  @Column(name="duration")
  private double duration;

  @OneToMany(mappedBy="song", cascade=CascadeType.ALL, orphanRemoval=true)
  private Set<SongGenre> songGenre;

  @OneToMany(mappedBy="song", cascade=CascadeType.ALL, orphanRemoval=true)
  private Set<SongArtist> songArtist;

  @OneToMany(mappedBy="song", cascade=CascadeType.ALL, orphanRemoval=true)
  private Set<SongAlbum> songAlbum;

  public Song(String name, LocalDate date, double duration) {
    this.name = name;
    this.date = date;
    this.duration = duration;
  }

  public Song(){
  }
}
