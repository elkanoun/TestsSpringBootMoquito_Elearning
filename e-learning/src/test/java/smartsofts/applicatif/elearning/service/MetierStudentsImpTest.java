package smartsofts.applicatif.elearning.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import smartsofts.applicatif.elearning.dao.StudentRepository;
import smartsofts.applicatif.elearning.entities.School;
import smartsofts.applicatif.elearning.entities.Student;
import smartsofts.applicatif.elearning.entities.StudentDTO;
import smartsofts.applicatif.elearning.entities.StudentMapper;


class MetierStudentsImpTest {

	//1_wich service we want to test!
	//4_informer framework de tests moquito d'injecter all dép nécessaires annotés par @Mock pour tester svc!
	@InjectMocks
	private MetierStudentsImp metierStudentsImp;

	//2_declare the dependencies!   
	//3_mocker dependencies!
	@Mock
	private StudentRepository studentRepository;

	@Mock
	private StudentMapper studentMapper;

	//5_informer moquito de start mocks de cette classe à tester!
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	/*6_tests!*/
	//imp test méthode save student
	@Test
	public void should_successfully_save_student() {
		//Given/Expected!
		School school=new School(1L, null, 0, null);
		StudentDTO studentDto = new StudentDTO(
				1L, 
				"KMED", 
				"Elkanoun@gmail.com", 
				"Mohamed", 
				"El-kanoun", 
				"salé", 
				"0653627306",
				"isi", 
				"isi1", 
				"essahel", 
				school);
		Student student = new Student(
				1L, 
				"KMED", 
				"Elkanoun@gmail.com", 
				"Mohamed", 
				"El-kanoun", 
				"salé", 
				"0653627306",
				"isi", 
				"isi1", 
				"essahel", 
				school);
		Student savedStudent = new Student(
				1L, 
				"KMED", 
				"Elkanoun@gmail.com", 
				"Mohamed", 
				"El-kanoun", 
				"salé", 
				"0653627306",
				"isi", 
				"isi1", 
				"essahel", 
				school);

		//Mock calls(when on see method when of Moquito it's a moquing of method)!
		when(studentMapper.toStudent(studentDto))
		.thenReturn(student);
		when(studentRepository.save(student))
		.thenReturn(savedStudent);
		when(studentMapper.toStudentDTO(savedStudent))
		.thenReturn(new StudentDTO(
				1L, 
				"KMED", 
				"Elkanoun@gmail.com", 
				"Mohamed", 
				"El-kanoun", 
				"salé", 
				"0653627306",
				"isi", 
				"isi1", 
				"essahel", 
				school));

		//When(when on appel addStudent du svc on expecte(return) un objet de type studentDto)/Actual!
		StudentDTO responseDTO = metierStudentsImp.addStudent(studentDto);

		//Then(assertions tests)!
		assertEquals(studentDto.getFirstname(), responseDTO.getFirstname());
		assertEquals(studentDto.getLastname(), responseDTO.getLastname());
		assertEquals(studentDto.getEmail(), responseDTO.getEmail());


		verify(studentMapper, times(1)) //test performances api-operation passe 1temps!
		.toStudent(studentDto);
		verify(studentRepository, times(1))
		.save(student);
		verify(studentMapper, times(1))
		.toStudentDTO(savedStudent);
	}

	//method test listStudents
	@Test
	public void should_return_list_students() {
		//given-expected (list with 1element)
		List<Student> students = new ArrayList<>();
		School school=new School(1L, null, 0, null);
		students.add(new Student(
				1L, 
				"KMED", 
				"Elkanoun@gmail.com", 
				"Mohamed", 
				"El-kanoun", 
				"salé", 
				"0653627306",
				"isi", 
				"isi1", 
				"essahel", 
				school));

		//mock calls
		when(studentRepository.findAll()).thenReturn(students);
		when(studentMapper.toStudentDTO(any(Student.class)))
		     .thenReturn(new StudentDTO(
				1L, 
				"KMED", 
				"Elkanoun@gmail.com", 
				"Mohamed", 
				"El-kanoun", 
				"salé", 
				"0653627306",
				"isi", 
				"isi1", 
				"essahel", 
				school
				));


		//when-actual
		List<StudentDTO> responseDtos = metierStudentsImp.listStudents();

		//then-assertions-performances
		assertEquals(students.size(), responseDtos.size());

		verify(studentRepository, times(1)).findAll();
	}

