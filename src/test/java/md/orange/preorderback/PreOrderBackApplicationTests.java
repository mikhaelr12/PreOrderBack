package md.orange.preorderback;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PreOrderBackApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void preOrderBack() {
        String array = "[1,2,3]";
        List<String> arrayToList = List.of(array.replace("[", "").replace("]", "").split(","));
        assertNotNull(arrayToList);
        List<Long> arrayToLongList = new ArrayList<>();
        for (String s : arrayToList) {
            arrayToLongList.add(Long.parseLong(s));
        }
        assertEquals(arrayToLongList.size(), 3);
    }
}
