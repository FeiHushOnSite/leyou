package com.leyou.item.service;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * describe:
 *
 * @author Feiyu
 * @date 2019/06/16
 */
@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;

    public PageResult<Brand> queryBrandByPageAndSort(
            Integer page, Integer rows, String sortBy, Boolean desc, String key) {
        PageResult<Brand> pageInfo = new PageResult<>();
        Long count = 0L;
        List<Brand> brands = brandMapper.filterItems(key,page,rows,sortBy,desc);
        for (Brand brand : brands) {
            count++;
        }

        pageInfo.setItems(brands);
        pageInfo.setTotal(count);
        pageInfo.setTotalPage(count / 5);
//        // 开始分页
//        PageHelper.startPage(page, rows);
//        // 过滤
//        Example example = new Example(Brand.class);
//        if (StringUtils.isNotBlank(key)) {
//            example.createCriteria().andLike("name", "%" + key + "%")
//                    .orEqualTo("letter", key.toUpperCase());
//        }
//        if (StringUtils.isNotBlank(sortBy)) {
//            // 排序
//            String orderByClause = sortBy + (desc ? " DESC" : " ASC");
//            example.setOrderByClause(orderByClause);
//        }
//        // 查询
//        Page<Brand> pageInfo = (Page<Brand>) brandMapper.selectByExample(example);
//        // 返回结果
        return pageInfo;
    }
}
