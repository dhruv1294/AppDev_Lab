package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;

public class OrderActivity extends AppCompatActivity {

    HashMap<String,String> selectedOptions = new HashMap<String,String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        TextView selected_menu_type = (TextView)findViewById(R.id.selected_menu_type);
        TextView selected_drink = (TextView)findViewById(R.id.selected_drink);
        TextView selected_starter = (TextView) findViewById(R.id.selected_starter);
        TextView selected_main_dish = (TextView) findViewById(R.id.selected_main_dish);
        TextView selected_dessert = (TextView) findViewById(R.id.selected_dessert);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
             selected_menu_type.setText(extras.getString("selected_menu_type"));
             selected_drink.setText(extras.getString("selected_drink"));
             selected_starter.setText(extras.getString("selected_starter"));
             selected_main_dish.setText(extras.getString("selected_main_dish"));
             selected_dessert.setText(extras.getString("selected_dessert"));
        }

    }
}
