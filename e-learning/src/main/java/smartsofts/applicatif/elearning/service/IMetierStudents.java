package smartsofts.applicatif.elearning.service;

import java.util.List;
import java.util.Map;

import smartsofts.applicatif.elearning.entities.StudentDTO;

public interface IMetierStudents {
	StudentDTO addStudent(StudentDTO studentDTO);
	StudentDTO searchStudentByUsername(String username);
	List<StudentDTO> listStudents();
	StudentDTO updateStudent(StudentDTO studentDTO);
	StudentDTO updatePartielleStudent(Long id, Map<String, Object> fields);
	void deleteStudent(Long id);
	StudentDTO findStudentById(Long id);
}
