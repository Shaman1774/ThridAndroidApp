package ru.bstu.vt41.bli.thridandroidapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity implements DetailFragment.OnFragmentPostListener {

    private Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        
        //Достаём из интента сериализованные данные по ключу/id "post"
        post = (Post) getIntent().getSerializableExtra("post");
    }
    
    //Реализация метода интерфейса OnFragmentPostListener
    @Override
    public Post onFragmentPost() {
        return post;
    }
}
