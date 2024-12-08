package smartsofts.applicatif.elearning.web;

import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.websocket.server.PathParam;
import smartsofts.applicatif.elearning.entities.StudentDTO;
import smartsofts.applicatif.elearning.utils.Constants;

//ToDo: Documentation API elearning!

public interface IStudentController {
	
	//method addStudent
	@PostMapping(value = Constants.APP_ROOT + "/students/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	StudentDTO addStudent(@RequestBody StudentDTO studentDTO);
	
	//searchStudentByMc
	@GetMapping(value = Constants.APP_ROOT + "/student", produces = MediaType.APPLICATION_JSON_VALUE)
	StudentDTO searchStudentByUsername(@PathParam("username") String username);
	
	//method listStudents
	@GetMapping(value = Constants.APP_ROOT + "/students", produces = MediaType.APPLICATION_JSON_VALUE)
	List<StudentDTO> listStudents();
	
	//method updateStudent
	@PutMapping(value = Constants.APP_ROOT + "/students/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	StudentDTO updateStudent(@RequestBody StudentDTO studentDTO);
	
	//method updatePartielleStudent
	@PatchMapping(value = Constants.APP_ROOT + "/students/update/{id}")
	ResponseEntity<StudentDTO> updatePartielleStudent(@PathVariable Long id, @RequestBody Map<String, Object> fields);
	
	//method deleteStudent
	@DeleteMapping(value = Constants.APP_ROOT + "/students/delete" )
	void deleteStudent(@PathParam("id") Long id);
	
	@GetMapping(Constants.APP_ROOT + "/students/{id}")
	StudentDTO findStudentById(@PathVariable("id") Long id);

}
