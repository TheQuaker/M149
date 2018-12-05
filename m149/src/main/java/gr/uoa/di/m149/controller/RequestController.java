package gr.uoa.di.m149.controller;

import gr.uoa.di.m149.service.ChicagoRequestService;
import io.swagger.annotations.ApiOperation;
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


    @GetMapping("/getRequestsByZipcodeAndStreet")
    @CrossOrigin(origins = "http://localhost:4200")
    @ApiOperation(value = "${RequestController.getRequestsByZipcodeAndStreet}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong")})
    ResponseEntity<?> getRequestsByZipcodeAndStreet(@RequestParam(defaultValue = "-1") int zipcode,
                                           @RequestParam(defaultValue = "") String streetaddress) {
            return new ResponseEntity<>(service.getChicagoRequestsByZipcodeAndSteedAddress(zipcode, streetaddress), HttpStatus.OK);
    }

    @GetMapping("/getTypeTotalRequests")
    @CrossOrigin(origins = "http://localhost:4200")
    @ApiOperation(value = "${RequestController.getTypeTotalRequests}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong")})
    ResponseEntity<?> getTypeTotalRequests(@RequestParam String fromDate,
                                           @RequestParam String toDate) {
        try {
            return new ResponseEntity<>(service.getTypeTotalRequests(fromDate, toDate), HttpStatus.OK);
        } catch (ParseException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getDayRequests")
    @CrossOrigin(origins = "http://localhost:4200")
    @ApiOperation(value = "${RequestController.getDayRequest}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong")})
    ResponseEntity<?> getDayRequests(@RequestParam String request, @RequestParam String startTime,
                                     @RequestParam String endTime) {
        try {
            return new ResponseEntity<>(service.getRequestsPerDay(request, startTime, endTime), HttpStatus.OK);
        } catch (ParseException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getZipTopRequests")
    @CrossOrigin(origins = "http://localhost:4200")
    @ApiOperation(value = "${RequestController.getZipTopRequests}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong")})
    ResponseEntity<?> getZipTopRequests(@RequestParam String atDate) {
        try {
            return new ResponseEntity<>(service.getTopRequestsPerZipCode(atDate), HttpStatus.OK);
        } catch (ParseException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getTypeOfRequests")
    @CrossOrigin(origins = "http://localhost:4200")
    @ApiOperation(value = "${RequestController.getTypeOfRequests}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong")})
    ResponseEntity<?> getTypeOfRequests() {
            return new ResponseEntity<>(service.getTypeOfRequests(), HttpStatus.OK);
    }
}
