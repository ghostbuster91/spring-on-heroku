package hello;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class WarsawPropertyProvider implements PropertyProvider {

    @Override
    @Cacheable("properties")
    public Property getById(Integer id) {
        simulateSlowService();
        return new Property(id);
    }

    // We all know that warsaw api will be very slow so it simulates real world very good ;-)
    private void simulateSlowService() {
        try {
            long time = 5000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}