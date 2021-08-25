package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.business.abstracts.UserCheckService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class UserCheckManager implements UserCheckService {

	
	private UserDao userDao;
	
	@Autowired
	public UserCheckManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	
	@Override
	public Result isUniqueEmail(User user) {
		if (userDao.getUserByEmail(user.getEmail()) != null){
			return new ErrorResult("Kayıtlı Email adresi. Email adresini kontrol ediniz.");
		} else {
			return new SuccessResult("Email kayıt için uygun.");
		}
	}

}
