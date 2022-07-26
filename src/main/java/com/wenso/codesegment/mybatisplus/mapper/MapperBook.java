package com.wenso.codesegment.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wenso.codesegment.mybatisplus.entity.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MapperBook extends BaseMapper<Book> {

}