package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserTypeDao;
import kodlamaio.hrms.entities.concretes.UserType;

@Service
public class UserTypeManager implements UserTypeService {

	private UserTypeDao userTypeDao;
	
	public UserTypeManager(UserTypeDao userTypeDao) {
		super();
		this.userTypeDao = userTypeDao;
	}

	@Override
	public DataResult<List<UserType>> getAll() {
		return new SuccessDataResult<List<UserType>>(this.userTypeDao.findAll(), "Data Listelendi.");
	}

	@Override
	public Result add(UserType userType) {
		this.userTypeDao.save(userType);
		return new SuccessResult("Yeni Kullanıcı Tipi Eklendi.");
	}

}
