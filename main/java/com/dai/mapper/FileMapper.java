package com.dai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dai.entity.Files;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface FileMapper  extends BaseMapper<Files> {
}
