package me.hol22mo22.springmvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class SampleController {

    @GetMapping("/events/form")
    public String eventsForm(Model model){
        Event event = new Event();
        event.setLimit(20);
        model.addAttribute("event", event);

        return "/events/form";
    }
    @GetMapping("/tests/{id}")
    @ResponseBody
    public Event getTest(@PathVariable Integer id){
        Event event = new Event();

        event.setId(id);

        return event;
    }

    @PostMapping("/tests")
    public String postTest(@Validated @ModelAttribute Event event,
                           BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println("============");
            bindingResult.getAllErrors().forEach(c->{
                System.out.println(c.toString());
            });
            return "/events/form";
        }

        return "redirect:/events/list";
    }

    @GetMapping("/events/list")
    public String getEvents(Model model){
        Event event = new Event();
        event.setName("spring");
        event.setLimit(10);
        List<Event> eventList = new ArrayList<>();
        eventList.add(event);
        model.addAttribute("eventList",eventList);

        return "/events/list";

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
