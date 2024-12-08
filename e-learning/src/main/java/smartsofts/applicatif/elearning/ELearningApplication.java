package smartsofts.applicatif.elearning;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ELearningApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(ELearningApplication.class, args);
		
		//data students
		/*
		 * StudentRepository studentRepository=context.getBean(StudentRepository.class);
		 * 
		 * Student student=new Student(null, "KMED", "med.elkanoun@gmail.com",
		 * "mohamed", "el-kanoun", "cheikh lmfddl salé", "0653627305", "isi", "isi10",
		 * "essahel"); studentRepository.save(student);
		 */
		
		//data school	
		/*
		SchoolRepository schoolRepository=context.getBean(SchoolRepository.class);
		School school=new School(null, "supmti", 50, null);
		schoolRepository.save(school);
		
		StudentRepository studentRepository=context.getBean(StudentRepository.class);
		List<Student> students=studentRepository.findAll();
		
		for (Student student : students) {
			student.setSchool(school);
			studentRepository.save(student);
		}
		*/
		
		
	}
	
	

}
