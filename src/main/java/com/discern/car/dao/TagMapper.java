package com.discern.car.dao;

import com.discern.car.common.Page;
import com.discern.car.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TagMapper {
    int deleteByPrimaryKey(Integer tagId);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Integer tagId);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

    List<Tag> selectByUserId(Integer userId);

    List<Tag> list(@Param("page") Page page);

    int insertTagWithUserId(@Param("userId") Integer userId, @Param("tagId") Integer tagId);

    List<Tag> selectNoHasByUserId(Integer userId);

    int selectCount();

    int removeTagWithUserId(@Param("userId") Integer userId, @Param("tagId") Integer tagId);


}