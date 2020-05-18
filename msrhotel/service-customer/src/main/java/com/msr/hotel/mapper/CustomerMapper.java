package com.msr.hotel.mapper;

import com.msr.hotel.entity.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */

@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {

}
