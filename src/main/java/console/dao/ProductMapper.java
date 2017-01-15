package console.dao;

import java.util.List;

import console.entity.Product;

public interface ProductMapper {
    int deleteByPrimaryKey(String productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(String productId);

    List<Product> selectAllProducts();
    
    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}