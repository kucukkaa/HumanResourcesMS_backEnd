package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.utilities.adapters.abstracts.ImageUploadService;
import kodlamaio.hrms.core.utilities.adapters.concretes.CloudinaryAdapter;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class ImageManager implements ImageService {

	
	public final ImageUploadService imageUploadService= new CloudinaryAdapter();
	
	@Autowired
	public ImageManager() {
		
	}
	
	@Override
	public Result add(MultipartFile file) {		
		var result = imageUploadService.upload(file);
		return new SuccessResult(result.getData().get("url"));
		
	}

	

}
