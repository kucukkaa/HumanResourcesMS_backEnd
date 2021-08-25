package kodlamaio.hrms.core.utilities.adapters.concretes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.adapters.abstracts.ImageUploadService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;


public class CloudinaryAdapter implements ImageUploadService {

    private final Cloudinary cloudinary;

    public CloudinaryAdapter(){
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "djxvzwcwj");
        config.put("api_key", "522676541384295");
        config.put("api_secret", "_l5dOmcTwPlrcZYajRsP6qeRj5U");
        cloudinary = new Cloudinary(config);
    }

    public DataResult<Map<String, String>> upload(MultipartFile multiPartFile) {
        File file;

        try{
            file = convert(multiPartFile);
            Map<String, String> result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            file.delete();
            return new SuccessDataResult<Map<String, String>>(result);
        }
        catch (IOException exception){
            exception.printStackTrace();
            return new ErrorDataResult<Map<String, String>>("hata!!!");
        }
    }

    public DataResult<Map> delete (String id) throws IOException {
        Map result = cloudinary.uploader().destroy(id,ObjectUtils.emptyMap());
        return new SuccessDataResult<Map>(result);
    }

    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();
        return file;
    }
}