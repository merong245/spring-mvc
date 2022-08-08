package me.hol22mo22.springmvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class SampleController {

    @GetMapping("/test/{id}")
    @ResponseBody
    public Event getTest(@PathVariable Integer id){
        Event event = new Event();

        event.setId(id);

        return event;
    }

    @GetMapping(
            value = "/hello",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            headers = HttpHeaders.FROM,
            params = "name")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @GetHiMapping
    @ResponseBody
    public String hi(){
        return "hi";
    }

    @GetMapping("/events")
    @ResponseBody
    public String getEvents(){
        return "events";
    }

    @GetMapping("/events/{id}")
    @ResponseBody
    public String getEvents(@PathVariable Integer id){
        return "events " + id;
    }

    @PostMapping(value = "/events",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String postEvents(){
        return "events";
    }

    @DeleteMapping("/events/{id}")
    @ResponseBody
    public String deleteEvents(@PathVariable Integer id){
        return "events " + id;
    }

    @PutMapping(value = "/events/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String putEvents(@PathVariable Integer id){
        return "events " + id;
    }

}
