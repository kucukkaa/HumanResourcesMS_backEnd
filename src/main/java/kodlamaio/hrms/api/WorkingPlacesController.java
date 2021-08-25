package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkingPlaceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.WorkingPlace;

@RestController
@RequestMapping("/api/workingplaces")
@CrossOrigin
public class WorkingPlacesController {

	private WorkingPlaceService workingPlaceService;

	public WorkingPlacesController(WorkingPlaceService workingPlaceService) {
		super();
		this.workingPlaceService = workingPlaceService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<WorkingPlace>> getAll() {
		return this.workingPlaceService.getAll();
	}
	
}
