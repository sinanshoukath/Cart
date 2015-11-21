package com.mytest.sinan.shoppincart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sinan on 21/11/15.
 */
public class ListAdapter extends ArrayAdapter<Product> {
  private Context context;
  private List<Product> products;

  public ListAdapter(Context context, int resource, List<Product> objects) {
    super(context, resource, objects);
    this.context = context;
    this.products = objects;
  }


  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View view = convertView;
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    if (view == null) {
      view = inflater.inflate(R.layout.list_row, null);
    }
    TextView productTextView = (TextView)view.findViewById(R.id.product_name);
    TextView priceTextView = (TextView)view.findViewById(R.id.price);
    productTextView.setText(products.get(position).getName());
    priceTextView.setText(String.valueOf(products.get(position).getPrice()));
    return view;
  }
}
