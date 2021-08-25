package kodlamaio.hrms.business.abstracts;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.concretes.User;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAll();
	Result add(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisement>> getJobAdvertisementByIsActive(boolean isActive);
	DataResult<List<JobAdvertisement>> getJobAdvertisementByIsActiveAndCreationDate(boolean isActive, LocalDate creationDate);
	DataResult<List<JobAdvertisement>> getJobAdvertisementByIsActiveAndEmloyerId(boolean isActive, Integer employerId);
	DataResult<List<JobAdvertisement>> getJobAdvertisementByEmployerId(Integer employerId);
	DataResult<JobAdvertisement> getJobAdvertisementById(Integer Id);
	
	Result jobAdvertisementSetStatus (int userId, int jobAdvetisementWillBeUpdatedId, boolean isActive);
	Result jobAdvertisementApprove(int userId, int jobAdvetisementWillBeUpdatedId);
	DataResult<List<JobAdvertisement>> getAllUnapproved();
}
