package kodlamaio.hrms.api;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.concretes.User;

@RestController
@RequestMapping("/api/JobAdvertisements")
@CrossOrigin
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	};
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getJobAdvertisementByIsActive")
	public Result getJobAdvertisementByIsActive(@RequestParam boolean isActive) {
		return this.jobAdvertisementService.getJobAdvertisementByIsActive(isActive);
	}
	
	@GetMapping("/getJobAdvertisementByIsActiveAndCreationDate")
	public DataResult<List<JobAdvertisement>> getJobAdvertisementByIsActiveAndCreationDate(@RequestParam boolean isActive, @RequestParam String creationDate){
		return this.jobAdvertisementService.getJobAdvertisementByIsActiveAndCreationDate(isActive, LocalDate.parse(creationDate));
	}
	
	@GetMapping("/getJobAdvertisementByIsActiveAndEmloyerId")
	public DataResult<List<JobAdvertisement>> getJobAdvertisementByIsActiveAndEmloyerId(@RequestParam boolean isActive, @RequestParam Integer employerId){
		return this.jobAdvertisementService.getJobAdvertisementByIsActiveAndEmloyerId(isActive, employerId);
	}
	
	@GetMapping("/getjobadvertisementbyid")
	public DataResult<JobAdvertisement>getJobAdvertisementById(@RequestParam Integer Id){
		return this.jobAdvertisementService.getJobAdvertisementById(Id);
	}
	
	@PostMapping("/jobadvertisementsetstatus")
	public Result jobAdvertisementSetStatus (@RequestParam int userId, int jobAdvetisementWillBeUpdatedId, boolean isActive) {
		return this.jobAdvertisementService.jobAdvertisementSetStatus(userId, jobAdvetisementWillBeUpdatedId, isActive);
	}
	
	@PostMapping("/jobAdvertisementApprove")
	public Result jobAdvertisementApprove(@RequestParam int userId, int jobAdvetisementWillBeUpdatedId) {
		return this.jobAdvertisementService.jobAdvertisementApprove(userId, jobAdvetisementWillBeUpdatedId);
	}
	
	@GetMapping("/getAllUnapproved")
	public DataResult<List<JobAdvertisement>> getAllUnapproved() {
		return this.jobAdvertisementService.getAllUnapproved();
	}
	
	@GetMapping("/getjobadvertisementbyemployerid")
	public DataResult<List<JobAdvertisement>>getJobAdvertisementByEmployerId(@RequestParam Integer employerId){
		return this.jobAdvertisementService.getJobAdvertisementByEmployerId(employerId);
	}
}
