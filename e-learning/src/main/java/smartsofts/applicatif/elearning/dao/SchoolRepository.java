package smartsofts.applicatif.elearning.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import smartsofts.applicatif.elearning.entities.School;

public interface SchoolRepository extends JpaRepository<School, Long> {

}
