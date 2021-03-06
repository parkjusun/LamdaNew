package com.lamda.web.mappers;


import com.lamda.web.movie.MovieDTO;
import com.lamda.web.proxy.Pager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieMapper {
   public void  insertMovie(MovieDTO movie);
   public void  updateMovie(MovieDTO movie);
   public void  deleteMovie(MovieDTO movie);

   public int count();
   public List<MovieDTO> selectMovies(Pager pager);
   public MovieDTO selectMovie(String monieName);

}
