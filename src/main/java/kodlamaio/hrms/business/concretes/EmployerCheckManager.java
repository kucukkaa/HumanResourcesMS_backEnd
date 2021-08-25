package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerCheckService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerCheckManager implements EmployerCheckService{

	@Override
	public Result isEmailDomainOk(Employer employer) {
		if (employer.getWebsite().trim().endsWith(employer.getEmail().trim().split("@")[1])) {
			return new SuccessResult();
		}
		return new ErrorResult("Email adresi ve websitenizin domain'i aynı olmalıdır.");
	}

}
