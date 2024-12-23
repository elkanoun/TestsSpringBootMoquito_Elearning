package smartsofts.applicatif.elearning.service;




import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import smartsofts.applicatif.elearning.dao.StudentRepository;
import smartsofts.applicatif.elearning.entities.Student;
import smartsofts.applicatif.elearning.entities.StudentDTO;
import smartsofts.applicatif.elearning.entities.StudentMapper;
import smartsofts.applicatif.elearning.exceptions.EntityNotFoundException;
import smartsofts.applicatif.elearning.exceptions.ErrorCodes;
import smartsofts.applicatif.elearning.exceptions.InvalidEntityException;
import smartsofts.applicatif.elearning.validations.StudentValidator;

@Service
@Slf4j
//@RequiredArgsConstructor
public class MetierStudentsImp implements IMetierStudents {
	
	private final StudentRepository studentRepository;
	private final StudentMapper studentMapper;
	

	public MetierStudentsImp(StudentRepository studentRepository, StudentMapper studentMapper) {
		this.studentRepository=studentRepository;
		this.studentMapper=studentMapper;
	}

	//method add student
	@Override
	public StudentDTO addStudent(StudentDTO studentDTO) {
		List<String> errors=StudentValidator.validate(studentDTO);
		if(studentDTO==null) {
			log.warn("student est vide!");
			throw new EntityNotFoundException("Entity Student not Found!", ErrorCodes.STUDENT_NOT_FOUND);
		}
		if(!errors.isEmpty()) {
			log.error("studentDTO n'est pas valide!");
			throw new InvalidEntityException("Entity Student Not valid!", ErrorCodes.STUDENT_NOT_VALID, errors);
		}
		
		Student student = studentMapper.toStudent(studentDTO);
		Student savedStudent = studentRepository.save(student);
		studentRepository.save(student);
		return studentMapper.toStudentDTO(savedStudent);	
	}
    
	//method search student By username
	@Override
	public StudentDTO searchStudentByUsername(String username) {
		Student student=studentRepository.findByUsername(username);
		if(student==null) {
			log.warn("student non trouvé!");
			throw new EntityNotFoundException("student non trouvé!", ErrorCodes.STUDENT_NOT_FOUND);
		}
		return studentMapper.toStudentDTO(student);
	}
    
	//method listStudents
	//students.stream().map(StudentMapper::toStudentDTO).collect(Collectors.toList());	 
	@Override
	public List<StudentDTO> listStudents() {
		List<Student> students=studentRepository.findAll();
		/*Utiliser un flux et une expression lambda pour transformer les étudiants en StudentDTO*/
		List<StudentDTO> studentsDTOs = new ArrayList<>();
		StudentDTO studentDTO;
		for (Student student : students) {
			studentDTO = studentMapper.toStudentDTO(student);
			studentsDTOs.add(studentDTO);
		}
		
		return studentsDTOs;	 
	}
    
	//method updateStudent
	@Override
	public StudentDTO updateStudent(StudentDTO studentDTO) {
		if(studentDTO==null) {
			log.warn("student est vide");
			throw new EntityNotFoundException("Entity student Not Found!", ErrorCodes.STUDENT_NOT_FOUND);
		}
		
		List<String> listeErreurs=StudentValidator.validate(studentDTO);
		if(!listeErreurs.isEmpty()) {
			throw new InvalidEntityException("Entity student n'est pas valide!", ErrorCodes.STUDENT_NOT_VALID, listeErreurs);
		}
		
		return studentMapper.toStudentDTO(studentRepository.save(studentMapper.toStudent(studentDTO)));
	}
	
	//method update partielle student
	@Override
	public StudentDTO updatePartielleStudent(Long id, Map<String, Object> fields) {
		Student existingStudent=studentRepository.findById(id).orElseThrow(() -> 
		              new EntityNotFoundException("student not found dans BDD!", ErrorCodes.STUDENT_NOT_FOUND));
		/*Update the existing student with the new values from the fields map using reflection*/
		fields.forEach((key,value) -> {
			Field field=ReflectionUtils.findRequiredField(Student.class, key);
			if(field==null) throw new EntityNotFoundException("student not found dans BDD!", ErrorCodes.STUDENT_NOT_FOUND);
			ReflectionUtils.setField(field, existingStudent, value);
		});
		/*Validate the mapped StudentDTO de request*/
		List<String> errors=StudentValidator.validate(studentMapper.toStudentDTO(existingStudent));
		if(!errors.isEmpty()) throw new InvalidEntityException("entity student invalide!", ErrorCodes.STUDENT_NOT_VALID, errors);
		/*Save the updated student to the db and map it to a StudentDTO*/
		return studentMapper.toStudentDTO(studentRepository.save(existingStudent));
	}
    
	//method deleteStudent
	@Override
	public void deleteStudent(Long id) {
		if(id==null) {
			log.warn("id est null");
		}
		Student student=studentRepository.getById(id);
		if(student==null) {
			log.warn("student n'éxiste pas dans BDD!");
			throw new EntityNotFoundException("student n'éxiste pas dans BDD!", ErrorCodes.STUDENT_NOT_FOUND);
		}
		
		studentRepository.delete(student);
	}
    
	//findStudentById
	@Override
	public StudentDTO findStudentById(Long id) {
		if(id==null) {
			log.warn("id est null");
		}
		Student student=studentRepository.getById(id);
		if(student==null) {
			log.warn("student n'éxiste pas dans BDD!");
			throw new EntityNotFoundException("student n'éxiste pas dans BDD!", ErrorCodes.STUDENT_NOT_FOUND);
		}
		
		return studentMapper.toStudentDTO(student);
	}

	

}
