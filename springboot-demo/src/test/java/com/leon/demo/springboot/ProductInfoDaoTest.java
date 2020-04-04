package com.leon.demo.springboot;

import com.leon.demo.springboot.dao.ProductInfoDao;
import com.leon.demo.springboot.model.po.ProductInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2020/3/21
 */
public class ProductInfoDaoTest extends BaseJunitTest {
    @Autowired
    ProductInfoDao productInfoDao;

    //插入缓存
    @Test
    public void testFind() {
        ProductInfo productInfo = productInfoDao.findByCode("456");
        System.out.println(productInfo);
    }

    //更新缓存
    @Test
    public void testUpdate() {
        productInfoDao.update(ProductInfo.builder()
                .code("123")
                .name("意外险")
                .description("平安1号升级版")
                .build());
    }

    @Test
    public void testDelete(){
        productInfoDao.delete("123");
    }

}
