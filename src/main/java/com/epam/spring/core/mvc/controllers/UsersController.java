package com.epam.spring.core.mvc.controllers;

import com.epam.spring.core.domain.User;
import com.epam.spring.core.services.interfaces.UserService;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/user"})
public class UsersController {

    @Autowired
    @Qualifier("userService")
    UserService userService;

    @RequestMapping(value = "/allUsers/", method = RequestMethod.GET)
    public ModelAndView getAllUsers() {
        ModelAndView model = new ModelAndView();
        List<User> users = userService.getAll();
        model.addObject("users", users);
        model.setViewName("user/allUsers");
        return model;
    }

     @RequestMapping(value = "/allUsers/info/{userId}", method = RequestMethod.GET)
     public ModelAndView getUserById(@PathVariable String userId) {
     ModelAndView model = new ModelAndView();
     User user = userService.getById(userId);
     model.addObject("user", user);
     model.setViewName("user/info");
     return model;
     }

     @RequestMapping(value = "/addUser/", method = RequestMethod.GET)
     public ModelAndView saveUser() {
     return new ModelAndView("user/addUser");
     }

     @RequestMapping(value = "/addUser/", method = RequestMethod.POST)
     public ModelAndView addUser(@RequestParam Map<String, String> parametrs) throws ParseException {
     userService.register(
     new User(String.valueOf(new Random().nextInt()), parametrs.get("name"),
     parametrs.get("birthday"), parametrs.get("email")));
     return getAllUsers();
     }
    
     @RequestMapping(value = "/delete" + "/{id}", method = RequestMethod.GET)
     public ModelAndView deleteUser(@PathVariable(value = "id") String id) {
     userService.remove(userService.getById(id));
     return getAllUsers();
     }
}
