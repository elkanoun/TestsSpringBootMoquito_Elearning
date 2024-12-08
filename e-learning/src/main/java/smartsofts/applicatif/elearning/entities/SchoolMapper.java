package smartsofts.applicatif.elearning.entities;

import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {
	
	//method toEntity
	public static School toSchool(SchoolDTO schoolDTO) {
		School school=new School();
		school.setNomSchool(schoolDTO.getNomSchool());
		school.setNombreClasses(schoolDTO.getNombreClasses());
        school.setStudents(schoolDTO.getStudents());
		return school;
	}
	
	//methodFromEntity
	public static SchoolDTO toSchoolDto(School school) {
		
		return SchoolDTO.builder()
				.nomSchool(school.getNomSchool())
				.nombreClasses(school.getNombreClasses())
				.students(school.getStudents())
				.build();
				
	}

}
