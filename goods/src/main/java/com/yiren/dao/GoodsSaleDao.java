package com.yiren.dao;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.yiren.entity.GoodsSale;
/**
 *
 * @author peng
 *
 */
public interface GoodsSaleDao {
	@Insert(value="insert into TM_GOODS_SALE(buyer,goods_name,address,phone,seller,price,debt,repay,remark,buy_Time,create_Time,state)"
			+ "values(#{buyer},#{goodsName},#{address},#{phone},#{seller},#{price},#{debt},#{repay},#{remark},#{buyTime},#{createTime},#{state})")
	public int insertGoodsSale(GoodsSale goodsSale);

@Select("select * from TM_GOODS_SALE ORDER BY ID DESC")
	public List<GoodsSale>  findGoodsSale(GoodsSale goodsSale);
}
