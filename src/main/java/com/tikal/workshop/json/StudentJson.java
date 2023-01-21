package com.tikal.workshop.json;

import com.tikal.workshop.entity.Student;

/**
 * Created by sigals on 31/08/2017.
 */
public class StudentJson {
    public StudentJson(String name) {
        this.name = name;
    }

    @SuppressWarnings("unused")
    public StudentJson() {
    }

    private String name;

    public Student toEntity() {
        return new Student(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
