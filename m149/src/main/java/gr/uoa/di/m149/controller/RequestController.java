package gr.uoa.di.m149.controller;

import gr.uoa.di.m149.service.ChicagoRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/requests/")
public class RequestController {

    private final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    ChicagoRequestService service;

    @GetMapping()
    ModelAndView getChicagoRequests() {
        ModelAndView modelAndView = new ModelAndView("chicagoRequest");
        modelAndView.addObject("chicagoRequest", service.getChicagoRequestById(2));
        return modelAndView;
    }
}
