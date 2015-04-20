package com.ghostbuster.warsawApi.consumer.warsaw

import com.ghostbuster.warsawApi.domain.internal.Property
import com.ghostbuster.warsawApi.domain.external.warsaw.Response
import groovy.transform.CompileStatic
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@CompileStatic
@Component
class WarsawApiConsumer {

    private final static String API_KEY = 'f466c384-f5cc-4787-af44-1468697daf47'
    private final static String PROPERTY_RENT = '45ba10ab-6562-49ce-b572-6c9b999464d6'

    @Cacheable("properties")
    public Property getById(String id) {
        simulateSlowService()

        RestTemplate restTemplate = new RestTemplate()
        Response response = (Response)restTemplate.getForObject("https://api.um.warszawa.pl/api/action/wfsstore_get?id=${PROPERTY_RENT}&limit=5&apikey=${API_KEY}", Response.class)
        return new Property(id)
    }

    // We all know that warsaw api will be very slow so it simulates real world very good -)
    private void simulateSlowService() {
        try {
            long time = 5000L
            Thread.sleep(time)
        } catch (InterruptedException e) {
            throw new IllegalStateException(e)
        }
    }

}