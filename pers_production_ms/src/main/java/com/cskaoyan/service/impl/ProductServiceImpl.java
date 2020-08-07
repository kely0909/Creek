package com.cskaoyan.service.impl;

import com.cskaoyan.dao.ProductMapper;
import com.cskaoyan.domain.Product;
import com.cskaoyan.domain.ProductExample;
import com.cskaoyan.domain.customize.EUDataGridResult;
import com.cskaoyan.domain.objUtils.CustomResult;
import com.cskaoyan.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMapper productMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, Product product) throws Exception{
		//查询产品列表
		ProductExample example = new ProductExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<Product> list = productMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Product> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public Product get(String string) throws Exception{
		
		return productMapper.selectByPrimaryKey(string);
	}

	@Override
	public CustomResult delete(String string) throws Exception{
		int i = productMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception{
		int i = productMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(Product product) throws Exception{
		int i = productMapper.insert(product);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增产品信息失败");
		}
	}

	@Override
	public CustomResult update(Product product) throws Exception{
		int i = productMapper.updateByPrimaryKeySelective(product);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改产品信息失败");
		}
	}

	@Override
	public CustomResult updateAll(Product product) throws Exception{
		int i = productMapper.updateByPrimaryKey(product);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改产品信息失败");
		}
	}

	@Override
	public CustomResult updateNote(Product product) throws Exception{
		int i = productMapper.updateNote(product);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改产品介绍失败");
		}
	}
	
	@Override
	public List<Product> find() throws Exception{
		ProductExample example = new ProductExample();
		return productMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchProductByProductName(int page, int rows,
			String productName) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<Product> list = productMapper.searchProductByProductName(productName);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Product> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchProductByProductId(int page, int rows,
			String productId) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<Product> list = productMapper.searchProductByProductId(productId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Product> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchProductByProductType(int page, int rows,
			String productType) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<Product> list = productMapper.searchProductByProductType(productType);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Product> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
}
