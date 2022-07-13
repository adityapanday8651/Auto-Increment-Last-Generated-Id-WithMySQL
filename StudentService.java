package com.comp.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comp.manager.IdConfigManager;
import com.comp.manager.StudentManager;
import com.comp.model.IdConfig;
import com.comp.model.Student;
import com.comp.view.ListResponseView;
import com.comp.view.ResponseView;

@RestController
@RequestMapping(path="/student")
public class StudentService extends GenericService{
	@Autowired StudentManager studentManager;
	@Autowired IdConfigManager idCofigManager;
	
	@PostMapping(value="/save")
	public ResponseEntity<Object> saveStudent(@RequestBody Student student){
		ResponseView res= new ResponseView();
		
		IdConfig config =idCofigManager.findByName("student");
		
		if(config==null) {
			config = new IdConfig();
			config.setLastGeneratedId(1000);
			student.setStudentId(config.getLastGeneratedId());
		}else {
			student.setStudentId(config.getLastGeneratedId()+1);
			config.setLastGeneratedId(config.getLastGeneratedId()+1);
		}
		idCofigManager.saveIdConfig(config);
		studentManager.saveStudent(student);
		res.setMessage("Student Saved Successfully");
		res.setStatus(true);
		return toSuccess(res);
	}
	
	@GetMapping(value="/list")
	public ResponseEntity<Object> listStudent(){
		List<Student> list = studentManager.findAll();
		return toSuccess(new ListResponseView(list.size(), list));
	}
	
	@GetMapping(value="/find/{studentId}")
	public Student findById(@PathVariable("studentId") int studentId){
		 return studentManager.findByStudentId(studentId);
	}
	
	@DeleteMapping(value="/delete/{studentId}")
	public ResponseEntity<Object> deleteStudent(@PathVariable("studentId") int studentId){
		ResponseView res = new ResponseView(); 
		studentManager.deleteStudent(studentId);
		 res.setMessage("Deleted Successfully");
		 res.setStatus(true);
		 return toSuccess(res);
	}
	
	@PutMapping(value="/update")
	public ResponseEntity<Object> updateStudent(@RequestBody Student student){
		ResponseView res = new ResponseView();
		studentManager.updateStudent(student);
		res.setMessage("Student Update Successfully");
		res.setStatus(true);
		return toSuccess(res);
	}
}
