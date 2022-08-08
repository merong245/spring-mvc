package me.hol22mo22.springmvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void eventForm() throws Exception{
        mockMvc.perform(get("/events/form"))
                .andDo(print())
                .andExpect(view().name("events/form"))
                .andExpect(model().attributeExists("event"))
                ;
    }
    @Test
    public void getEventTest() throws Exception {
        mockMvc.perform(get("/tests/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1))
        ;
    }

    @Test
    public void postEventTest() throws Exception{
        Event event = new Event();

        event.setName("jun");
        mockMvc.perform(post("/tests")
                .param("name",event.getName()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value(event.getName()))
                ;
    }
    @Test
    public void helloTest() throws Exception {
        mockMvc.perform(get("/hello")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .header(HttpHeaders.FROM,"localhost")
                        .param("name","jun"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));

    }

    @Test
    public void hiTest() throws Exception{
        mockMvc.perform(get("/hi"))
                .andDo(print())
                .andExpect(status().isOk())
                ;
    }

    @Test
    public void getEvents() throws Exception {
        mockMvc.perform(get("/events"))
                .andDo(print())
                .andExpect(status().isOk())
                ;
    }

    @Test
    public void getEventsWithId() throws Exception {
        mockMvc.perform(get("/events/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("events 1"));
        mockMvc.perform(get("/events/2"))
                .andExpect(status().isOk())
                .andExpect(content().string("events 2"));
        mockMvc.perform(get("/events/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("events 3"))
        ;
    }

    @Test
    public void postEvents() throws Exception{
        mockMvc.perform(post("/events")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .param("name","jun")
                        .param("limit", "20"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                ;
    }

    @Test
    public void postEventsTestWithError() throws Exception{
        mockMvc.perform(post("/tests")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .param("name","jun")
                        .param("limit", "-10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        ;
    }
    @Test
    public void deleteEvents() throws Exception{

        mockMvc.perform(delete("/events/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("events 1"));
        mockMvc.perform(delete("/events/2"))
                .andExpect(status().isOk())
                .andExpect(content().string("events 2"));
        mockMvc.perform(delete("/events/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("events 3"));

        ;
    }

    @Test
    public void putEvents() throws Exception {

        mockMvc.perform(put("/events/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("events 1"));
        mockMvc.perform(put("/events/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("events 2"));
        mockMvc.perform(put("/events/3")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("events 3"));

        ;
    }
}