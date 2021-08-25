package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCheckService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.UserCheckService;
import kodlamaio.hrms.core.abstracts.EmailSendService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateResumeDto;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private CandidateCheckService candidateCheckService;
	private UserCheckService userCheckService;
	private EmailSendService emailSendService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, CandidateCheckService candidateCheckService, UserCheckService userCheckService, EmailSendService emailSendService) {
		super();
		this.candidateCheckService = candidateCheckService;
		this.candidateDao = candidateDao;
		this.userCheckService = userCheckService;
		this.emailSendService = emailSendService;
		
	}
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Data Listelendi.");
	}

	@Override
	public Result add(Candidate candidate) {
		if (this.candidateCheckService.isCitizenIdUnique(candidate).isSuccess() && this.userCheckService.isUniqueEmail(candidate).isSuccess() && this.candidateCheckService.isValidCandidate(candidate).isSuccess()) {
			this.candidateDao.save(candidate);
			return new SuccessResult(this.emailSendService.sendMailToUser("Bu maili okuyorsanız kullanıcı ön kaydınız yapılmıştır. Mail adresini onaylamak için tıklayınız."));
		} else {
			return new ErrorResult(this.candidateCheckService.isValidCandidate(candidate).getMessage() + this.candidateCheckService.isCitizenIdUnique(candidate).getMessage() + this.userCheckService.isUniqueEmail(candidate).getMessage());
		}
	}

	@Override
	public DataResult<List<CandidateResumeDto>> getCompleteCandidateResumes() {
		return new SuccessDataResult<List<CandidateResumeDto>>(this.candidateDao.getCompleteCandidateResumes(), "Data Listelendi");
	}

	
	
}
