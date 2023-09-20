package com.example.URLhit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/visitor-count-app")
public class UrlHitController {

    @Autowired
    public UrlHitService urlHitService;
    @GetMapping("count")
    public Map<String ,Integer> getHitCount(){

        Integer count = urlHitService.incrimentCount();
        Map<String ,Integer> map=new HashMap<>();
        map.put("visiters",count);
        return map;


    }
    @GetMapping("{username}/count")
    public Map<String,String> getHitUserCount(@PathVariable String username){
        Integer usercount = urlHitService.getCountByUserName(username);
        Map<String ,String> hmap=new HashMap<>();
        hmap.put("username",username);
        hmap.put("hitcout", String.valueOf(usercount));

        return hmap;

    }



}
