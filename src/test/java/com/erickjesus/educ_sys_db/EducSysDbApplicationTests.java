package com.erickjesus.educ_sys_db;

import com.erickjesus.educ_sys_db.domain.Student;
import com.erickjesus.educ_sys_db.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootTest
class EducSysDbApplicationTests {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Autowired
	private StudentRepository studentRepository;

	@Test
	void contextLoads() throws ParseException {

		Student alex = new Student(null, "Alex Green", "alex@gmail.com", sdf.parse("07/12/2000"));
		Student maria = new Student(null, "Maria Brown", "alex@gmail.com", sdf.parse("01/04/2000"));
		Student bob = new Student(null, "Bob Grey", "alex@gmail.com", sdf.parse("30/09/2000"));

		studentRepository.saveAll(Arrays.asList(alex, maria, bob));
	}

}
