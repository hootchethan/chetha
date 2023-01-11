package com.crudmongo.studentmongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    private StudentRepo repo;

    @PostMapping("/writing")
    public String addStudent(@RequestBody Student student) {
        repo.save(student);
        return "Student Record Added Successfully";
    }

    @GetMapping("/reading")
    public List<Student> getStudent() {
        return repo.findAll();
    }

    @DeleteMapping("/delete/{stId}")
    public String deleteStudentInfo(@PathVariable int stId) {
        repo.deleteById(stId);

        return "Student Record Deleted Successfully";
    }
}
