package com.mytest.sinan.shoppincart;

import java.util.List;

/**
 * Created by sinan on 21/11/15.
 */
public class Cart {
  private List<Product> products;

  public Cart(List<Product> products) {
    this.products = products;
  }

  public List<Product> getProducts() {
    return products;
  }

  public double getTotalPrice() {
    double totalPrice = 0;
    for (Product product : products) {
      totalPrice += product.getPrice();
    }
    return totalPrice;
  }
}
