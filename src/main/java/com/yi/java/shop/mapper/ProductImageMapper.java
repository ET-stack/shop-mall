/**
* 模仿天猫整站ssm 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	

package com.yi.java.shop.mapper;

import com.yi.java.shop.pojo.ProductImage;
import com.yi.java.shop.pojo.ProductImageExample;
import java.util.List;

public interface ProductImageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductImage record);

    int insertSelective(ProductImage record);

    List<ProductImage> selectByExample(ProductImageExample example);

    ProductImage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductImage record);

    int updateByPrimaryKey(ProductImage record);
}
