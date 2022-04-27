package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.HashMap;

public class MenuActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner typeOfMenu;
    Spinner drinksSpinner;
    Spinner startersSpinner;
    Spinner mainDishSpinner;
    Spinner dessertsSpinner;

    HashMap<String,String> selectedOptions = new HashMap<String,String>();

    Button orderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        typeOfMenu = (Spinner) findViewById(R.id.typeOfMenu);
        drinksSpinner = (Spinner) findViewById(R.id.drinks_spinner);
        startersSpinner = (Spinner) findViewById(R.id.starters_spinner);
        mainDishSpinner = (Spinner) findViewById(R.id.maindish_spinner);
        dessertsSpinner = (Spinner) findViewById(R.id.desserts_spinner);

        makeSelectMenu(typeOfMenu,R.array.menu_types);
        makeSelectMenu(drinksSpinner,R.array.drinks);
        makeSelectMenu(startersSpinner,R.array.starters);
        makeSelectMenu(mainDishSpinner,R.array.main_dishes);
        makeSelectMenu(dessertsSpinner,R.array.desserts);

        orderBtn = (Button) findViewById(R.id.order_btn);
        orderBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, OrderActivity.class);
                intent.putExtra("selected_menu_type",selectedOptions.get("selected_menu_type"));
                intent.putExtra("selected_drink",selectedOptions.get("selected_drink"));
                intent.putExtra("selected_starter",selectedOptions.get("selected_starter"));
                intent.putExtra("selected_main_dish",selectedOptions.get("selected_main_dish"));
                intent.putExtra("selected_dessert",selectedOptions.get("selected_dessert"));
                startActivity(intent);
            }
        });
    }

    public void makeSelectMenu(Spinner spinner, int textArrayResId){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, textArrayResId, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String objectKey = "";
        switch (parent.getId()){
            case R.id.typeOfMenu: objectKey="selected_menu_type"; break;
            case R.id.drinks_spinner: objectKey="selected_drink"; break;
            case R.id.starters_spinner: objectKey="selected_starter"; break;
            case R.id.maindish_spinner: objectKey="selected_main_dish"; break;
            case R.id.desserts_spinner: objectKey="selected_dessert"; break;
        }
        selectedOptions.put(objectKey,parent.getItemAtPosition(position).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
