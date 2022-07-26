package com.wenso.codesegment.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Book {
    //id自增
    @TableId(type = IdType.AUTO)
    int id;
    public String name;
    public Integer price;

}