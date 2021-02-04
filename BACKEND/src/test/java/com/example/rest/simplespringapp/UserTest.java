package com.example.rest.simplespringapp;

import com.example.rest.springapp.user.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class UserTest {



    User user = new User(7, "Igor", new Date());

    @Test
    public void userTest1(){
        Assert.assertTrue("not true",1>0);
    }

//    @Test
//    public void userTest2(){
//        assertEquals(
//                "Igort", user.getName());
//    }

    @Test
    public void userTest3(){
        Assert.assertTrue(true);
    }

}
