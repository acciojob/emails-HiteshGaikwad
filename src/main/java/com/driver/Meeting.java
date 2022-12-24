package com.driver;

import java.time.LocalTime;
import java.text.ParseException;

public class Meeting {

    private LocalTime startTime;
    private LocalTime endTime;

    public Meeting(LocalTime startTime, LocalTime endTime) throws ParseException{
        this.startTime = startTime;
        this.endTime = endTime;
    }


    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}
