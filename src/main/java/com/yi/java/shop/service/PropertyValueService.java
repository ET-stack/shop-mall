
package com.yi.java.shop.service;

import com.yi.java.shop.pojo.Product;
import com.yi.java.shop.pojo.PropertyValue;

import java.util.List;

public interface PropertyValueService {
    void init(Product p);
    void update(PropertyValue pv);

    PropertyValue get(int ptid, int pid);
    List<PropertyValue> list(int pid);
}

