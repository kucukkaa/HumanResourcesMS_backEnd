package kodlamaio.hrms.core.utilities.validators;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class FakeMernisValidator implements ValidatorService {

	@Override
	public Result isValidUser(Candidate candidate) {
		if (candidate.getCitizenId().length() == 11 ) {
			return new SuccessResult();			
		} else {
			return new ErrorResult("TC Kimlik numarası hatalı.");
		}
	}
}
