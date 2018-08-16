package com.myactivityone.activity;


import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;


import com.myactivityone.R;
import com.myactivityone.adpter.GridAdpter;
import com.myactivityone.api.Api;
import com.myactivityone.api.ApiClient;
import com.myactivityone.model.GridItem;
import com.myactivityone.model.GiphyResponceImages;
import com.myactivityone.model.GiphyResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends Activity {

    private GridView gridview;
    private EditText edt_search;
    private ImageButton imgbtn_search;
    private RelativeLayout rltv_search;
    private final static String API_KEY = "zzKguLmHDW31fqVjaybjoFWwEbae3lsd";

    ArrayList<GridItem> arrayList_gridItem = new ArrayList<GridItem>();;
    GridItem gridItem;
    GridAdpter customGrid;
    String search_keyword = "funny+cat";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridview = (GridView) findViewById(R.id.gridview);
        edt_search =(EditText) findViewById(R.id.edt_search);
        imgbtn_search=(ImageButton) findViewById(R.id.imgbtn_search);
        rltv_search=(RelativeLayout) findViewById(R.id.rltv_search);

        callApi(search_keyword);

        imgbtn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rltv_search.setVisibility(View.GONE);
                edt_search.setVisibility(View.VISIBLE);

            }
        });

        edt_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                arrayList_gridItem.clear();
                search_keyword = String.valueOf(s);
                callApi(search_keyword);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    public void callApi(String search_keyword){

        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY first from themoviedb.org", Toast.LENGTH_LONG).show();
            return;
        }

        Api apiService = ApiClient.getClient().create(Api.class);
        Call<GiphyResponse> call = apiService.getTopRatedMovies(search_keyword, API_KEY);

        call.enqueue(new Callback<GiphyResponse>() {
            @Override
            public void onResponse(Call<GiphyResponse> call, Response<GiphyResponse> response) {

                List<GiphyResponceImages> movies = response.body().getData();


                for (int i=0;i<movies.size();i++){

                    gridItem = new GridItem();
                    gridItem.setVideo_tital(movies.get(i).getTitle());
                    gridItem.setVideo_image(movies.get(i).getImages().getImagepath().getUrl());
                    gridItem.setVideo_url(movies.get(i).getImages().getVideopath().getVideoUrl());
                    gridItem.setCount(0);
                    arrayList_gridItem.add(gridItem);
                }


                customGrid = new GridAdpter(MainActivity.this, arrayList_gridItem);
                gridview.setAdapter(customGrid);

            }

            @Override
            public void onFailure(Call<GiphyResponse> call, Throwable t) {

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        rltv_search.setVisibility(View.VISIBLE);
        edt_search.setVisibility(View.GONE);
    }
}
