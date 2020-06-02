package com.lamda.web.movie;

import com.lamda.web.mappers.MovieMapper;
import com.lamda.web.proxy.Crawler;
import com.lamda.web.proxy.ISuppplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MovieInitializer implements ApplicationRunner {
    @Autowired MovieMapper movieMapper;
    @Autowired Crawler crawler;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        ISuppplier<Integer> s = movieMapper::count;
        if (s.get() == 0) crawler.movie();

    }
}
