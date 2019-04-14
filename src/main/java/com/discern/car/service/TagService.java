package com.discern.car.service;

import com.discern.car.common.Page;
import com.discern.car.common.PageResult;
import com.discern.car.common.Result;
import com.discern.car.entity.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Keben on 2018-05-12.
 */
public interface TagService {
    Result<Boolean> deleteByPrimaryKey(Integer tagId);

    Result<Integer> insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Integer tagId);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

    List<Tag> selectByUserId(Integer userId);
    PageResult<Tag> list(Page page);

    int insertTagWithUserId(Integer userId,Integer TagId);

    List<Tag> selectNoHasByUserId(Integer userId);

    int selectCount();

    int removeTagWithUserId(@Param("userId")Integer userId, @Param("tagId")Integer tagId);


}
