package com.erickjesus.educ_sys_db.resources;
import com.erickjesus.educ_sys_db.domain.Student;
import com.erickjesus.educ_sys_db.dto.StudentDTO;
import com.erickjesus.educ_sys_db.services.StudentService;
import jakarta.servlet.Servlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<StudentDTO> findById(@PathVariable String id) {
        Student obj = service.findById(id);
        StudentDTO studentDTO = new StudentDTO(obj);
        return ResponseEntity.ok().body(studentDTO);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody StudentDTO obj) {
        Student newStudent = service.insert(service.fromDTO(obj));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody StudentDTO objDto) {
        Student obj = service.fromDTO(objDto);
        obj.setId(id);
        service.update(obj);
        return ResponseEntity.noContent().build();
    }

}
