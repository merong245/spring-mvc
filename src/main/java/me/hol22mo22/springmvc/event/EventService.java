package me.hol22mo22.springmvc.event;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {

    public List<Event> getEvents(){
        Event event1 = Event.builder()
                .name("스프링 MVC 스터디 1차")
                .limitOfEnrollment(5)
                .startDateTime(LocalDateTime.of(2022,1,8,10,0,0))
                .endDateTime(LocalDateTime.of(2022,1,8,12,0,0))
                .build();

        Event event2 = Event.builder()
                .name("스프링 MVC 스터디 2차")
                .limitOfEnrollment(5)
                .startDateTime(LocalDateTime.of(2022, 1, 9, 10, 0, 0))
                .endDateTime(LocalDateTime.of(2022, 1, 9, 12, 0, 0))
                .build();

        return List.of(event1,event2);
    }
}
