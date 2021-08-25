package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCheckService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.validators.ValidatorService;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateCheckManager implements CandidateCheckService {

	private CandidateDao candidateDao;
	private ValidatorService validatorService;
	
	public CandidateCheckManager(CandidateDao candidateDao, ValidatorService validatorService) {
		super();
		this.candidateDao = candidateDao;
		this.validatorService = validatorService;
	}

	@Override
	public Result isCitizenIdUnique(Candidate candidate) {
		if (this.candidateDao.getCandidateByCitizenId(candidate.getCitizenId()) != null){
			return new ErrorResult("Bu TC Kimlik numarası ile daha önce kayıt yapılmış. Lütfen kontrol ediniz.");
		} else {
			return new SuccessResult("TC kimlik numarası kayıt için uygun.");
		}
	}
	
	@Override
	public Result isValidCandidate(Candidate candidate) {
		
		return this.validatorService.isValidUser(candidate);
	}
}
