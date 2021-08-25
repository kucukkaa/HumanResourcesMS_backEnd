package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerCheckService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserCheckService;
import kodlamaio.hrms.core.abstracts.EmailSendService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerCheckService employerCheckService;
	private EmployerDao employerDao;
	private EmailSendService emailSendService;
	private UserCheckService userCheckService;
	
	@Autowired
	public EmployerManager(EmployerCheckService employerCheckService, EmployerDao employerDao,
			EmailSendService emailSendService, UserCheckService userCheckService) {
		super();
		this.employerCheckService = employerCheckService;
		this.employerDao = employerDao;
		this.emailSendService = emailSendService;
		this.userCheckService = userCheckService;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public Result add(Employer employer) {
		if (this.userCheckService.isUniqueEmail(employer).isSuccess() && this.employerCheckService.isEmailDomainOk(employer).isSuccess()) {
			this.employerDao.save(employer);
			return new SuccessResult(this.emailSendService.sendMailToUser("Bu maili okuyorsanız kullanıcı ön kaydınız yapılmıştır. Mail adresini onaylamak için tıklayınız."));
		}
		return new ErrorResult(this.userCheckService.isUniqueEmail(employer).getMessage() + this.employerCheckService.isEmailDomainOk(employer).getMessage());
	}

	@Override
	public DataResult<Employer> getEmployerByUserId(int userId) {
		return new SuccessDataResult<Employer>(this.employerDao.getOne(userId));
	}

}
