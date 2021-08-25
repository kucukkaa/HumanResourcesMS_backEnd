package kodlamaio.hrms.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateResume;

public interface CandidateResumeService {

	DataResult<List<CandidateResume>> getAll();
	Result add(CandidateResume candidateResume, MultipartFile file) throws IOException;
}
