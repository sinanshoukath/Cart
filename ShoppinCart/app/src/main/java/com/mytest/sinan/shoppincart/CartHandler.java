package com.mytest.sinan.shoppincart;


import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CartHandler {
  private static Cart cart = new Cart(new ArrayList<Product>());

  public static void addProduct(Product product, Context context) {
    cart.getProducts().add(product);
    Toast.makeText(context, "Added " + product.getName() + " to cart", Toast.LENGTH_SHORT).show();
  }

  public static  void removeProduct(Product product) {
    for (Product product1 : cart.getProducts()) {
      if (product1.getName().equals(product.getName())) {
        cart.getProducts().remove(product);
        return;
      }
    }
  }

  public static List<Product> getProducts() {
    return cart.getProducts();
  }

  public static double getTotalPrice() {
    return cart.getTotalPrice();
  }
}
