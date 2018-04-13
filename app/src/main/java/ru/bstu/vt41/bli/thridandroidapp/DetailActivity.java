package ru.bstu.vt41.bli.thridandroidapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity implements DetailFragment.OnDetailFragmentPostListener {

    private Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        post = (Post) getIntent().getSerializableExtra("post");
    }

    @Override
    public Post onFragmentPost() {
        return post;
    }
}
