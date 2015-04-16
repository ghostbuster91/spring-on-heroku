package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        List<Integer> someList = new ArrayList<Integer>();
        someList.add(2);
        someList.add(2);
        someList.add(2);

        someList.stream().filter( i -> i > 20).collect(Collectors.toList());

        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
