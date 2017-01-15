package console.service; 

import java.util.List;

import console.entity.Product;

public interface ProductService {

	//查询某个商品
	public Product queryProductByID(String productId) throws Exception;	
	
	//查询所有商品
	public List<Product> queryProducts() throws Exception;
	
	//保存商品
	public boolean saveProduct(Product product) throws Exception;
}
