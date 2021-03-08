ALTER TABLE ONLY user_event DROP CONSTRAINT IF EXISTS fk_user_id CASCADE;
ALTER TABLE ONLY user_event DROP CONSTRAINT IF EXISTS fk_event_id CASCADE;
ALTER TABLE ONLY playlist DROP CONSTRAINT IF EXISTS fk_playlist_name_id CASCADE;
ALTER TABLE ONLY playlist DROP CONSTRAINT IF EXISTS fk_song_id CASCADE;
ALTER TABLE ONLY user_playlist DROP CONSTRAINT IF EXISTS fk_user_id CASCADE;
ALTER TABLE ONLY user_playlist DROP CONSTRAINT IF EXISTS fk_playlist_id CASCADE;
ALTER TABLE ONLY song_genre DROP CONSTRAINT IF EXISTS fk_genre_id CASCADE;
ALTER TABLE ONLY song_genre DROP CONSTRAINT IF EXISTS fk_song_id CASCADE;
ALTER TABLE ONLY song_artist DROP CONSTRAINT IF EXISTS fk_artis_id CASCADE;
ALTER TABLE ONLY song_artist DROP CONSTRAINT IF EXISTS fk_song_id CASCADE;
ALTER TABLE ONLY song_album DROP CONSTRAINT IF EXISTS fk_album_id CASCADE;
ALTER TABLE ONLY song_album DROP CONSTRAINT IF EXISTS fk_song_id CASCADE;


DROP TABLE IF EXISTS "user";
DROP TABLE IF EXISTS "event";
DROP TABLE IF EXISTS user_event;
DROP TABLE IF EXISTS playlist_name;
DROP TABLE IF EXISTS song;
DROP TABLE IF EXISTS playlist;
DROP TABLE IF EXISTS user_playlist;
DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS artist;
DROP TABLE IF EXISTS album;
DROP TABLE IF EXISTS song_genre;
DROP TABLE IF EXISTS song_artist;
DROP TABLE IF EXISTS song_album;


CREATE TABLE "user" (
    id        INTEGER PRIMARY KEY NOT NULL,
    name      CHAR(150) NOT NULL,
    email     CHAR(150) NOT NULL,
    premium   BOOLEAN NOT NULL,
    password  CHAR(150) NOT NULL
);


CREATE TABLE "event" (
    id        SERIAL PRIMARY KEY NOT NULL,
    name      CHAR(150) NOT NULL,
    date      DATE NOT NULL,
    location  CHAR(150) NOT NULL
);


CREATE TABLE user_event (
    id        INTEGER PRIMARY KEY NOT NULL,
    user_id   INTEGER NOT NULL,
    event_id  INTEGER NOT NULL
);


CREATE TABLE playlist_name (
    id            INTEGER PRIMARY KEY NOT NULL,
    name          CHAR(150) NOT NULL
);


CREATE TABLE song (
    id       SERIAL PRIMARY KEY NOT NULL,
    name     CHAR(150) NOT NULL,
    date     DATE NOT NULL,
    duration FLOAT NOT NULL
);


CREATE TABLE playlist (
    id               SERIAL PRIMARY KEY NOT NULL,
    song_id          INTEGER NOT NULL,
    playlist_name_id INTEGER NOT NULL
);


CREATE TABLE user_playlist (
    id             INTEGER PRIMARY KEY NOT NULL,
    playlist_id    INTEGER NOT NULL,
    user_id        INTEGER NOT NULL
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


ALTER TABLE ONLY user_event
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES "user"(id);

ALTER TABLE ONLY user_event
    ADD CONSTRAINT fk_event_id FOREIGN KEY (event_id) REFERENCES "event"(id);

ALTER TABLE ONLY playlist
    ADD CONSTRAINT fk_playlist_name_id FOREIGN KEY (playlist_name_id) REFERENCES "playlist_name"(id);

ALTER TABLE ONLY playlist
    ADD CONSTRAINT fk_song_id FOREIGN KEY (song_id) REFERENCES "song"(id);

ALTER TABLE ONLY user_playlist
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES "user"(id);

ALTER TABLE ONLY user_playlist
    ADD CONSTRAINT fk_playlist_id FOREIGN KEY (playlist_id) REFERENCES "playlist"(id);

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