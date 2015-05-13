package com.ghostbuster.springOnHeroku.repository

import com.ghostbuster.springOnHeroku.model.Greeting
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component

@Component
class GreetingRepository {

    @Override
    @Cacheable("someCache")
    public Greeting getGreeting(String name) {
        simulateSlowService();
        return new Greeting(name)
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 5000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}
