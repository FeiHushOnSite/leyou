package com.leyou.item.mapper;

import com.leyou.item.pojo.Category;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface CategoryMapper {
    List<Category> selectAllCategory(Long pid);
}
