package com.lamda.web.movie;

import com.lamda.web.mappers.MovieMapper;
import com.lamda.web.proxy.Box;
import com.lamda.web.proxy.Pager;
import com.lamda.web.proxy.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired Pager pager;
    @Autowired MovieMapper movieMapper;
    @Autowired Proxy pxy;
    @Autowired Box<Object> box;
    @GetMapping("/{searchWord}/{pageNumber}")
    public Map<?,?> list(@PathVariable("pageNumber") String pageNumber,
                         @PathVariable("searchWord") String searchWord){

        if(searchWord.equals("null")){
            pxy.print("검색어가 없음");
            pager.setSearchWord("");
        }else{
            pxy.print("검색어가 "+searchWord);
            pager.setSearchWord(searchWord);
        }
        pxy.print("넘어옴 페이디 번호:"+pageNumber);
        pager.setPageNow(pxy.integer(pageNumber));
        pager.setBlockSize(5);
        pager.setPageSize(5);
        pager.paging();
        Function<Pager, List<MovieDTO>> f = p ->  movieMapper.selectMovies(p);
        List<MovieDTO> l = f.apply(pager);
        pxy.print("***********");
        for(MovieDTO m : l){
            pxy.print(m.toString());
        }
        box.clear();
        box.put("pager", pager);
        box.put("list", l);

        return box.get();
    }

    @GetMapping("/{searchWord}")
    public MovieDTO titleClick (@PathVariable("searchWord") String titleClick){

        return movieMapper.selectMovie(titleClick);
    }
}
