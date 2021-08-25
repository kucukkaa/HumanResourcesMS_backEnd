package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateResume;

public interface CandidateResumeDao extends JpaRepository<CandidateResume, Integer>{

}
