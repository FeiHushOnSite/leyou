package com.leyou.item.service;


import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Brand;
import com.leyou.item.pojo.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {


    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    BrandMapper brandMapper;

    private Long pid = 132L;
    @Test
    public void queryListByParent() {
        Category category = new Category();
        category.setId(pid);
        List<Category> select = categoryMapper.select(category);
        System.out.println(select);
    }

    @Test
    public void selectByExample(){
        Integer page = 0;
        Integer rows = 5;
        String sortBy = "A";
       // Boolean desc = false;
        String order = "asc";
        String key = "D";
        List<Brand> brands = brandMapper.selectByExample(page, rows, sortBy, order, key);
        System.out.println(brands);
    }

    @Test
    public void insertSelective(){
        Brand brand = new Brand();
        brand.setId(1L);
        brand.setName("飞宇的测试");
        brand.setCategories(null);
        brand.setLetter(any());
        brand.setImage(anyString());
        this.brandMapper.insertSelective(brand);
    }
}
