package console.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import console.dao.ProductMapper;
import console.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductMapper productMapper;
	
	public Product queryProductByID(String productId) throws Exception {
		Product product = null;
		try {
			product = productMapper.selectByPrimaryKey(productId);
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new Exception(e);
		}
		return product;
	}

	
	
	public boolean saveProduct(Product product) throws Exception {
		int result = productMapper.insertSelective(product);
		if(result>0){
			return true;
		}
		return false;
	}



	public List<Product> queryProducts() throws Exception {
		List<Product> products = productMapper.selectAllProducts();
		return products;
	}

}
