package com.ghostbuster.springOnHeroku.controller

import com.ghostbuster.springOnHeroku.model.Greeting
import com.ghostbuster.springOnHeroku.repository.GreetingRepository
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.Link
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn

@CompileStatic
@RestController
class GreetingController {

    @Autowired
    private GreetingRepository greetingRepository


    private static final String TEMPLATE = "Hello, %s!";

    @RequestMapping("/greeting")
    @ResponseBody
    public HttpEntity<Greeting> greeting(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {

        Greeting greeting = new Greeting(String.format(TEMPLATE, name))

        greeting.add(createLinkToGreeting(name))

        return new ResponseEntity<Greeting>(greeting, HttpStatus.OK)
    }

    private Link createLinkToGreeting(String name) {
        GreetingController methodProxyForGreeting = ((GreetingController) methodOn(GreetingController.class))
        return linkTo(methodProxyForGreeting.greeting(name)).withSelfRel()
    }
}
