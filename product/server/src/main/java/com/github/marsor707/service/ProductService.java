package com.github.marsor707.service;

import com.github.marsor707.DecreaseStockInput;
import com.github.marsor707.ProductInfoOutput;
import com.github.marsor707.dataobject.ProductInfo;

import java.util.List;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */
public interface ProductService {

    List<ProductInfo> findUpAll();

    List<ProductInfoOutput> findList(List<String> productIdList);

    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
