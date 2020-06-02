package com.lamda.web.controller;


import com.lamda.web.movie.Movie;
import com.lamda.web.movie.MovieRepository;
import com.lamda.web.music.Music;
import com.lamda.web.music.MusicRepository;
import com.lamda.web.proxy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class ProxyController {
    @Autowired Box<Object> box;
    @Autowired Crawler crawler;
    @Autowired FileUploader uploader;
    @Autowired Proxy pxy;
    @Autowired MusicRepository musicRepository;
    @Autowired MovieRepository movieRepository;



    @PostMapping("/bugsmusic")
    public HashMap<String,Object> bugsmusic(@RequestBody String searchWord){
        pxy.print("넘어온 키워드: "+searchWord);
        box.clear();
        if(musicRepository.count() == 0) crawler.bugsMusic();
        List<Music> list = musicRepository.findAll();
        box.put("list", list);
        box.put("count", list.size());
        return box.get();
    }

    @GetMapping("/soccer/{searchWord}")
    public HashMap<String,String> soccer(@PathVariable String searchWord){
        pxy.print("넘어온 키워드:"+ searchWord);
        uploader.upload();
        return null;
    }

    @GetMapping("/movie/{searchWord}")
    public HashMap<String,Object> movie(@PathVariable String searchWord){
        pxy.print("넘어온 키워드:"+ searchWord);
        box.clear();
        if(movieRepository.count() == 0) crawler.movie();
        List<Movie> list = movieRepository.findAll();
        box.put("list", list);
        box.put("count", list.size());
        return box.get();
    }
}
