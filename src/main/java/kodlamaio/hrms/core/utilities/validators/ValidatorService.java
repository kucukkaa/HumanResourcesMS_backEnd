package kodlamaio.hrms.core.utilities.validators;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface ValidatorService {
	
	Result isValidUser(Candidate candidate);
}
