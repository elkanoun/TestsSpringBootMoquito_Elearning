package smartsofts.applicatif.elearning.entities;

import org.springframework.stereotype.Service;

@Service
public class StudentMapper {
	//method toEntity
	public Student toStudent(StudentDTO studentDto) {
		if(studentDto == null) {
			throw new NullPointerException("the studentDto should not be null!");
		}
		var student=new Student();
		student.setId(studentDto.getId()); /*ajouté*/
		student.setUsername(studentDto.getUsername());
		student.setEmail(studentDto.getEmail());
		student.setFirstname(studentDto.getFirstname());
		student.setLastname(studentDto.getLastname());
		student.setAddress(studentDto.getAddress());
		student.setTel(studentDto.getTel());
		student.setSpecialite(studentDto.getSpecialite());
		student.setNumClasse(studentDto.getNumClasse());
		student.setNomProf(studentDto.getNomProf());
		
		var school=new School();
		school.setId(studentDto.getSchool().getId());
		
		student.setSchool(school);
		
		return student;
	}
	//methodFromEntity(toDTO)
	public StudentDTO toStudentDTO(Student student) {
		if(student==null) {
			return null;
		}
        
		
		return StudentDTO.builder()
				.id(student.getId())
				.username(student.getUsername())
				.email(student.getEmail())
				.firstname(student.getFirstname())
				.lastname(student.getLastname())
				.address(student.getAddress())
				.tel(student.getTel())
				.specialite(student.getSpecialite())
				.numClasse(student.getNumClasse())
				.nomProf(student.getNomProf())
				.school(student.getSchool())
				.build();
				
	}



}
