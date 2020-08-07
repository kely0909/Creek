package com.cskaoyan.dao;

import com.cskaoyan.domain.Product;
import com.cskaoyan.domain.ProductExample;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface ProductMapper {
	
	//扩展的mapper接口方法
	int deleteBatch(String[] ids);
	
	int changeStatus(String[] ids);
	
	int updateNote(Product record);
	
	List<Product> searchProductByProductName(String productName);
	
	List<Product> searchProductByProductId(String productId);
	
	List<Product> searchProductByProductType(String productType);
	
	//逆向工程生成的mapper接口
    int countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(String productId);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(String productId);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}