package com.codecool.springbootproject.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class SongModel {

  @Setter(AccessLevel.NONE)
  private final long id;
  private String name;
  private java.sql.Date date;
  private double duration;

  public SongModel(long id, String name, Date date, double duration) {
    this.id = id;
    this.name = name;
    this.date = date;
    this.duration = duration;
  }
}
