package com.msr.serviceaccount.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.common.msrUtil.R;
import com.msr.common.utils.Query;
import com.msr.serviceaccount.entity.HotelConsume;
import com.msr.serviceaccount.mapper.HotelConsumeMapper;
import com.msr.serviceaccount.query.ConsumeQuery;
import com.msr.serviceaccount.query.CustomerIdQuery;
import com.msr.serviceaccount.service.HotelConsumeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PrivateKey;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
@CrossOrigin // 跨域
@Api(description = "消费信息查询")
@RestController
@RequestMapping("/hotel/consume")
public class HotelConsumeController {
    @Autowired
    private HotelConsumeService consumeService;

    private HotelConsumeMapper consumeMapper;
    @ApiOperation("所有消费信息")
    @GetMapping("findAll")
    public R list(){
        List<HotelConsume> list = consumeService.list(null);
        return R.ok().data("consumes",list);
    }
//    @ApiOperation(value = "所有客人入住信息列表")
//    @GetMapping("list")
//    public R list(){
//        List<Customer> list = customerService.list(null);
//        return R.ok().data("cutomers", list);
//    }
//
    @ApiOperation(value = "新增账务信息")
    @PostMapping("save")
    public R save(
            @ApiParam(name = "consume", value = "账务信息对象", required = true)
            @RequestBody HotelConsume consume){
        System.out.println(consume);
        consumeService.save(consume);
        return R.ok();
    }

    @ApiOperation(value = "根据账单ID删除收入账户信息")
    @DeleteMapping("{id}")
    public R removeById(
            @ApiParam(name = "id", value = "账户ID", required = true)
            @PathVariable String id){
        consumeService.removeById(id);
        return R.ok();
    }

    @ApiOperation(value = "根据账务ID修改账务信息")
    @PutMapping("{id}")
    public R updateById(
            @ApiParam(name = "id", value = "账务ID", required = true)
            @PathVariable String id,

            @ApiParam(name = "consume", value = "账务信息对象", required = true)
            @RequestBody HotelConsume consume) {

        consume.setConsumeId(id);
        consumeService.updateById(consume);
        return R.ok();
    }

    @ApiOperation(value = "根据账务ID查询账务信息")
    @GetMapping("{id}")
    public R getById(
            @ApiParam(name = "id", value = "账务ID", required = true)
            @PathVariable String id){

        HotelConsume consume = consumeService.getById(id);
        return R.ok().data("items", consume);
    }

//    @ApiOperation(value = "根据客户ID查询账务信息")
//    @GetMapping("customerid/{customerId}")
//    public R getByCustomerId(
//            @ApiParam(name = "customerId", value = "客户ID", required = true)
//            @PathVariable String customerId){
//        List<HotelConsume> consume = consumeService.getByCustomerId(customerId);
//        System.out.println(consume);
//        return R.ok().data("item", consume);
//    }
    @ApiOperation(value = "根据客户ID查询账务信息")
    @GetMapping("{page}/{limit}")
    public R getByCustomerId(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "customerIdQuery", value = "查询对象", required = false)
                    CustomerIdQuery customerIdQuery){

        Page<HotelConsume> pageParam = new Page<>(page, limit);

        consumeService.getByCustomerId(pageParam,customerIdQuery);
        List<HotelConsume> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return  R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation(value = "账务信息分页列表")
    @GetMapping("page/{page}/{limit}")
    public R pageQuery(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "consumeQuery", value = "查询对象", required = false)
                    ConsumeQuery consumeQuery){

        Page<HotelConsume> pageParam = new Page<>(page, limit);

        consumeService.pageQuery(pageParam, consumeQuery);
        List<HotelConsume> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return  R.ok().data("total", total).data("rows", records);
    }


}

