package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PositionCheckService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PositionDao;
import kodlamaio.hrms.entities.concretes.Position;

@Service
public class PositionCheckManager implements PositionCheckService {

	private PositionDao positionDao;
	
	
	
	public PositionCheckManager(PositionDao positionDao) {
		super();
		this.positionDao = positionDao;
	}



	@Override
	public Result isJobTitleUnique(Position position) {
		
		if (this.positionDao.getPositionByJobTitle(position.getJobTitle().trim()) == null) {
			return new SuccessResult();
		}
		return new ErrorResult("Bu iş pozisyonu kaydı mevcut");
	}

}
