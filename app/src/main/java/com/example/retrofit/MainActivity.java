package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

import java.util.HashMap;

import model.Articles;
import model.News;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final static String APIKEY = "139fb67ee7224ceb970891258553bbf7";
    private RecyclerView dRcNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onGetEveryNews();
    }

    public void onGetEveryNews(){

        HashMap<String,Object> queries = new HashMap<>();
        queries.put("apiKey", APIKEY);
        queries.put("sources", "google-news");

        dRcNews = findViewById(R.id.rc_news_list);
        dRcNews.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false));

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<String> callNews = apiInterface.getEveryNews(queries);

        callNews.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Response", "Success");
                Log.i("Response", response.body());
                try {
                    JSONObject responseObject = new JSONObject(response.body());
                    News currentNews = News.parseNewsResponse(responseObject);
                    NewsAdapter adapter = new NewsAdapter(MainActivity.this, currentNews.articles);
                    dRcNews.setAdapter(adapter);
//                    Toast.makeText(MainActivity.this, currentNews.articles.size() + "", Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("Response", "Failure");
                Log.i("Failure", t.getMessage());
            }
        });
    }
}