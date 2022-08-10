package me.hol22mo22.springmvc;

import org.springframework.http.HttpEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
public class EventApi
{
    @PostMapping
    public Event createEvent(@Validated @RequestBody Event event, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(System.out::println);
        }
        return event;
    }
    @PostMapping("/http")
    public Event createHttpEvent(HttpEntity<Event> httpEntity){
        httpEntity.getHeaders();
        return httpEntity.getBody();
    }
}
