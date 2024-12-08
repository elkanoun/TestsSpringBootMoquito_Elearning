package smartsofts.applicatif.elearning.web;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import smartsofts.applicatif.elearning.entities.StudentDTO;
import smartsofts.applicatif.elearning.service.IMetierStudents;

@CrossOrigin("http://localhost:4200/")
@RestController
public class StudentControllerImp implements IStudentController {
	
	private IMetierStudents iMetierStudents;
	
	
  
	public StudentControllerImp(IMetierStudents iMetierStudents) {
		this.iMetierStudents=iMetierStudents;
	}

	//method addStudents
	@Override
	public StudentDTO addStudent(StudentDTO studentDTO) {
		return iMetierStudents.addStudent(studentDTO);
	}
    
	//method searchStudentByMc
	@Override
	public StudentDTO searchStudentByUsername(String username) {
		return iMetierStudents.searchStudentByUsername(username);
	}
    
	//method listStudents
	@Override
	public List<StudentDTO> listStudents() {
		return iMetierStudents.listStudents();
	}
    
	//method updateStudent
	@Override
	public StudentDTO updateStudent(StudentDTO studentDTO) {
		return iMetierStudents.updateStudent(studentDTO);
	}
	
	//method update partie student
	@Override
	public ResponseEntity<StudentDTO> updatePartielleStudent(Long id, Map<String, Object> fields) {
		StudentDTO studentDTO=iMetierStudents.updatePartielleStudent(id, fields);
		return new ResponseEntity<StudentDTO>(studentDTO, HttpStatus.OK);
	}
    
	//method deleteStudent
	@Override
	public void deleteStudent(Long id) {
		iMetierStudents.deleteStudent(id);
	}
    
	//method findStudentById
	@Override
	public StudentDTO findStudentById(Long id) {
		return iMetierStudents.findStudentById(id);
	}

	

}
