package com.restbucks.courtbooking.http;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourtRestController {

    @RequestMapping(value = "/rel/courts", method = GET)
    public Object list() {
        return new Resource<>("",
            linkTo(methodOn(CourtRestController.class).list()).withSelfRel());
    }

}
