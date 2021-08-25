package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkingPlaceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkingPlaceDao;
import kodlamaio.hrms.entities.concretes.WorkingPlace;

@Service
public class WorkingPlaceManager implements WorkingPlaceService {

	private WorkingPlaceDao workingPlaceDao;
	
	public WorkingPlaceManager(WorkingPlaceDao workingPlaceDao) {
		super();
		this.workingPlaceDao = workingPlaceDao;
	}

	@Override
	public DataResult<List<WorkingPlace>> getAll() {
		return new SuccessDataResult<List<WorkingPlace>>(this.workingPlaceDao.findAll(), "Data Listelendi");
	}

}
