package com.example.moviedatabase;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.moviedatabase.domain.Category;
import com.example.moviedatabase.domain.Movie;
import com.example.moviedatabase.domain.MovieRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MoviedatabaseRepositoryTest {

    @Autowired
    private MovieRepository repository;

    //Find movie
    @Test
    public void findByDirectorReturnsMovie() {
        List<Movie> movies = repository.findByDirector("Ridley Scott");
        assertThat(movies).hasSize(1);
        assertThat(movies.get(0).getTitle()).isEqualTo("Gladiator");


    }
    //Create new movie
    @Test
    public void createNewMovie(){
        Movie movie = new Movie("Asd", "Nakki Kastikemäki", "Nakki Matti", "testihommaa asdasd" , 2013 , new Category("Asd"));
        repository.save(movie);
        assertThat(movie.getId()).isNotNull();
    }
    //Delete book
    @Test
    public void deleteBook() {
        List<Movie> movies = repository.findByDirector("Ridley Scott");

        repository.deleteAll();

        //???




    }
}
