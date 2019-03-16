package com.leyou.item.model;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * describe:
 *
 * @author Feiyu
 * @date 2019/03/04
 */
@Table(name = "tb_specification")
public class Specification {

    @Id
    private Long categoryId;
    private String specifications;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }
}
