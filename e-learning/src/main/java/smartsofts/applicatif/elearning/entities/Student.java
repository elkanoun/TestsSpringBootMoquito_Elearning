package smartsofts.applicatif.elearning.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data @ToString @Builder
public class Student implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    
    @ManyToOne
    @JoinColumn(name = "idSchool")
    private School school;
    
    
   
    
    
    
	
	
	

}
