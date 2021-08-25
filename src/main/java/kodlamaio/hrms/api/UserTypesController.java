package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.UserTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.UserType;

@RestController
@RequestMapping("/api/usertypes")
public class UserTypesController {

	private UserTypeService userTypeService;

	@Autowired
	public UserTypesController(UserTypeService userTypeService) {
		super();
		this.userTypeService = userTypeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<UserType>> getAll(){
		return this.userTypeService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody UserType userType) {
		return this.userTypeService.add(userType);
	}
}
