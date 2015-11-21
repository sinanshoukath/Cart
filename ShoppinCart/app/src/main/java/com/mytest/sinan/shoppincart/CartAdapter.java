package com.mytest.sinan.shoppincart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sinan on 21/11/15.
 */
public class CartAdapter extends ArrayAdapter<Product> {
  private Context context;
  private final List<Product> products;
  private final Map<Product, Integer> productMap;
  private final CartScreen.UpdateListener listener;

  public CartAdapter(Context context, List<Product> products, Map<Product, Integer> productMap, CartScreen.UpdateListener listener, int resource) {
    super(context, resource, products);
    this.context = context;
    this.products = products;
    this.productMap = productMap;
    this.listener = listener;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View view = convertView;
    if (view == null) {
      LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      view = inflater.inflate(R.layout.cart_list_row, null);
    }
    final Product product = products.get(position);
    TextView productName = (TextView)view.findViewById(R.id.product_name);
    TextView price = (TextView)view.findViewById(R.id.price);
    TextView count = (TextView)view.findViewById(R.id.product_count);
    Button add = (Button)view.findViewById(R.id.add);
    add.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        CartHandler.addProduct(product, context);
        listener.onUpdate();
      }
    });
    Button remove = (Button)view.findViewById(R.id.remove_button);
    remove.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        CartHandler.removeProduct(product);
        listener.onUpdate();
      }
    });
    productName.setText(product.getName());
    count.setText("x" + String.valueOf(productMap.get(product)));
    price.setText(String.valueOf(product.getPrice() * productMap.get(product)));
    return view;
  }


}
