package com.qfedu.mapper;

import java.util.List;

import com.qfedu.pojo.StoryImg;

public interface StoryImgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StoryImg record);

    int insertSelective(StoryImg record);

    StoryImg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StoryImg record);

    int updateByPrimaryKey(StoryImg record);
    
    int inserts(List<StoryImg> storyImgs);
}