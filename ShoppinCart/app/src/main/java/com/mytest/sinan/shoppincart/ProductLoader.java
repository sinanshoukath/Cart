package com.mytest.sinan.shoppincart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sinan on 21/11/15.
 */
public class ProductLoader {

  public static List<Product> getProducts() {
    ArrayList<Product> products = new ArrayList<>();
    Product product1 = new Product("Iphone6s", 500);
    products.add(product1);
    Product product2 = new Product("Nexus", 450);
    products.add(product2);
    Product product3 = new Product("Reebok shoe", 100);
    products.add(product3);
    Product product4 = new Product("Tag heuer", 150);
    products.add(product4);
    return products;
  }
}
