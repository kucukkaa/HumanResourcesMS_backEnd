package kodlamaio.hrms.api;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidateResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateResume;


@RestController
@RequestMapping("/api/candidateresume")
@CrossOrigin
public class CandidateResumeController {

	private CandidateResumeService candidateResumeService;

	@Autowired
	public CandidateResumeController(CandidateResumeService candidateResumeService) {
		super();
		this.candidateResumeService = candidateResumeService;
	}
	
	@GetMapping("/getall")
	DataResult<List<CandidateResume>> getAll(){
		return this.candidateResumeService.getAll();
	}
	
	@PostMapping("/add")
	Result add(@RequestBody CandidateResume candidateResume, @RequestBody MultipartFile file) throws IOException {
		return this.candidateResumeService.add(candidateResume, file);
	}
	
	
}
