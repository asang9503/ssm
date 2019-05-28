package com.qfedu.mapper;

import org.springframework.stereotype.Repository;

import com.qfedu.pojo.StuCls;
@Repository
public interface StuClsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StuCls record);

    int insertSelective(StuCls record);

    StuCls selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StuCls record);

    int updateByPrimaryKey(StuCls record);
}