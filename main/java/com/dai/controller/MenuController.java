package com.dai.controller;


import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.common.Constants;
import com.dai.mapper.DictMapper;
import com.dai.service.IDictService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.common.Result;

import com.dai.service.IMenuService;
import com.dai.entity.Menu;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 戴博
 * @since 2022-08-07
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Resource
    private DictMapper dictmapper;

    @Resource
    private IMenuService menuService;

    // 新增或者更新
    @PostMapping
    public Result save(@RequestBody Menu menu) {
        menuService.saveOrUpdate(menu);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        menuService.removeById(id);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        menuService.removeByIds(ids);
        return Result.success();
    }

    @GetMapping
    public Result findAll(@RequestParam(defaultValue = "") String name) {
        //查询所有
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("name",name);
        List<Menu> list=menuService.list();
        //找出pid为null的一级菜单
        List<Menu> parentNode=list.stream().filter(menu -> menu.getPid()==null).collect(Collectors.toList());
        for (Menu menu:parentNode
             ) {
            menu.setChildren(list.stream().filter(m->menu.getId().equals(m.getPid())).collect(Collectors.toList()));        }
        return Result.success(parentNode);
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(menuService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                           @RequestParam String name) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.orderByDesc("name",name);
        return Result.success(menuService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

    @GetMapping("/icons")
    public Result getItems(){
        QueryWrapper<Object> wrapper = new QueryWrapper<>();
        wrapper.eq("type", Constants.DICT_TYPE_ICON);
        return Result.success(dictmapper.selectList(null));
    }
}

