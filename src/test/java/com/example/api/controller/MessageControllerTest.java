package com.example.api.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;



@SpringBootTest
@RunWith(SpringRunner.class)
public class MessageControllerTest {
    @Test
    public void exibe(){
        String msg = "JESUS THE NUMBER 1";
        Assert.assertEquals(msg, "JESUS THE NUMBER 1");
    }

}