package com.example.admin.adminmarathistatus;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.adminmarathistatus.Adapter.CustomCategorySpinnerAdapter;
import com.example.admin.adminmarathistatus.Model.Categories;
import com.example.admin.adminmarathistatus.Model.CategoriesResponse;
import com.example.admin.adminmarathistatus.Model.MessageResponse;
import com.example.admin.adminmarathistatus.Retrofit.RestClient;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener {

    private EditText etTitle;
    private Button btnInsert,reset;
    private RelativeLayout mLayout;

    private Spinner catSpinner;
    private CustomCategorySpinnerAdapter mCatSpinnerAdapter;
    private ArrayList<Categories> mCatArrayList;
    private String selectedCatId;
    private TextView tvCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {

        etTitle = (EditText) findViewById(R.id.etTitle);


        tvCat = (TextView) findViewById(R.id.tvCat);
        catSpinner = (Spinner) findViewById(R.id.catSpinner);
        btnInsert = (Button) findViewById(R.id.btnInsert);

        reset = (Button) findViewById(R.id.reset);

        tvCat.setOnClickListener(this);
        btnInsert.setOnClickListener(this);
        reset.setOnClickListener(this);

        apiforcatgory();

    }

    private void apiforcatgory() {

        RestClient.getWebServices().getallcatgory(new Callback<String>() {
            @Override
            public void success(String s, Response response) {



                mCatArrayList = new ArrayList<>();
                CategoriesResponse mSelectCityResponse = new Gson().fromJson(s, CategoriesResponse.class);
                mCatArrayList = (ArrayList<Categories>) mSelectCityResponse.getCategories();
                mCatArrayList.add(0, new Categories("9999999", getResources().getString(R.string.select_category)));
                mCatSpinnerAdapter = new CustomCategorySpinnerAdapter(MainActivity.this, mCatArrayList);
                catSpinner.setAdapter(mCatSpinnerAdapter);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(MainActivity.this, "Wait Bhava Net Slow ahe ki", Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.reset:
                clear();
                break;

            case R.id.tvCat:
                catSpinner.performClick();
                break;

            case R.id.btnInsert:
                addmessage();
                break;
        }

    }

    private void addmessage() {

        HashMap<String, Object> map = new HashMap<>();

        map.put("title", etTitle.getText().toString().trim());

        map.put("category_id", selectedCatId);





        RestClient.getWebServices().MessageInsert(map, new Callback<String>() {
            @Override
            public void success(String serverResponse, Response response) {

                MessageResponse mmssageResponse = new Gson().fromJson(serverResponse, MessageResponse.class);
                Toast.makeText(MainActivity.this, "Message Inserted Successfully", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(MainActivity.this, "Wait Bhava Net Slow Ahe", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void clear() {
        etTitle.setText("");


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedCatId = mCatArrayList.get(position).getId();
        tvCat.setText(mCatArrayList.get(position).getTitle());

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
