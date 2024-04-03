package com.groupeisi.ws.web;

import com.groupeisi.ws.domain.Calendar;
import com.groupeisi.ws.repository.CalendarRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalendarController {

    private final CalendarRepository calendarRepository;

    public CalendarController(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    @GetMapping("/services/calendar/dayfinder")
    public ResponseEntity<?> findDayOfWeek(@RequestParam String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate = LocalDate.parse(date, formatter);
            String dayOfWeek = localDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.FRANCE);

            return ResponseEntity.ok(new Calendar(date, dayOfWeek) {});
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Format de date invalide. Utilisez le format jj-mm-aaaa.");
        }
    }
}
