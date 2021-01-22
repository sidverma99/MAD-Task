package com.example.madtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText enterCity;
    private Button searchCity;
    private RecyclerView mRecyclerView;
    private DataAdapter mDataAdapter;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Double[] lat = new Double[1];
        final Double[] lon = new Double[1];
        final List<RestaurantDetails>[] myList = new List[]{new ArrayList<>()};
        enterCity=(EditText)findViewById(R.id.enter_city);
        mProgressBar=(ProgressBar)findViewById(R.id.progressBar);
        searchCity=(Button)findViewById(R.id.search);
        mRecyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        final GetDataService getDataService=RetrofitInstance.getRetrofitInstance().create(GetDataService.class);
        searchCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputMethodManager=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(mRecyclerView.getWindowToken(),0);
                mProgressBar.setVisibility(View.VISIBLE);
                mRecyclerView.setVisibility(View.GONE);
                Call<CityDetails> call=getDataService.getLocation(enterCity.getText().toString(),null,null,null);
                call.enqueue(new Callback<CityDetails>() {
                    @Override
                    public void onResponse(Call<CityDetails> call, Response<CityDetails> response) {
                        lat[0] =response.body().getSuggestionList().get(0).getLatitude();
                        lon[0] =response.body().getSuggestionList().get(0).getLongitude();
                        Log.d("longitude",String.valueOf(lon[0]));
                        Log.d("latitude",String.valueOf(lat[0]));
                        Log.d("type", lat[0].getClass().getName());
                        Call<RestaurantResponse> call1=getDataService.getRestaurant(null,null,null,null,null, lat[0], lon[0],null,null,null,null,null,null,null);
                        call1.enqueue(new Callback<RestaurantResponse>() {
                            @Override
                            public void onResponse(Call<RestaurantResponse> call, Response<RestaurantResponse> response1) {
                                Log.d("location",response1.body().getRestaurants().get(0).getRestaurant().getLocation().getAddress());
                                Log.d("city",response1.body().getRestaurants().get(0).getRestaurant().getLocation().getCity());
                                mProgressBar.setVisibility(View.GONE);
                                mRecyclerView.setVisibility(View.VISIBLE);
                                myList[0] =response1.body().getRestaurants();
                                mDataAdapter=new DataAdapter(getApplicationContext(),myList);
                                RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
                                mRecyclerView.setLayoutManager(layoutManager);
                                mRecyclerView.setAdapter(mDataAdapter);
                            }

                            @Override
                            public void onFailure(Call<RestaurantResponse> call, Throwable t) {
                                Toast.makeText(getApplicationContext(),"Error 1",Toast.LENGTH_LONG).show();
                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<CityDetails> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Error 2",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}