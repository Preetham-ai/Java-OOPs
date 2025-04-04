import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;  // Added this import

public class EventScheduler {
    public static String scheduleEvent(String eventName, int daysFromNow) {
        LocalDate today = LocalDate.now();
        LocalDate eventDate = today.plusDays(daysFromNow);
        return String.format("Event '%s' scheduled for %s", 
            eventName, 
            eventDate.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")));
    }
    
    public static long daysUntil(LocalDate futureDate) {
        return ChronoUnit.DAYS.between(LocalDate.now(), futureDate);
    }

    public static void main(String[] args) {
        System.out.println(scheduleEvent("Java Conference", 30));
        
        LocalDate newYear = LocalDate.of(2024, 1, 1);
        System.out.println("Days until New Year: " + daysUntil(newYear));
    }
}
