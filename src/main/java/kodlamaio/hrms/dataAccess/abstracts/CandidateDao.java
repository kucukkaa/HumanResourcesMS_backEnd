package kodlamaio.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateResumeDto;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{

	Candidate getCandidateByCitizenId(String citizenId);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.CandidateResumeDto(c.id, c.firstName, c.lastName, s.schoolName, s.schoolDepartment, cs.startedDate, cs.endedDate, com.companyName, com.department, je.startedDate, je.endedDate, l.languageName, l.languageLevel, cr.programmingLanguageKnowlege, cr.summary, cr.github, cr.linkedin) From Candidate c inner join c.candidateResume cr inner join cr.candidateSchool cs inner join cr.jobExperience je inner join cr.language l inner join cs.school s inner join je.company com")
	List<CandidateResumeDto> getCompleteCandidateResumes();
}
