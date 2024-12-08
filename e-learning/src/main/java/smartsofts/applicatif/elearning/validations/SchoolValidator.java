package smartsofts.applicatif.elearning.validations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import smartsofts.applicatif.elearning.entities.SchoolDTO;

public class SchoolValidator {
	
	//method validate
	public static List<String> validate(SchoolDTO dto){
		List<String> listErreurs=new ArrayList<>();
		
		if(dto==null) {
			listErreurs.add("veuillez saisir le nom du school!");
			listErreurs.add("veuillez saisir le nombre de classes!");
			listErreurs.add("veuillez saisir les élèves!");
			return listErreurs;
		}
		
		if(!StringUtils.hasLength(dto.getNomSchool())) {
			listErreurs.add("veuillez saisir le nom du school!");
		}
		if(Integer.valueOf(dto.getNombreClasses())==null) {
			listErreurs.add("veuillez saisir le nombre de classes!");
		}
		if(!StringUtils.hasLength((CharSequence) dto.getStudents())) {
			listErreurs.add("veuillez saisir les élèves!");
		}
		
		
		return listErreurs;
	}

}
