package com.ghostbuster.springOnHeroku

import com.ghostbuster.springOnHeroku.model.Greeting
import org.springframework.boot.SpringApplication
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit

class GreetingControllerSpec extends Specification {

    @Shared
    @AutoCleanup
    ConfigurableApplicationContext context
    void setupSpec() {
        Future future = Executors
                .newSingleThreadExecutor().submit(
                new Callable() {
                    @Override
                    public ConfigurableApplicationContext call() throws Exception {
                        return (ConfigurableApplicationContext) SpringApplication
                                .run(Application.class)
                    }
                })
        context = future.get(120, TimeUnit.SECONDS)
    }

    void "should return default greeting on /greeting endpoint"() {
        when:
        ResponseEntity<Greeting> entity = new RestTemplate().getForEntity("http://localhost:8080/greeting", Greeting)
        then:
        entity.statusCode == HttpStatus.OK
        entity.body == new Greeting('Hello World!!')
    }


}
