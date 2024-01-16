package dev.martynoff.bytebuddy_reproducer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ByteBuddyReproducerConfig {
    @Bean
    public Greeter greeter() {
        return new Greeter();
    }
}
