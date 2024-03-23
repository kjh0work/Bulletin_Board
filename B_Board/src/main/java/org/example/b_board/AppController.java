package org.example.b_board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/board")
public class AppController {

    @GetMapping("/home")
    public String showIndex(){
        return "index";
    }

    @GetMapping("/community")
    public String showCommunity(){
        return "community";
    }
}
