package com.ghostbuster.springOnHeroku.controller

import com.ghostbuster.springOnHeroku.model.Greeting
import groovy.transform.CompileStatic
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@CompileStatic
@RestController
class GreetingController {

    @RequestMapping('/greeting')
    public Greeting search(@RequestParam(value = "content", defaultValue = "World") String name) {
        return new Greeting("Hello ${name}!!")
    }
}
