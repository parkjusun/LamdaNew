package com.lamda.web.movie;

import com.lamda.web.music.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieSevice {
    @Autowired
    MusicRepository musicRepository;
}
