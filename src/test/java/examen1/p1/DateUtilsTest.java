package examen1.p1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateUtilsTest {
    DateUtils dateUtils = new DateUtils();

    @ParameterizedTest
    @CsvSource({
            "2024-01-01, MONDAY",
            "2024-02-29, THURSDAY",
            "2024-03-15, FRIDAY",
            "2024-08-06, THURSDAY",
            "2024-12-25, WEDNESDAY",
    })
    public void testGetDayOfWeek(String date, String expectedDay) {
        assertEquals(expectedDay, dateUtils.getDayOfWeek(date));
    }
}
