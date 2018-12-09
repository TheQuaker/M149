package gr.uoa.di.m149.controller;

import gr.uoa.di.m149.dto.NewIncident;
import gr.uoa.di.m149.service.ChicagoRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/save/")
public class NewController {

    @Autowired
    ChicagoRequestService service;

    @PostMapping(value = "/newIncident")
    public ResponseEntity<?> newIncident(@RequestBody NewIncident newIncident) {
        if(service.addChicagoRequest(newIncident)) {
            return new ResponseEntity<>(Object.class, HttpStatus.OK);
        }
        else return new ResponseEntity<>(Object.class, HttpStatus.BAD_REQUEST);
    }
}
