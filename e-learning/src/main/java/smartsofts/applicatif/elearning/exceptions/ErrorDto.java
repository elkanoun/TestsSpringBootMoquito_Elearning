package smartsofts.applicatif.elearning.exceptions;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class ErrorDto {
	//vue utilisateur en cas exception
	private Integer httpCode;
	private ErrorCodes code;
	private String message;
	private List<String> errors=new ArrayList<>();
	
	
	
	
	

}
