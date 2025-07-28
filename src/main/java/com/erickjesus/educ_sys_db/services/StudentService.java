package com.erickjesus.educ_sys_db.services;

import com.erickjesus.educ_sys_db.domain.Student;
import com.erickjesus.educ_sys_db.dto.StudentDTO;
import com.erickjesus.educ_sys_db.repository.StudentRepository;
import com.erickjesus.educ_sys_db.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> findAll() {
        return repository.findAll();
    }

    public Student findById(String id) {
        return repository.findById(id).orElseThrow(() -> new
                ObjectNotFoundException("Objeto não encontrado"));
    }

    public Student insert(Student obj) {
        return repository.insert(obj);
    }

    public Student fromDTO(StudentDTO objDto) {
        return new Student(objDto.getId(), objDto.getName(), objDto.getEmail(), objDto.getBirthDate());
    }
}
