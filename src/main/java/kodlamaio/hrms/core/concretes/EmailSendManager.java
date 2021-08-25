package kodlamaio.hrms.core.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.EmailSendService;

@Service
public class EmailSendManager implements EmailSendService{

	@Override
	public String sendMailToUser(String message) {
		return message;
	}
	
	
}
