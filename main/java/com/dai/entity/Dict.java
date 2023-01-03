package com.dai.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author 戴博
 * @since 2022-08-07
 */
@TableName("sys_dict")
@Data
public class Dict {

    private String name;
    private String value;
    private String type;

}
