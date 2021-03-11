package com.codecool.springbootproject.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GenericGenerator(name = "sequence-generator-genre",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {@org.hibernate.annotations.Parameter(name = "initial_value", value = "3001")})
    @Column(name="id", updatable=false, nullable=false)
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy="genre", cascade= CascadeType.ALL, orphanRemoval=true)
    private Set<SongGenre> songGenre;

    public Genre(String name) {
        this.name = name;
    }

    public Genre() {
    }
}
