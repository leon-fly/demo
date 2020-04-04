package com.leon.demo.springboot.dao;

import com.leon.demo.springboot.model.po.ProductInfo;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2020/3/21
 */
public interface ProductInfoDao {
    ProductInfo findByCode(String code);

    ProductInfo update(ProductInfo productInfo);

    int delete(String code);
}
