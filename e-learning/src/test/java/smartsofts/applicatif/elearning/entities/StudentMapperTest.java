package smartsofts.applicatif.elearning.entities;

/*statiques*/
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*dynamiques*/
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentMapperTest {
	
	private StudentMapper mapper;
	
	@BeforeEach
	void setUp() {
		mapper=new StudentMapper();
	}
	
	
	
	//test method toStudent
	@Test
	public void shouldMapStudentDtoToStudent() {
		School school=new School(null, "prosystems", 40, null);
		StudentDTO dto=new StudentDTO( //expected!
				 (long) 1,
				"infoAboudi",
				"aboudi@gmail.com",
				"aboudi",
				"rachid",
				"wazzan ghwiba",
				"0654214789",
				"isi",
				"11",
				"nafil",
				school
				);
		
		Student student=mapper.toStudent(dto); //actuel!
		
		assertEquals(dto.getId(), student.getId()); /*ajouté*/
		assertEquals(dto.getUsername(), student.getUsername());
		assertEquals(dto.getEmail(), student.getEmail());
		assertEquals(dto.getFirstname(), student.getFirstname());
		assertEquals(dto.getLastname(), student.getLastname());
		assertEquals(dto.getAddress(), student.getAddress());
		assertEquals(dto.getTel(), student.getTel());
		assertEquals(dto.getSpecialite(), student.getSpecialite());
		assertEquals(dto.getNumClasse(), student.getNumClasse());
		assertEquals(dto.getNomProf(), student.getNomProf());
		assertNotNull(student.getSchool());
		assertEquals(dto.getSchool().getId() ,student.getSchool().getId());				
	}
	
	
	//test method toStudent en cas studentDTO null
	@Test
	public void should_throw_nullPointerException_when_studentDTO_is_null() {
		var exp = assertThrows(NullPointerException.class, () -> mapper.toStudent(null));
		assertEquals("the studentDto should not be null!", exp.getMessage());
	}
	
	
	////test method toStudentDTO
	@Test
	public void shouldMapStudentToStudentDto() {
		//Given(expected)
		School school=new School(null, "miage", 60, null);
		Student student=new  Student(
				null,
				"kmed",
				"elkanoun@gmail.com",
				"mohamed",
				"elkanoun",
				"cheikh lmfddl",
				"0654214789",
				"isi",
				"isi1",
				"nafil",
				school);
		
		//When(actual)
		StudentDTO response=mapper.toStudentDTO(student);
		
		//Then(tests)
		assertEquals(student.getUsername(), response.getUsername());
		assertEquals(student.getEmail(), response.getEmail());
		assertEquals(student.getFirstname(), response.getFirstname());
		assertEquals(student.getLastname(), response.getLastname());
		assertEquals(student.getAddress(), response.getAddress());
		assertEquals(student.getTel(), response.getTel());
		assertEquals(student.getSpecialite(), response.getSpecialite());
		assertEquals(student.getNumClasse(), response.getNumClasse());
		assertEquals(student.getNomProf(), response.getNomProf());
		assertNotNull(school);
		assertEquals(student.getSchool(), response.getSchool());
		
		
		
	}

	





}
