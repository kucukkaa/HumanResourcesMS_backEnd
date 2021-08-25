package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.abstracts.EmailSendService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private UserDao userDao;
	private EmailSendService emailSendService;
	
	@Autowired
	public UserManager(UserDao userDao, EmailSendService emailSendService) {
		super();
		this.userDao = userDao;
		this.emailSendService = emailSendService;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult(this.emailSendService.sendMailToUser("Bu maili okuyorsanız kullanıcı kaydınız yapılmıştır. Mail adresini onaylamak için tıklayınız."));
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Tüm Kullanıcılar Listelendi.");
	}

	@Override
	public User getUserByEmail(User user) {
		return this.userDao.getUserByEmail(user.getEmail());
	}
	
	
}
