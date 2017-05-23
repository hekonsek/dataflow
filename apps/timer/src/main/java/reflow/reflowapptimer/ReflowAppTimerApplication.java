package reflow.reflowapptimer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.app.time.source.TimeSourceConfiguration;

@SpringBootApplication
@ImportAutoConfiguration(TimeSourceConfiguration.class)
public class ReflowAppTimerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReflowAppTimerApplication.class, args);
    }

}