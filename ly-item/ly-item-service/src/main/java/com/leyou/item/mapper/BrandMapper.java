package com.leyou.item.mapper;

import com.leyou.item.pojo.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * describe:
 *
 * @author xxx
 * @date 2019/03/04
 */
@Mapper
public interface BrandMapper {

    List<Brand> selectByExample(Integer page,
                                Integer rows,
                                String sortBy,
                                String order,
                                String key);

    void insertSelective(Brand brand);

    void insertCategoryBrand(Long cid, Long id);
}
