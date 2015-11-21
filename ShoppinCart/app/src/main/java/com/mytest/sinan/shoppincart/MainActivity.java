package com.mytest.sinan.shoppincart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    final List<Product> products = ProductLoader.getProducts();
    ListView listView = (ListView)findViewById(R.id.products);
    Button checkoutButton = (Button)findViewById(R.id.check_out_button);
    ListAdapter adapter = new ListAdapter(this, R.layout.list_row, products);
    listView.setAdapter(adapter);
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        CartHandler.addProduct(products.get(position), MainActivity.this);
      }
    });
    checkoutButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if (!CartHandler.getProducts().isEmpty()) {
          startActivity(new Intent(MainActivity.this, CartScreen.class));
        } else {
          Toast.makeText(MainActivity.this, "No products added to the cart", Toast.LENGTH_SHORT).show();
        }
      }
    });
  }
}
