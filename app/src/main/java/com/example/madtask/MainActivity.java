package com.example.madtask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText enterCity;
    private Button searchCity;
    private TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Double[] lat = new Double[1];
        final Double[] lon = new Double[1];
        List<RestaurantDetails> myList=new ArrayList<>();
        enterCity=(EditText)findViewById(R.id.enter_city);
        searchCity=(Button)findViewById(R.id.search);
        results=(TextView)findViewById(R.id.results);
        final GetDataService getDataService=RetrofitInstance.getRetrofitInstance().create(GetDataService.class);
        searchCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                            public void onResponse(Call<RestaurantResponse> call, Response<RestaurantResponse> response) {
                                Log.d("location",response.body().getRestaurants().get(0).getRestaurant().getLocation().getAddress());
                                Log.d("city",response.body().getRestaurants().get(0).getRestaurant().getLocation().getCity());
                            }

                            @Override
                            public void onFailure(Call<RestaurantResponse> call, Throwable t) {

                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<CityDetails> call, Throwable t) {

                    }
                });
                Log.d("check1",String.valueOf(lat[0]));
                Log.d("check2",String.valueOf(lon[0]));
            }
        });
    }
}