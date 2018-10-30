package com.iheart.iHeart.Media.repository;

import java.util.List;
import java.util.Optional;
 

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.iheart.iHeart.Media.model.Advertiser;
import com.iheart.iHeart.Media.model.Student;

@Mapper
public interface AdvertiserRepository {	 

	@Select("SELECT * FROM ADVERTISER WHERE id = #{id}")
	public Advertiser getById(long id);

	@Delete("DELETE FROM ADVERTISER WHERE id = #{id}")
	public int deleteById(long id);

	@Insert("INSERT INTO ADVERTISER(id, name, contactName, creditLimit) VALUES (#{id}, #{name}, #{contactName}, #{creditLimit})")
	public int insert(Advertiser advertiser);
	
	@Update("UPDATE ADVERTISER SET name=#{name}, contactName=#{contactName}, creditLimit=#{creditLimit} where id=#{id}")
	public int update(Advertiser advertiser);
	
	@Select("SELECT * FROM ADVERTISER")
	public List<Advertiser> getAll();
	
	@Update("UPDATE ADVERTISER SET creditLimit=#{creditLimit} where id=#{id}")
	public int updateCreditLimit(Advertiser advertiser);	
}
