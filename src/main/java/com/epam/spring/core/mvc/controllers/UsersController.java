package com.epam.spring.core.mvc.controllers;

import com.epam.spring.core.domain.Ticket;
import com.epam.spring.core.domain.User;
import com.epam.spring.core.services.interfaces.UserService;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {

    private int visitorCount = 0;

    @RequestMapping({"/", "/home"})
    public String index(Model model) {
        model.addAttribute("visitorCount", visitorCount++);
        return "home";
    }


/*    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    @Qualifier("userService")
    UserService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView getAllUsers() {
        ModelAndView model = new ModelAndView();
        List<User> users = userService.getAll();
        model.addObject("users", users);
        model.setViewName("getAllUsers");
        return model;
    }

    /*
     @RequestMapping(value = "/about/{userId}", method = RequestMethod.GET)
     public ModelAndView getUserById(@PathVariable String userId) {
     ModelAndView model = new ModelAndView();
     User user = userService.getById(userId);
     model.addObject("user", user);
     model.setViewName("info");
     return model;
     }

     @RequestMapping(value = "/save", method = RequestMethod.GET)
     public ModelAndView saveUser() {
     return new ModelAndView("user/addUser");
     }

     @RequestMapping(value = "/save", method = RequestMethod.POST)
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

     /*    @RequestMapping(value = "/all_pdf", method = RequestMethod.GET, headers = "accept=application/pdf")
     public ModelAndView getAllUsersInPdf() {
     List<User> users = userService.getAll();
     return new ModelAndView("pdfView", "listUsers", users);
     }

    
     @RequestMapping(value = "/{userId}/tickets", method = RequestMethod.GET)
     public ModelAndView getBookedTickets(@PathVariable String userId) {
     ModelAndView model = new ModelAndView();
     User user = userService.getById(userId);
     List<Ticket> tickets = userService.getBookedTickets(user);
     model.addObject("tickets", tickets);
     model.setViewName("getBookedTickets");
     return model;
     } 

     /*    @RequestMapping(value = "/{userId}/tickets", method = RequestMethod.GET,
     headers = "accept=application/pdf")
     public ModelAndView getBookedTicketsPdf(@PathVariable String userId) {
     ModelAndView model = new ModelAndView();
     User user = userService.getById(userId);
     List<Ticket> tickets = userService.getBookedTickets(user);
     model.addObject("tickets", tickets);
     model.setViewName("getBookedTickets");
     return model;
     }
     */
}
