package com.example.moviedatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.moviedatabase.domain.*;
import com.example.moviedatabase.domain.Category;
import com.example.moviedatabase.domain.CategoryRepository;
import com.example.moviedatabase.domain.Movie;
import com.example.moviedatabase.domain.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MoviedatabaseApplication {


    private static final Logger log = LoggerFactory.getLogger(MoviedatabaseApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(MoviedatabaseApplication.class, args);
    }


    @Bean
    public CommandLineRunner moviedatabaseDemo(MovieRepository movieRepository, CategoryRepository crepository, UserRepository userRepository){
        return args -> {


            // public Movie(Long id, String title, String director, String description, int year) {
            log.info("save movies");


            crepository.save(new Category("Drama"));
            crepository.save(new Category("Thriller"));
            crepository.save(new Category("Scifi"));
            crepository.save(new Category("Document"));
            crepository.save(new Category("Action"));
            crepository.save(new Category("Horror"));



            movieRepository.save(new Movie("Gladiator", "Riddley Scott", "Historical Drama", 1999, crepository.findByName("Drama").get(0)));
            movieRepository.save(new Movie("Hladiator", "Aiddley Scott", "Aistorical Drama", 1998, crepository.findByName("Drama").get(0)));


            User user1 = new User("user","$2a$10$/Bn2m7Yw0BH4ztsQjfN.QeFSBPq1D7A/l3aFL4aObi8b0uf/Twfyq", "user@gmail.com", "USER"); //nakkimuki
            User user2 = new User("admin","$2a$10$k642tHKqEEaVVCKGIdA5ge/1Sx1P3Wxjj3TE7Logf6TQZ2dhtfs0q","admin@gmail.com", "ADMIN"); //sahtikatti
            userRepository.save(user1);
            userRepository.save(user2);



                    log.info("fetch all movies");
                    for(Movie movie : movieRepository.findAll()){
                        log.info(movie.toString());
                    }

                };

            }

        }
