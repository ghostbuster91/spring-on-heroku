package com.ghostbuster.warsawApi.controller

import com.ghostbuster.warsawApi.consumer.warsaw.WarsawApiConsumer
import com.ghostbuster.warsawApi.domain.internal.Property
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@CompileStatic
@RestController
class PropertiesController {

    @Autowired
    private WarsawApiConsumer propertyProvider

    @RequestMapping('/search')
    public List<Property> search(@RequestParam(value="school", defaultValue="1") Integer school, @RequestParam(value="metro", defaultValue="1") Integer metro){
        return [new Property("1","123","124","nazwa1"), new Property("2","123","124","nazwa2")]
    }
}
