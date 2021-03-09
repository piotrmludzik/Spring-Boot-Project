package com.codecool.springbootproject;

import com.codecool.springbootproject.dao.SongRepository;
import com.codecool.springbootproject.model.Song;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
//JDBC_DATABASE_URL=jdbc:postgresql://localhost:5432/postgres?user=postgres&password=Codecool2020

@Slf4j
@SpringBootApplication
public class SpringbootprojectApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootprojectApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(SongRepository songRepository){
		return (args)->{
			log.info("Song found by id #1000");
			log.info(songRepository.findById(1000).toString());
			log.info("Save initialized");
			songRepository.save(new Song("blabla", Date.valueOf("1974-05-03") , 11.72));
//			log.info("Deleted by id 1000");
//			artistDao.deleteById(1001);
//			log.info("Song found by id #1000");
//			log.info(artistDao.findById(1000).toString());
		};
	}
}
