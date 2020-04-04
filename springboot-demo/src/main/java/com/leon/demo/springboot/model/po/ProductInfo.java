package com.leon.demo.springboot.model.po;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2020/3/21
 */
@Builder
@Data
@ToString
public class ProductInfo implements Serializable {
    private Long id;
    private String name;
    private String code;
    private String description;
}
