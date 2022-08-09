package me.hol22mo22.springmvc;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Event {


    private Integer id;

    @NotBlank
    private String name;

    @Min(0)
    private Integer limit;

    public String getName() {
        return name;
    }

    @Min(0)
    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
