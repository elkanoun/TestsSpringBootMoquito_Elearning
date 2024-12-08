package smartsofts.applicatif.elearning.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder 
@Data @AllArgsConstructor @NoArgsConstructor
public class StudentDTO {
	
	private Long id;
	
	private String username;
    private String email;
    
    private String firstname;
    private String lastname;
    
    private String address;
    private String tel;
    
    private String specialite;
    private String numClasse;
    private String nomProf;
    
    private School school;
    
    
    
    
    
    
  
    
}
