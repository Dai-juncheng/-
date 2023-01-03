package com.dai.service;

import com.dai.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 戴博
 * @since 2022-08-07
 */
public interface IMenuService extends IService<Menu> {

    List<Menu> findMenus(String name);
}
