package com.example.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class MessageController {

	@RequestMapping(value="/salvation", method = RequestMethod.GET)  
    public String exibe() {			   
        return "JESUS THE NUMBER 1";	
    }	
}
