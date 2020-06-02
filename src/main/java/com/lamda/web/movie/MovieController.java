package com.lamda.web.movie;

import com.lamda.web.mappers.MovieMapper;
import com.lamda.web.proxy.Box;
import com.lamda.web.proxy.IFuntion;
import com.lamda.web.proxy.Pager;
import com.lamda.web.proxy.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired Pager pager;
    @Autowired MovieMapper movieMapper;
    @Autowired  Proxy pxy;
    @Autowired  Box<Object> box;

    @GetMapping("/list/{pageNumber}/{searchWord}")
    public Map<?,?> list(@PathVariable("pageNumber") String pageNumber,
                         @PathVariable("searchWord") String searchWord ){

        if (searchWord.equals("")){
            pxy.print("검색어가 없음");

        }else {
            pxy.print("검색어가"+searchWord);
        }

        pager.setPageNow(pxy.integer(pageNumber));
        pager.setBlockSize(5);
        pager.setPageSize(5);
        pager.paging();
        IFuntion<Pager, List<MovieDTO>> f = p -> movieMapper.selectMovies(p) ;
        List<MovieDTO> l = f.apply(pager);
        pxy.print("***********************************");
        for(MovieDTO m : l){
            pxy.print(m.toString());
        }
        box.clear();
        box.put("pager",pager);
        box.put("list",l);
        return box.get();
    }
}
