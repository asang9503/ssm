package com.qfedu.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qfedu.pojo.Classes;

//@Repository
public interface ClassesMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Classes record);

	int insertSelective(Classes record);

	Classes selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Classes record);

	int updateByPrimaryKey(Classes record);

	public List<Classes> select();

}