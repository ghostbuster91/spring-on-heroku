package com.ghostbuster.warsawApi.controller

import com.ghostbuster.warsawApi.domain.Greeting
import com.ghostbuster.warsawApi.domain.Property
import com.ghostbuster.warsawApi.provider.PropertyProvider
import groovy.transform.CompileStatic;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import java.util.concurrent.atomic.AtomicLong

@CompileStatic
@RestController
class PropertiesController {

    private static final String template = "Hello, %s!"
    private final AtomicLong counter = new AtomicLong()

    @Autowired
    private PropertyProvider propertyProvider

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {


        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping("/properties")
    public Property properties(@RequestParam(value="id", defaultValue="1") Integer id) {


        return propertyProvider.getById(id)
    }
}
