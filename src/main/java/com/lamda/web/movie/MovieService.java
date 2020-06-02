package com.lamda.web.movie;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MovieService {
    public void insert(MovieDTO movie);
    public void update(String title);
    public void delete(MovieDTO movie);
    public MovieDTO selectOne();
    public List<MovieDTO> selectAll();
}
