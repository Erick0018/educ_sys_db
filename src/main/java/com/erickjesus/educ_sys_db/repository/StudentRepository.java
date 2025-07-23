package com.erickjesus.educ_sys_db.repository;

import com.erickjesus.educ_sys_db.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
}
