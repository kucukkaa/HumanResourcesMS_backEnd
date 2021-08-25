package kodlamaio.hrms.business.concretes;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidateResumeService;
import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateResumeDao;
import kodlamaio.hrms.entities.concretes.CandidateResume;

@Service
public class CandidateResumeManager implements CandidateResumeService {

	private CandidateResumeDao candidateResumeDao;
	private ImageService imageService;
	
	@Autowired
	public CandidateResumeManager(CandidateResumeDao candidateResumeDao, ImageService imageService) {
		super();
		this.candidateResumeDao = candidateResumeDao;
		this.imageService = imageService;
	}

	@Override
	public DataResult<List<CandidateResume>> getAll() {
		return new SuccessDataResult<List<CandidateResume>>(this.candidateResumeDao.findAll());
		
	}

	@Override
	public Result add(CandidateResume candidateResume, MultipartFile file) throws IOException {
		var result = this.imageService.add(file);
		candidateResume.setUserImage(result.getMessage());
		this.candidateResumeDao.save(candidateResume);
		return new SuccessResult("Özgeçmişiniz kaydedildi!");
	}

}
