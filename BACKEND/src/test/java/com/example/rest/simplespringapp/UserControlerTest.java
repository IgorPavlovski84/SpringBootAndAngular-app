//package com.example.rest.simplespringapp;
//
//
//import com.example.rest.springapp.user.User;
//import com.example.rest.springapp.user.UserDaoService;
//import com.example.rest.springapp.user.UserControler;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.Date;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
////@RunWith(SpringRunner.class)
////@WebMvcTest(UserResource.class)
////@SpringBootTest
//public class UserControlerTest {
//
//    @Test
//    public void ResousceTest1(){
//
//        UserDaoService service = mock(UserDaoService.class);
//        UserControler userControler = new UserControler(service);
//
//        when(service.findOne(0)).thenReturn(new User(0,"Default", UserControler.date));
//
//    Assert.assertEquals(userControler.retrieveNoneUsers(), new User(0, "Default", UserControler.date));
//        //Assert.assertNotEquals(userResource.retrieveNoneUsers(), new User(0, "Default", UserResource.date));
//
//    }
//
//    @Test
//    public void ResousceTest11(){
//
//        UserDaoService service = mock(UserDaoService.class);
//        UserControler userControler = new UserControler(service);
//
//        when(service.findOne(0)).thenReturn(new User(0,"Default", UserControler.date));
//
//        Assert.assertNotEquals(userControler.retrieveNoneUsers(), new User(0, "Default", UserControler.date));
//
//    }
//    @Test
//    public void ResousceTest2(){
//
//        Date date = new Date();
//
////        System.out.println("Time before execution of the test.");
////        System.out.println(date.getTime());
////        System.out.println(new Date().getTime());
//
//        UserDaoService service = mock(UserDaoService.class);
//        when(service.findOne(1)).thenReturn(new User(1, "Adam", new Date()));
//
//        UserControler userControler = new UserControler(service);
//
//        Assert.assertEquals(userControler.retrieveNoneUsers().getName(), "Default");
////        System.out.println("Time after execution of the test.");
////        System.out.println(new Date().getTime());
////        System.out.println(userResource.retrieveUser(1).getBirthDate().getTime());
//
//    }
//
//    @Test
//    public void ResousceTest3(){
//
//        UserDaoService service = mock(UserDaoService.class);
//        when(service.findOne(0)).thenReturn(new User(0, "Default", new Date()));
//
//        UserControler userControler = new UserControler(service);
//        long o1 = userControler.retrieveNoneUsers().getBirthDate().getTime();
//        long o2 = new User(0, "Default", new Date()).getBirthDate().getTime();
//
//        Assert.assertEquals(o1, o2);
//        System.out.println(userControler.retrieveNoneUsers().getBirthDate().getTime());
//        System.out.println(new User(0, "Default", new Date()).getBirthDate().getTime());
//        System.out.println(o1);
//        System.out.println(o2);
//
//    }
//}
