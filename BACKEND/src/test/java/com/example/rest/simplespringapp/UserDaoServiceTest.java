package com.example.rest.simplespringapp;

import com.example.rest.springapp.user.UserDaoService;
import com.example.rest.springapp.user.UserControler;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoServiceTest {

//    @TestConfiguration
//    static class UserDaoServiceTestContextConfiguration {
//
//        @Bean
//        public UserDaoService service() {
//            return new UserDaoService();
//        }
//    }
//    @Autowired
    UserDaoService service;


//    @Test
//    public void UserResourceTest1(){
//        UserControler userControler = new UserControler(service);
//        Assert.assertTrue(userControler.retrieveUser(1).getName().equals("Adam"));
//    }
//
//    @Test
//    public void UserResourceTest2(){
//        UserControler userControler = new UserControler(service);
//        Assert.assertTrue(userControler.retrieveUser(2).getId() == 2);
//    }
//
//    @Test
//    public void UserResourceTest3(){
////        UserResource userResource = new UserResource(service);
//        Assert.assertTrue(service.findOne(1).getName().equals("Adam"));
//    }

}
