package com.yiren.dao;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.yiren.entity.GoodsInfo;

public interface GoodsInfoDao {
	@Insert(value="insert into goodsinfo(name,styleid,zoneid,pictureurl,description,price,time,state)"
			+ "values(#{name},#{styleid},#{zoneid},#{pictureurl},#{description},#{price},#{time},#{state})")
	public int insertGoodsInfo(GoodsInfo goodsInfo );

@Select("select * from goodsinfo  where state=1")
	public List<GoodsInfo>  findGoodsInfo(GoodsInfo goodsInfo);
}
