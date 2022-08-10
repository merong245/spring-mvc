package me.hol22mo22.springmvc;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/events")
public class EventApi
{
    @ExceptionHandler
    public ResponseEntity errorHandler(){
        return ResponseEntity.badRequest().body("can't create event as ...");
    }
    @PostMapping
    public ResponseEntity<Event> createEvent(@Validated @RequestBody Event event, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(System.out::println);
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(event);
    }
    @PostMapping("/http")
    @ResponseBody
    public Event createHttpEvent(HttpEntity<Event> httpEntity){
        httpEntity.getHeaders();
        return httpEntity.getBody();
    }
}
