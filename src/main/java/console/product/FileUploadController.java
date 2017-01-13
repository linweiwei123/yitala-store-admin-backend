package console.product;

import java.util.Date;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import common.Constants;
import utils.DateUtils;

@RestController
@RequestMapping(value="/api")
public class FileUploadController {

    //设置好账号的ACCESS_KEY和SECRET_KEY
    private String ACCESS_KEY = "ei1uOdGpVLliA7kb50sLcV9i4wfYLPwt5v0shU10";
    private String SECRET_KEY = "-pFFIY-ew35Exyfcd67Sbaw40k15ah3UfZTFWFKF";
    //要上传的空间
    private String bucketname = "yitalastore";

    //密钥配置
    private Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    ///////////////////////指定上传的Zone的信息//////////////////
    //第一种方式: 指定具体的要上传的zone
    //注：该具体指定的方式和以下自动识别的方式选择其一即可
    //要上传的空间(bucket)的存储区域为华东时
    // Zone z = Zone.zone0();
    //要上传的空间(bucket)的存储区域为华北时
    // Zone z = Zone.zone1();
    //要上传的空间(bucket)的存储区域为华南时
    //private  Zone z = Zone.zone2();
    //第二种方式: 自动识别要上传的空间(bucket)的存储区域是华东、华北、华南。
    Zone z = Zone.autoZone();
    private Configuration c = new Configuration(z);

    //创建上传对象
    private UploadManager uploadManager = new UploadManager(c);
    
	 @RequestMapping(value="/fileupload",headers = "Content-Type= multipart/form-data")
	    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes) throws Exception {
		 ImageModel imageModel = null;
		 	
			try {
				Date now = new Date();
				String time = DateUtils.format(now, "yyyyMMdd");
				String key =time  +"_"+ file.getOriginalFilename(); 
				uploadManager.put(file.getBytes(), key, getUpToken());			
				UUID imgId = UUID.randomUUID();
				String fileUrl = Constants.QiniuBaseUrl + key;
				imageModel = new ImageModel(imgId.toString(),now,file.getOriginalFilename(),fileUrl);
			} catch (QiniuException  e) {
				   Response r = e.response;
				   return new ResponseEntity<String>(r.toString(), HttpStatus.BAD_REQUEST);
			}
			//throw new Exception("错误");
	        return new ResponseEntity<ImageModel>(imageModel, HttpStatus.OK);
	    }
	 
	  //简单上传，使用默认策略，只需要设置上传的空间名就可以了
	    public String getUpToken() {
	        return auth.uploadToken(bucketname);
	    }
}
