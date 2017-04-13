package dao;

import Entity.ProductType;

public interface ProductTypeDao {
	
	//向数据库里添加一个品类
	public void addProductType(ProductType ptye);
	
	//修改某品类
	public void modifyProductType(ProductType ptye);
	
	
	
	//TODO
	
	
	
	//根据id获得品类
	public ProductType getProductTypeByID(int id);
	
	
	//根据品类名获得品类
	public ProductType getProductTypeByName(String name);
	
}
