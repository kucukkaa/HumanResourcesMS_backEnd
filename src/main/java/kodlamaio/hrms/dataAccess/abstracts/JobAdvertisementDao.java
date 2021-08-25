package kodlamaio.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> getJobAdvertisementByIsActive(boolean isActive);	
	List<JobAdvertisement> getJobAdvertisementByIsActiveAndCreationDate(boolean isActive, LocalDate creationDate);
	List<JobAdvertisement> getJobAdvertisementByIsActiveAndEmployerId(boolean isActive, Integer employerId);
	List<JobAdvertisement> getJobAdvertisementByIsApproved(boolean isApproved);
	List<JobAdvertisement> getJobAdvertisementByEmployerId(Integer employerId);

}
