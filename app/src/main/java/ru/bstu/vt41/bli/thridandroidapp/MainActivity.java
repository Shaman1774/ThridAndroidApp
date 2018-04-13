package ru.bstu.vt41.bli.thridandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements MainFragment.OnMainFragmentPostListener {

    private Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onFragmentPost(Post post) {
        //Принимаем пост от фрагмента
        this.post = post;
        Intent intent = new Intent(this, DetailActivity.class);
        //Передаём пост по ключу через интент в DetailActivity
        intent.putExtra("post", post);
        //Стартуем DetailActivity
        startActivity(intent);
    }
}
