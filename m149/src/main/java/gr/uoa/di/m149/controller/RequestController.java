package gr.uoa.di.m149.controller;

import gr.uoa.di.m149.domain.User;
import gr.uoa.di.m149.service.ChicagoRequestService;
import gr.uoa.di.m149.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;


@RestController
@RequestMapping("/search/")
public class RequestController {

    @Autowired
    ChicagoRequestService service;

    @Autowired
    UserService userService;


    @GetMapping("/getRequestsByZipcodeAndStreet")
    @ApiOperation(value = "${RequestController.getRequestsByZipcodeAndStreet}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong")})
    ResponseEntity<?> getRequestsByZipcodeAndStreet(@RequestParam(defaultValue = "-1") int zipcode,
                                           @RequestParam(defaultValue = "") String streetaddress, HttpServletRequest req) {
        User user = userService.whoami(req);
        userService.addActivity(user, req.getRequestURI() + "?" + req.getQueryString());
        return new ResponseEntity<>(service.getChicagoRequestsByZipcodeAndSteedAddress(zipcode, streetaddress), HttpStatus.OK);
    }

    @GetMapping("/getTypeTotalRequests")
    @ApiOperation(value = "${RequestController.getTypeTotalRequests}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong")})
    ResponseEntity<?> getTypeTotalRequests(@RequestParam String fromDate,
                                           @RequestParam String toDate, HttpServletRequest req) {
        try {
            User user = userService.whoami(req);
            userService.addActivity(user, req.getRequestURI() + "?" + req.getQueryString());
            return new ResponseEntity<>(service.getTypeTotalRequests(fromDate, toDate), HttpStatus.OK);
        } catch (ParseException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getDayRequests")
    @ApiOperation(value = "${RequestController.getDayRequest}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong")})
    ResponseEntity<?> getDayRequests(@RequestParam String request, @RequestParam String startTime,
                                     @RequestParam String endTime, HttpServletRequest req) {
        try {
            User user = userService.whoami(req);
            userService.addActivity(user, req.getRequestURI() + "?" + req.getQueryString());
            return new ResponseEntity<>(service.getRequestsPerDay(request, startTime, endTime), HttpStatus.OK);
        } catch (ParseException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getZipTopRequests")
    @ApiOperation(value = "${RequestController.getZipTopRequests}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong")})
    ResponseEntity<?> getZipTopRequests(@RequestParam String atDate, HttpServletRequest req) {
        try {
            User user = userService.whoami(req);
            userService.addActivity(user, req.getRequestURI() + "?" + req.getQueryString());
            return new ResponseEntity<>(service.getTopRequestsPerZipCode(atDate), HttpStatus.OK);
        } catch (ParseException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getTypeOfRequests")
    @ApiOperation(value = "${RequestController.getTypeOfRequests}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong")})
    ResponseEntity<?> getTypeOfRequests() {
            return new ResponseEntity<>(service.getTypeOfRequests(), HttpStatus.OK);
    }
}
