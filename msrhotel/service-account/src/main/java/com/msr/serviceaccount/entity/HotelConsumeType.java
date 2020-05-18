package com.msr.serviceaccount.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="HotelConsumeType对象", description="")
public class HotelConsumeType implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "消费类型ID,主键")
    @TableId(value = "consume_type_id", type = IdType.ID_WORKER_STR)
    private Integer consumeTypeId;

    @ApiModelProperty(value = "消费类型名称")
    private String consumeTypeName;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    private Boolean isDeleted;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private Date gmtModified;


}
