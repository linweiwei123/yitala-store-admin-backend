package console.controller;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import console.entity.Product;
import console.model.ProductModel;
import console.service.ProductService;

@RestController
@RequestMapping(value="/api")
public class ProductController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductService productService;
	
	//保存商品
	@RequestMapping(value="/product", produces = "application/json; charset=utf-8",method = RequestMethod.POST)
	public ResponseEntity<String> saveProduct(@RequestBody ProductModel sourceProduct){
		Product targetProduct = new Product();
		BeanUtils.copyProperties(sourceProduct, targetProduct);
		UUID uuid = UUID.randomUUID();
		String images = "";
		for(int i=0;i<sourceProduct.getImages().size();i++){
			images +=sourceProduct.getImages().get(i).getFileUrl()+",";
		}
		sourceProduct.getImages();
		targetProduct.setProductId(uuid.toString());
		targetProduct.setImages(images);
		try {
			productService.saveProduct(targetProduct);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	//查询某个商品
	@RequestMapping(value="/product/{id}", produces = "application/json; charset=utf-8",method = RequestMethod.GET)
	public ResponseEntity<Product> getProduct(@PathVariable("id") String product_id) throws Exception{
		Product product = productService.queryProductByID(product_id);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	//查询某个商品
	@RequestMapping(value="/product", produces = "application/json; charset=utf-8",method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProduct() throws Exception{
		List<Product> products = productService.queryProducts();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
}
