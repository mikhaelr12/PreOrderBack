package md.orange.preorderback.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class TimeZoneConfig {
    @Value("${app.time-zone}")
    private String timeZone;
}
