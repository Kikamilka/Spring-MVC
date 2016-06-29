package com.epam.spring.core.mvc.controllers;

import com.epam.spring.core.domain.Event;
import com.epam.spring.core.services.interfaces.EventService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/event"})
public class EventController {
    
    @Autowired
    @Qualifier("eventService")
    EventService eventService;
    
    @RequestMapping(value = "/allEvents/", method = RequestMethod.GET)
    public ModelAndView getAllEvents() {
        ModelAndView model = new ModelAndView();
        List<Event> events = eventService.getAll();
        model.addObject("events", events);
        model.setViewName("event/allEvents");
        return model;
    }
    
    @RequestMapping(value = "/allEvents/info/{name}", method = RequestMethod.GET)
    public ModelAndView getEventByName(@PathVariable String name) {
        ModelAndView model = new ModelAndView();
        Event event = eventService.getByName(name);
        model.addObject("event", event);
        model.setViewName("event/info");
        return model;
    }
    
    @RequestMapping(value = "/delete/{name}", method = RequestMethod.GET)
    public ModelAndView deleteEvent(@PathVariable(value = "name") String name) {
        eventService.remove(eventService.getByName(name));
        return getAllEvents();
    }
}
