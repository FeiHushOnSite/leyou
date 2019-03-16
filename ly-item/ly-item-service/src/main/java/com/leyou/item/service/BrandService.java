package com.leyou.item.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.leyou.common.pojo.PageResult;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * describe:
 *
 * @author Feiyu
 * @date 2019/03/04
 */
@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;

//    public PageResult<Brand> queryBrandByPageAndSort(
//            Integer page, Integer rows, String sortBy, Boolean desc, String key) {
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
//        return new PageResult<>(pageInfo.getTotal(), pageInfo);
//    }

    public List<Brand> queryBrandByPageAndSort(Integer page,
                                               Integer rows,
                                               String sortBy,
                                               Boolean desc,
                                               String key) {
        List<Brand> list;
        String order;
        if (desc = true) {
            order = "desc";
            list = brandMapper.selectByExample(page, rows, sortBy, order, key);
        } else {
            order = "asc";
            list = brandMapper.selectByExample(page, rows, sortBy, order, key);
        }
        return list;
    }

    @Transactional
    public void saveBrand(Brand brand, List<Long> cids) {
        this.brandMapper.insertSelective(brand);

        for (Long cid : cids) {
            this.brandMapper.insertCategoryBrand(cid,brand.getId());
        }
    }
}
