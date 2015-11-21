package com.mytest.sinan.shoppincart;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartScreen extends Activity {

  public interface UpdateListener {
    public void onUpdate();
  }

  private ListView cartList;
  private TextView totalPrice;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cart_screen);
    cartList = (ListView)findViewById(R.id.cart_list);
    totalPrice = (TextView)findViewById(R.id.total_price);
    updateList();
  }

  private void updateList() {
    Map<Product, Integer> productMap = new HashMap<>();
    List<Product> products = new ArrayList<>();
    for (Product product : CartHandler.getProducts()) {
      if (!productMap.containsKey(product))  {
        int productCount = getCount(product);
        if (productCount > 0) {
          products.add(product);
          productMap.put(product, productCount);
        }
      }

    }
    if (products.isEmpty()) {
      Toast.makeText(CartScreen.this, "Cart Empty!", Toast.LENGTH_SHORT).show();
      finish();
      return;
    }
    UpdateListener listener = new UpdateListener() {
      @Override public void onUpdate() {
        updateList();
      }
    };
    CartAdapter adapter = new CartAdapter(this, products, productMap, listener, R.layout.cart_list_row);
    cartList.setAdapter(adapter);
    totalPrice.setText("Total Price : " + String.valueOf(CartHandler.getTotalPrice()));
  }

  private int getCount(Product product) {
    int count = 0;
    for (Product pd : CartHandler.getProducts()) {
      if (pd.getName().equals(product.getName())) ++count;
    }
    return count;
  }
}
