package com.example.URLhit;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UrlHitService {

    Integer hitCount=0;
    Map<String,Integer> usermap=new HashMap<>();
    public Integer incrimentCount() {
        return ++hitCount;

    }

    public Integer  getCountByUserName(String username) {

        Integer cnt= usermap.getOrDefault(username,0);
        usermap.put(username,++cnt);
        return cnt;
    }
}
