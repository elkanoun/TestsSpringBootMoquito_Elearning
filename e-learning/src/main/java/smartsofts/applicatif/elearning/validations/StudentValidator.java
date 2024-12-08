package smartsofts.applicatif.elearning.validations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import smartsofts.applicatif.elearning.entities.StudentDTO;

public class StudentValidator {
	//method validate
	public static List<String> validate(StudentDTO dto){
		List<String> listErreurs=new ArrayList<>();
		
		if(dto==null) {
			listErreurs.add("veuillez saisir le username!");
			listErreurs.add("veuillez saisir l'email!");
			listErreurs.add("veuillez saisir le firstname!");
			listErreurs.add("veuillez saisir le lastname!");
			listErreurs.add("veuillez saisir l'addresse!");
			listErreurs.add("veuillez saisir le tél!");
			listErreurs.add("veuillez saisir la spécialité!");
			listErreurs.add("veuillez saisir le numClasse!");
			listErreurs.add("veuillez saisir le nomProf!");
			return listErreurs;
		}
		
		if(!StringUtils.hasLength(dto.getUsername())) {
			listErreurs.add("veuillez saisir le username!");
		}
		if(!StringUtils.hasLength(dto.getEmail())) {
			listErreurs.add("veuillez saisir l'email!");
		}
		if(!StringUtils.hasLength(dto.getFirstname())) {
			listErreurs.add("veuillez saisir le firstname!");
		}
		if(!StringUtils.hasLength(dto.getLastname())) {
			listErreurs.add("veuillez saisir le lastname!");
		}
		if(!StringUtils.hasLength(dto.getAddress())) {
			listErreurs.add("veuillez saisir l'addresse!");
		}
		if(!StringUtils.hasLength(dto.getTel())) {
			listErreurs.add("veuillez saisir le tel!");
		}
		if(!StringUtils.hasLength(dto.getSpecialite())) {
			listErreurs.add("veuillez saisir la specialité!");
		}
		if(!StringUtils.hasLength(dto.getNomProf())) {
			listErreurs.add("veuillez saisir le nomProf!");
		}
		
		return listErreurs;	
	}
	
	

}
