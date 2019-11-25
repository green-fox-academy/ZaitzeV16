package com.greenfox.rest_test;

import com.greenfox.rest_test.models.entities.Song;
import com.greenfox.rest_test.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestTestApplication implements CommandLineRunner {

  SongRepository repository;

  @Autowired
  public RestTestApplication(SongRepository repository) {
    this.repository = repository;
  }

  public static void main(String[] args) {
    SpringApplication.run(RestTestApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
//    Song song1 = new Song(
//        "Iron Maiden", "Run to The Hills", "heavy metal", 1985, 9.5
//    );
//    Song song2 = new Song(
//        "Iron Maiden", "Prowler", "heavy metal", 1980, 9.2
//    );
//    Song song3 = new Song(
//        "Iron Maiden", "Doctor Doctor", "heavy metal", 1996, 8.9
//    );
//    Song song4 = new Song(
//        "Iron Maiden", "Brave New World", "heavy metal", 2000, 9.9
//    );
//    Song song5 = new Song(
//        "Iron Maiden", "Face in the Sand", "heavy metal", 2003, 9.6
//    );
//    this.repository.save(song1);
//    this.repository.save(song2);
//    this.repository.save(song3);
//    this.repository.save(song4);
//    this.repository.save(song5);
//
//    Song song6 = new Song(
//        "Led Zeppelin", "Babe I'm Gonna Leave You", "hard rock", 1976, 8.9
//    );
//    Song song7 = new Song(
//        "Led Zeppelin", "Heartbreaker", "hard rock", 1969, 9.9
//    );
//    Song song8 = new Song(
//        "Led Zeppelin", "Immigrant Song", "hard rock", 1970, 9.6
//    );
//    Song song9 = new Song(
//        "Led Zeppelin", "In My Time of Dying", "hard rock", 1975, 9.8
//    );
//    Song song10 = new Song(
//        "Led Zeppelin", "Stairway to Heaven", "hard rock", 1971, 10.0
//    );
//    this.repository.save(song6);
//    this.repository.save(song7);
//    this.repository.save(song8);
//    this.repository.save(song9);
//    this.repository.save(song10);
//
//    Song song11 = new Song(
//        "Powerwolf", "Black Mass Hysteria", "power metal", 2005, 7.9
//    );
//    Song song12 = new Song(
//        "Powerwolf", "Blessed & Possessed", "power metal", 2015, 8.4
//    );
//    Song song13 = new Song(
//        "Powerwolf", "Dead Boys Don't Cry", "power metal", 2011, 7.6
//    );
//    Song song14 = new Song(
//        "Powerwolf", "In Blood We Trust", "power metal", 2007, 5.4
//    );
//    Song song15 = new Song(
//        "Powerwolf", "Lust for Blood", "power metal", 2013, 4.6
//    );
//    this.repository.save(song11);
//    this.repository.save(song12);
//    this.repository.save(song13);
//    this.repository.save(song14);
//    this.repository.save(song15);
  }
}
