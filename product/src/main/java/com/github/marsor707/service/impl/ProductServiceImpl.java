package com.github.marsor707.service.impl;

import com.github.marsor707.dataobject.ProductInfo;
import com.github.marsor707.enums.ProductStatusEnum;
import com.github.marsor707.repository.ProductInfoRepository;
import com.github.marsor707.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
