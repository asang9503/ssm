package com.qfedu.mapper;

import com.qfedu.pojo.StoryUser;

public interface StoryUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StoryUser record);

    int insertSelective(StoryUser record);

    StoryUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StoryUser record);

    int updateByPrimaryKey(StoryUser record);
}