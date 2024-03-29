package com.example.moviedatabase.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Long> {
List<Movie> findByDirector(String director);


}
