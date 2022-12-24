package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.text.ParseException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import static java.util.Collections.*;


public class Workspace extends Gmail{

      ArrayList<Meeting> calendar; // Stores all the meetings

    HashSet<Meeting> hs=new HashSet<>();


    public Workspace(String emailId) throws ParseException {
        super(emailId,2147483647);
        calendar=new ArrayList<>();
        // The inboxCapacity is equal to the maximum value an integer can store.
//        super.setEmailId()=emailId;
//        super.inboxCapacity=2147483647;
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
            calendar.add(meeting);
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
        int countMeetings=1;
        // Collections.sort(calendar);

        Meeting meet=calendar.get(0);
        LocalTime start=meet.getStartTime();
        LocalTime end=meet.getEndTime();
        hs.add(calendar.get(0));
         for(int i=1; i<calendar.size(); i++){
             hs.add(calendar.get(0));
             if(calendar.get(i).getStartTime().compareTo(end)<0){
                 countMeetings++;
                 end=calendar.get(i).getEndTime();
             }
         }
         return hs.size();
    }
}
