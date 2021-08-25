package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateCheckService {
	
	Result isCitizenIdUnique(Candidate candidate);
	Result isValidCandidate (Candidate candidate);
}
