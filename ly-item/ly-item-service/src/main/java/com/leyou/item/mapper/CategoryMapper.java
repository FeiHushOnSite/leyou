package com.leyou.item.mapper;

import com.leyou.item.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * describe:
 *
 * @author xxx
 * @date 2019/03/04
 */
@Mapper
public interface CategoryMapper {

    List<Category> select(Category category);
}
