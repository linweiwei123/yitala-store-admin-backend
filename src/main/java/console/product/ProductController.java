package console.product;

import org.eclipse.jetty.util.ajax.JSON;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import console.model.ProductModel;

@RestController
@RequestMapping(value="/api")
public class ProductController {

	@RequestMapping(value="/product", produces = "application/json; charset=utf-8",method = RequestMethod.POST)
	public ResponseEntity<String> saveProduct(@RequestBody ProductModel product){
		System.out.println(product.toString());
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
}
