package com.jpapractice.jpapractice.controller;

import com.jpapractice.jpapractice.model.Student;
import com.jpapractice.jpapractice.repo.StudentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentInterface studentInterface;

    @GetMapping(value = "/getstudbyid/{id}")
    public Optional<Student> getbyid(@PathVariable Integer id){
        Optional<Student> student=studentInterface.findById(id);
        return student;
    }

    @PostMapping(value = "/insertdata")
    public String insertData(@RequestBody Student student){
        studentInterface.save(student);
        return "Data inserted";
    }

    @PutMapping(value = "/update/{id}/{name}/{city}")
    public String updateData(@PathVariable Integer id,@PathVariable String name,@PathVariable String city){
        Optional<Student> student=studentInterface.findById(id);
        if (student!=null){
            Student stud=student.get();
            stud.setName(name);
            stud.setCity(city);
            studentInterface.save(stud);
        }
        return "Data updated";
    }
}
