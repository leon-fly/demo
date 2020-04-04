package com.leon.demo.springboot.dao.impl;

import com.leon.demo.springboot.dao.ProductInfoDao;
import com.leon.demo.springboot.model.po.ProductInfo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * @Author : leonwang
 * @Descpriction mock数据库增删改
 * @Date:created 2020/3/21
 */
@Repository
public class ProductInfoDaoImpl implements ProductInfoDao {
    @Cacheable(value = "ProductInfo", key = "#code"/*, condition = ""*/)
    @Override
    public ProductInfo findByCode(String code) {
        System.out.println("======");
        return ProductInfo.builder()
                .id(1l)
                .code(code)
                .name("意外险")
                .description("平安1号")
                .build();
    }

    @Override
    @CachePut(value = "ProductInfo", key = "#productInfo.code")
    public ProductInfo update(ProductInfo productInfo) {
        System.out.println(productInfo);
        return productInfo;
    }

    @Override
    @CacheEvict(value = "ProductInfo", key = "#code")
    public int delete(String code) {
        return 1;
    }
}
