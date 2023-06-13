package com.therawsingh.portfolio.controller.tools;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/tools/timezone")
public class TimezoneController {

    @GetMapping("/timezone")
    public String timezone(){
        return "timezone";
    }

    @CrossOrigin
    @GetMapping("to={to}&from={from}&value={value}")
    public String convertTime(@PathVariable String to, @PathVariable String from, @PathVariable String value){

        final String DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";

        LocalDateTime ldt = LocalDateTime.parse(value, DateTimeFormatter.ofPattern(DATE_FORMAT));

        ZoneId fromZone = ZoneId.of(from);
        ZoneId toZone = ZoneId.of(to);

        ZonedDateTime converted = ldt.atZone(fromZone).withZoneSameInstant(toZone);

        String convertedValue = converted.format(DateTimeFormatter.ofPattern(DATE_FORMAT));

        return convertedValue;
    }

}
