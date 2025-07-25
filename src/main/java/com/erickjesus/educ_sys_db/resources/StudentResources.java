package com.erickjesus.educ_sys_db.resources;
import com.erickjesus.educ_sys_db.dto.StudentDTO;
import com.erickjesus.educ_sys_db.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentResources {

    @Autowired
    private StudentService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<StudentDTO>> findAll() {
        List<StudentDTO> list = service.findAll().stream().map(StudentDTO::new).toList();
        return ResponseEntity.ok().body(list);
    }
}
