package com.qfedu.mapper;

import org.springframework.stereotype.Repository;

import com.qfedu.pojo.User;

@Repository
public interface UserMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	User selectByNameAndPass(User user);
}