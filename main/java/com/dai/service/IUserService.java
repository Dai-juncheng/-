package com.dai.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dai.controller.dto.UserDTO;
import com.dai.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 戴博
 * @since 2022-08-07
 */
public interface IUserService extends IService<User> {

    UserDTO login(UserDTO userDTO);

    User register(UserDTO userDTO);



}