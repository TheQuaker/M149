package gr.uoa.di.m149.controller;

import gr.uoa.di.m149.dto.NewIncident;
import gr.uoa.di.m149.service.ChicagoRequestService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
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

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    ChicagoRequestService service;

    @PostMapping(value = "/newincident")
    @ApiOperation(value = "${UserController.newincident}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong")})
    public ResponseEntity<?> newIncident(@RequestBody NewIncident newIncident) {
        if(service.addChicagoRequest(newIncident)) {
            return new ResponseEntity<>("New Incident saved successfully", HttpStatus.OK);
        }
        else return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
    }
}
