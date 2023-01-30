package com.tikal.workshop.json;

import com.tikal.workshop.entity.Student;

import java.io.Serializable;

/**
 * Created by sigals on 31/08/2017.
 */
public class StudentJson implements Serializable {
    public StudentJson(String name) {
        this.name = name;
    }

    @SuppressWarnings("unused")
    public StudentJson() {
    }

    private String name;

    public StudentJson(Student student) {
        this.name = student.getName();
    }

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
