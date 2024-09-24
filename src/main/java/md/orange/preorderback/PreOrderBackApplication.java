package md.orange.preorderback;

import md.orange.preorderback.config.TimeZoneConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.TimeZone;

@SpringBootApplication
public class PreOrderBackApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(PreOrderBackApplication.class, args);
        TimeZoneConfig timeZoneConfig = context.getBean(TimeZoneConfig.class);
        TimeZone.setDefault(TimeZone.getTimeZone(timeZoneConfig.getTimeZone()));
    }
}