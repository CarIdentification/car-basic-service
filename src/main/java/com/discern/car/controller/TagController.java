package com.discern.car.controller;

import com.discern.car.common.Page;
import com.discern.car.common.PageResult;
import com.discern.car.common.Result;
import com.discern.car.entity.Tag;
import com.discern.car.service.TagService;
import com.discern.car.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：celineou
 * @date ：Created in 2019/4/12
 * @description：
 */

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(Tag tag) {
        tagService.insert(tag);
        return Result.newSuccess();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result delete(Integer id) {
        tagService.deleteByPrimaryKey(id);
        return Result.newSuccess();
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public Result<Tag> get(Integer id) {
        Tag tag = BeanUtil.copy(tagService.selectByPrimaryKey(id), Tag.class);
        return Result.newSuccess(tag);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result update(Tag tag) {
        tagService.updateByPrimaryKeySelective(tag);
        return Result.newSuccess();
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public PageResult<Tag> list(Page page) {
        PageResult<Tag> result = tagService.list(page);
        return result;
    }


}
