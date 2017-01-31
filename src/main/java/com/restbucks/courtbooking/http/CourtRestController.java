package com.restbucks.courtbooking.http;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourtRestController {

    @RequestMapping(value = "/rel/courts", method = GET)
    public Object list() {
        return null;
    }

}
