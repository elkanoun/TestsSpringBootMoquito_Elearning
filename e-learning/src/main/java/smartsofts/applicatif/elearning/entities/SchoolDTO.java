package smartsofts.applicatif.elearning.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class SchoolDTO {
	private Long id;
	private String nomSchool;
	private int nombreClasses;
	List<Student> students;
	
	
	
	
	

}
