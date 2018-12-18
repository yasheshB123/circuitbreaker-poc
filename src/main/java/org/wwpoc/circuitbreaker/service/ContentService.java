package org.wwpoc.circuitbreaker.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("service")
public class ContentService {


    static int i = 1;

    public String content(){
        if(i%2 == 0) {
            i++;
            throw new IllegalStateException();
        }else{
            i++;
            return "Content";
        }
    }

}
