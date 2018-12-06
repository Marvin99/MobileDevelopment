package com.yablonskyi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.yablonskyi.adapter.PixabayAdapter;
import com.yablonskyi.interfaces.PixabayAPI;
import com.yablonskyi.model.Hit;
import com.yablonskyi.model.PhotoList;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.list_photos) RecyclerView recyclerView;
    @BindView(R.id.swipeContainer) SwipeRefreshLayout swipeContainer;
    @BindView(R.id.no_data) ImageView noData;
    private final static String BASE_URL = "https://pixabay.com/api/";
    PixabayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        callRetrofit();
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
        swipeContainer.setColorSchemeResources(R.color.colorPrimaryDark);

    }

    public void callRetrofit(){
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(1, TimeUnit.SECONDS)
                .readTimeout(1, TimeUnit.SECONDS)
                .writeTimeout(1, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PixabayAPI pixabayAPI = retrofit.create(PixabayAPI.class);
        Call<PhotoList> call = pixabayAPI.getData();
        call.enqueue(new Callback<PhotoList>() {
            @Override
            public void onResponse(@NonNull Call<PhotoList> call,
                                   @NonNull Response<PhotoList> response) {
                Log.d("tag", call.toString());
                Log.d("onResponse", "ServerResponse: " + response.toString());
                if (response.isSuccessful()){
                    noData.setVisibility(View.GONE);
                    PhotoList photoList = response.body();
                    ArrayList<Hit> hits = Objects.requireNonNull(photoList).getHits();
                    drawData(hits);
                } else {
                    Log.i("data", "no data");
                    noData.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(@NonNull Call<PhotoList> call, @NonNull Throwable t) {
                Log.e("onFailure", t.getMessage());
                noData.setVisibility(View.VISIBLE);
            }
        });
    }

    public void drawData(ArrayList<Hit> data){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PixabayAdapter(data);
        recyclerView.setAdapter(adapter);
    }

    public void refresh() {
        adapter.clear();
        callRetrofit();
        swipeContainer.setRefreshing(false);
    }
}
