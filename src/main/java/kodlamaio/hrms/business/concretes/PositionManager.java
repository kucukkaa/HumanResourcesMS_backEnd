package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PositionCheckService;
import kodlamaio.hrms.business.abstracts.PositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PositionDao;
import kodlamaio.hrms.entities.concretes.Position;

@Service
public class PositionManager implements PositionService {

	private PositionDao positionDao;
	private PositionCheckService positionCheckService;
	
	@Autowired
	public PositionManager(PositionDao positionDao, PositionCheckService positionCheckService) {
		super();
		this.positionDao = positionDao;
		this.positionCheckService = positionCheckService;
	}

	@Override
	public DataResult<List<Position>> getAll() {
		return new SuccessDataResult<List<Position>>(this.positionDao.findAll());
	}

	@Override
	public Result add(Position position) {
		if (this.positionCheckService.isJobTitleUnique(position).isSuccess()) {
			this.positionDao.save(position);
			return new SuccessResult("İş Pozisyonu kaydı yapıldı.");
		}
		return new ErrorResult(this.positionCheckService.isJobTitleUnique(position).getMessage());
	}
	
}
