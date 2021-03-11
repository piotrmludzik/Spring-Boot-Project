DROP TABLE IF EXISTS song;
DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS artist;
DROP TABLE IF EXISTS album;
DROP TABLE IF EXISTS song_genre;
DROP TABLE IF EXISTS song_artist;
DROP TABLE IF EXISTS song_album;

CREATE TABLE song (
    id       SERIAL PRIMARY KEY NOT NULL,
    name     CHAR(150) NOT NULL,
    date     DATE NOT NULL,
    duration FLOAT NOT NULL
);

CREATE TABLE genre (
    id       INTEGER PRIMARY KEY NOT NULL,
    name     CHAR(150) NOT NULL
);

CREATE TABLE artist (
    id           INTEGER PRIMARY KEY NOT NULL,
    name         CHAR(150) NOT NULL,
    description  CHAR(150) NOT NULL
);

CREATE TABLE album (
    id       INTEGER PRIMARY KEY NOT NULL,
    name     CHAR(150) NOT NULL,
    description  CHAR(150) NOT NULL
);

CREATE TABLE song_genre (
    id       INTEGER PRIMARY KEY NOT NULL,
    genre_id INTEGER NOT NULL,
    song_id  INTEGER NOT NULL
);

CREATE TABLE song_artist (
    id           INTEGER PRIMARY KEY NOT NULL,
    artist_id    INTEGER NOT NULL,
    song_id      INTEGER NOT NULL
);

CREATE TABLE song_album (
    id        INTEGER PRIMARY KEY NOT NULL,
    album_id  INTEGER NOT NULL,
    song_id   INTEGER NOT NULL
);

ALTER TABLE ONLY song_genre
    ADD CONSTRAINT fk_genre_id FOREIGN KEY (genre_id) REFERENCES "genre"(id);

ALTER TABLE ONLY song_genre
    ADD CONSTRAINT fk_song_id FOREIGN KEY (song_id) REFERENCES "song"(id);

ALTER TABLE ONLY song_artist
    ADD CONSTRAINT fk_artis_id FOREIGN KEY (artist_id) REFERENCES "artist"(id);

ALTER TABLE ONLY song_artist
    ADD CONSTRAINT fk_song_id FOREIGN KEY (song_id) REFERENCES "song"(id);

ALTER TABLE ONLY song_album
    ADD CONSTRAINT fk_album_id FOREIGN KEY (album_id) REFERENCES "album"(id);

ALTER TABLE ONLY song_album
    ADD CONSTRAINT fk_song_id FOREIGN KEY (song_id) REFERENCES "song"(id);