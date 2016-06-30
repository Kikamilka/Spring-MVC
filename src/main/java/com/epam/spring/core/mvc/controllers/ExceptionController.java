package com.epam.spring.core.mvc.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(Exception.class)
    public ModelAndView exception(Exception ex) {
        ModelAndView model = new ModelAndView();
        String message = ex.getMessage();
        model.addObject("message", message);
        model.setViewName("error");
        return model;
    }    
}
