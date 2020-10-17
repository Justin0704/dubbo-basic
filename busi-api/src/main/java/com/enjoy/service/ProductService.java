package com.enjoy.service;

import com.enjoy.entity.ProductEntity;

public interface ProductService {

    ProductEntity getDetail(String id);
    ProductEntity modify(ProductEntity product);
    boolean status(String id, boolean upDown);
}
