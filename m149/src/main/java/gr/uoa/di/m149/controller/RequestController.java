package gr.uoa.di.m149.controller;

import gr.uoa.di.m149.dto.SearchForm;
import gr.uoa.di.m149.service.ChicagoRequestService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;


@Controller
@RequestMapping("/search/")
public class RequestController {

    @Autowired
    ChicagoRequestService service;


    @GetMapping("/getTypeTotalRequests")
    @CrossOrigin(origins = "http://localhost:4200")
    @ApiOperation(value = "${RequestController.getTypeTotalRequests}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong")})
    ResponseEntity<?> getTypeTotalRequests(@ApiParam("Search TypeCount") @RequestBody SearchForm form) {
        try {
            return new ResponseEntity<>(service.getTypeTotalRequests(form.getFromDate(), form.getToDate()), HttpStatus.OK);
        } catch (ParseException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getDayRequests")
    @CrossOrigin(origins = "http://localhost:4200")
    @ApiOperation(value = "${RequestController.getDayRequest}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong")})
    ResponseEntity<?> getDayRequests(@ApiParam("Search DayCount") @RequestBody SearchForm form) {
        try {
            return new ResponseEntity<>(service.getRequestsPerDay(form.getRequest(), form.getFromDate(), form.getToDate()), HttpStatus.OK);
        } catch (ParseException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getZipTopRequests")
    @CrossOrigin(origins = "http://localhost:4200")
    @ApiOperation(value = "${RequestController.getZipTopRequests}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong")})
    ResponseEntity<?> getZipTopRequests(@ApiParam("Search ZipRequests") @RequestBody SearchForm form) {
        try {
            return new ResponseEntity<>(service.getTopRequestsPerZipCode(form.getAtDate()), HttpStatus.OK);
        } catch (ParseException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
