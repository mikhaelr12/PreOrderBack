package md.orange.preorderback.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import md.orange.preorderback.service.RestaurantResourceService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class RestaurantJob {
    private final RestaurantResourceService restaurantResourceService;

    @Transactional
    @Scheduled(cron = "0 0 6 * * *")
    public void freeTable() {
        log.info("Start job for free table");
        restaurantResourceService.freeTable();
        log.info("Finish job for free table");
    }
}