	//method test findStudentById
	@Test
	public void should_find_student_by_id() {
		//expected
		Long idStudent = 1L;
		School school=new School(1L, null, 0, null);
		Student student = new Student(
				1L, 
				"KMED", 
				"Elkanoun@gmail.com", 
				"Mohamed", 
				"El-kanoun", 
				"salé", 
				"0653627306",
				"isi", 
				"isi1", 
				"essahel", 
				school);

		//mock calls
		when(studentRepository.getById(idStudent))
		     .thenReturn(student);
		when(studentMapper.toStudentDTO(student))
		     .thenReturn(new StudentDTO(
		    		 1L, 
						"KMED", 
						"Elkanoun@gmail.com", 
						"Mohamed", 
						"El-kanoun", 
						"salé", 
						"0653627306",
						"isi", 
						"isi1", 
						"essahel", 
						school
		    		 ));

		//when/actual
		StudentDTO responseDTO = metierStudentsImp.findStudentById(idStudent);
		

		//then/assertions
		assertEquals(student.getId(), responseDTO.getId());
		assertEquals(student.getUsername(), responseDTO.getUsername());
		assertEquals(student.getEmail(), responseDTO.getEmail());
		assertEquals(student.getFirstname(), responseDTO.getFirstname());
		assertEquals(student.getLastname(), responseDTO.getLastname());
		assertEquals(student.getAddress(), responseDTO.getAddress());
		assertEquals(student.getTel(), responseDTO.getTel());
		assertEquals(student.getSpecialite(), responseDTO.getSpecialite());
		assertEquals(student.getNumClasse(), responseDTO.getNumClasse());
		assertEquals(student.getNomProf(), responseDTO.getNomProf());
		assertEquals(student.getSchool(), responseDTO.getSchool());
		
		verify(studentRepository, times(1)).getById(idStudent);
	}
	
	//test method search student by username
	@Test
	public void should_return_student_by_username() {
		//expected
		String username = "KMED";
		School school=new School(1L, null, 0, null);
		Student student = new Student(
				1L, 
				"KMED", 
				"Elkanoun@gmail.com", 
				"Mohamed", 
				"El-kanoun", 
				"salé", 
				"0653627306",
				"isi", 
				"isi1", 
				"essahel", 
				school);
		
		//mock calls
		when(studentRepository.findByUsername(username))
		     .thenReturn(student);
		when(studentMapper.toStudentDTO(any(Student.class)))
		     .thenReturn(new StudentDTO(
		    		 1L, 
						"KMED", 
						"Elkanoun@gmail.com", 
						"Mohamed", 
						"El-kanoun", 
						"salé", 
						"0653627306",
						"isi", 
						"isi1", 
						"essahel", 
						school
						));
		
		//when-actual
		StudentDTO responseDTO = metierStudentsImp.searchStudentByUsername(username);
		
		//then-assertions-performances
		assertEquals(student.getId(), responseDTO.getId());
		assertEquals(student.getUsername(), responseDTO.getUsername());
		assertEquals(student.getEmail(), responseDTO.getEmail());
		assertEquals(student.getFirstname(), responseDTO.getFirstname());
		assertEquals(student.getLastname(), responseDTO.getLastname());
		assertEquals(student.getAddress(), responseDTO.getAddress());
		assertEquals(student.getTel(), responseDTO.getTel());
		assertEquals(student.getSpecialite(), responseDTO.getSpecialite());
		assertEquals(student.getNumClasse(), responseDTO.getNumClasse());
		assertEquals(student.getNomProf(), responseDTO.getNomProf());
		assertEquals(student.getSchool(), responseDTO.getSchool());
		
		verify(studentRepository, times(1)).findByUsername(username);
		verify(studentMapper, times(1)).toStudentDTO(student);
	}


}
