package com.erickjesus.educ_sys_db.resources;

import com.erickjesus.educ_sys_db.domain.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentResources {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Student>> findAll() throws ParseException {
        Student mark = new Student(
                1,
                "Mark Green",
                "mark@gmail.com",
                sdf.parse("06/09/2000")
        );
        List<Student> list = new ArrayList<>(Arrays.asList(mark));
        return ResponseEntity.ok().body(list);
    }
}
