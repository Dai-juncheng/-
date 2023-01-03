package com.dai.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dai.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 戴博
 * @since 2022-08-07
 */
@Mapper
public interface UserMapper extends BaseMapper<User>{


}
