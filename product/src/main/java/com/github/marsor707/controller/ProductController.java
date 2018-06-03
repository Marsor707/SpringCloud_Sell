package com.github.marsor707.controller;

import com.github.marsor707.VO.ProductInfoVO;
import com.github.marsor707.VO.ProductVO;
import com.github.marsor707.VO.ResultVO;
import com.github.marsor707.dataobject.ProductCategory;
import com.github.marsor707.dataobject.ProductInfo;
import com.github.marsor707.service.CategoryService;
import com.github.marsor707.service.ProductService;
import com.github.marsor707.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("list")
    public ResultVO<ProductVO> list() {
        //查询所有在售商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //根据在售商品查询类目id
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
        //根据类目id查询类目信息
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //数据拼接
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
