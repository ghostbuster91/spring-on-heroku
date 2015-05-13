package com.ghostbuster.springOnHeroku.controller

import com.ghostbuster.springOnHeroku.model.Greeting
import com.ghostbuster.springOnHeroku.repository.GreetingRepository
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@CompileStatic
@RestController
class GreetingController {

    @Autowired
    private GreetingRepository greetingRepository


    @RequestMapping('/greeting')
    public Greeting search(@RequestParam(value = "content", defaultValue = "World") String name) {
        return greetingRepository.getGreeting()
    }
}
