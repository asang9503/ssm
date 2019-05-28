package com.qfedu.mapper;

import java.util.List;

import com.qfedu.pojo.Story;

public interface StoryMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Story record);

	int insertSelective(Story record);

	Story selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Story record);

	int updateByPrimaryKey(Story record);

	List<Story> selectStoryOrder();
}