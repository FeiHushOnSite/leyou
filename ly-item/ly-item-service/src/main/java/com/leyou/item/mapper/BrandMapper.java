package com.leyou.item.mapper;

import com.leyou.item.pojo.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * describe:
 *
 * @author xxx
 * @date 2019/06/16
 */
@Mapper
public interface BrandMapper {
    List<Brand> filterItems(String key,Integer page, Integer rows,String sortBy, Boolean desc);

}
