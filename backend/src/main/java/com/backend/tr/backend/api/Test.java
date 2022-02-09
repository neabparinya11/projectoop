package com.backend.tr.backend.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Test {
    @GetMapping
    public Respond test(){
        Respond res = new Respond();
        res.setName("same");
        res.setGame("Bay");
        return res;
    }

}
