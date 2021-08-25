package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.dataAccess.abstracts.StaffMemberDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	private UserDao userDao;
	private StaffMemberDao staffMemberDao;
		
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, UserDao userDao, StaffMemberDao staffMemberDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.userDao = userDao;
		this.staffMemberDao = staffMemberDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>> (this.jobAdvertisementDao.findAll());
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getAllUnapproved(){
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getJobAdvertisementByIsApproved(false));
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı kaydedildi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getJobAdvertisementByIsActive(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getJobAdvertisementByIsActive(isActive));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getJobAdvertisementByIsActiveAndCreationDate(boolean isActive, LocalDate creationDate) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getJobAdvertisementByIsActiveAndCreationDate(isActive, creationDate));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getJobAdvertisementByIsActiveAndEmloyerId(boolean isActive, Integer employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getJobAdvertisementByIsActiveAndEmployerId(isActive, employerId));
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getJobAdvertisementByEmployerId(Integer employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getJobAdvertisementByEmployerId(employerId));
	}
	
	@Override
	public Result jobAdvertisementSetStatus (int userId, int jobAdvetisementWillBeUpdatedId, boolean isActive) {
		var tempJobAdv = this.jobAdvertisementDao.getOne(jobAdvetisementWillBeUpdatedId);
		var user = this.userDao.getOne(userId);
		if (user.getUserType().getUserTypeId()==2 && tempJobAdv.getEmployer().getId() == user.getId()) {
			tempJobAdv.setActive(isActive);
			this.jobAdvertisementDao.save(tempJobAdv);
			return new SuccessResult("İlan durumu değiştirildi.");//bir employer'a ait olmalı ve o employer ilanı açan employer olmalı
		} else {
			return new ErrorResult("Bu işlem için yetkiniz yok.");
		}
	}

	@Override
	public DataResult<JobAdvertisement> getJobAdvertisementById(Integer Id) {
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getOne(Id), "İş ilanı getirildi");
	}

	@Override
	public Result jobAdvertisementApprove(int userId, int jobAdvetisementWillBeUpdatedId) {
		var tempJobAdv = this.jobAdvertisementDao.getOne(jobAdvetisementWillBeUpdatedId);
		var staffMember = this.staffMemberDao.getOne(userId);
		tempJobAdv.setStaffMember(staffMember);
		tempJobAdv.setApproved(true);
		this.jobAdvertisementDao.save(tempJobAdv);
		return new SuccessResult("İlan onaylandı.");
	}

}
