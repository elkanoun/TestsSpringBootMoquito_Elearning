package smartsofts.applicatif.elearning.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import smartsofts.applicatif.elearning.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    //@Query("select s from Student where s.username like :X")
	Student findByUsername(String username);

	List<Student> findAllByUsernameContaining(String username);
	
	//method search student avec motClé(username)
    /*@Query("select s from Student s where s.username like :mc")
	Student findStudentByMc(@Param("mc") String mc);
	*/

}
