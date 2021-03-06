package com.msr.hotel.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@ApiModel(value = "customerinfo查询对象", description = "客人信息查询对象封装")
@Data
public class CustomerinfoQuery implements Serializable {
    @ApiModelProperty(value = "客户姓名")
    private String customerName;

    @ApiModelProperty(value = "客户联系电话")
    private String customerinfoTel;

    @ApiModelProperty(value = "客户生日")
    private String customerinfoBirthday;

    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String begin;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换

    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")
    private String end;
}
