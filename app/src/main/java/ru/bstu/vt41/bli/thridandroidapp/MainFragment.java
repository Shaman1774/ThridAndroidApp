package ru.bstu.vt41.bli.thridandroidapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainFragment extends ListFragment {

    List<Post> posts = getPosts();
    private OnMainFragmentPostListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        //установка адаптера для списка
        this.setListAdapter(new AdapterListView(getActivity(), posts));

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMainFragmentPostListener) {
            mListener = (OnMainFragmentPostListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnMainFragmentPostListener");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Post post = posts.get(position);
        //Посылаем данные через интерфейс в MainActivity
        mListener.onFragmentPost(post);
    }

    // набор данных, которые свяжем со списком
    private List<Post> getPosts(){
        List<Post> posts = new ArrayList<>();

        posts.add(
                new Post(
                        "Дурак, он и есть дурак!",
                        "\"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                        R.drawable.mem1,
                        new Date(2018, 3, 16, 6, 6, 6)
                )
        );

        posts.add(
                new Post(
                        "Полёт",
                        "\"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                        R.drawable.mem2,
                        new Date(2018, 3, 16, 6, 6, 6)
                )
        );

        posts.add(
                new Post(
                        "Шампусик",
                        "\"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                        R.drawable.mem3,
                        new Date(2018, 3, 16, 6, 6, 6)
                )
        );

        posts.add(
                new Post(
                        "Мемчик",
                        "\"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                        R.drawable.mem4,
                        new Date(2018, 3, 16, 6, 6, 6)
                )
        );

        posts.add(
                new Post(
                        "Утя",
                        "\"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                        R.drawable.mem5,
                        new Date(2018, 3, 16, 6, 6, 6)
                )
        );

        posts.add(
                new Post(
                        "Тёлочка с базукой",
                        "\"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                        R.drawable.mem6,
                        new Date(2018, 3, 16, 6, 6, 6)
                )
        );

        posts.add(
                new Post(
                        "Гонка",
                        "\"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                        R.drawable.mem7,
                        new Date(2018, 3, 16, 6, 6, 6)
                )
        );

        posts.add(
                new Post(
                        "Защита",
                        "\"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                        R.drawable.mem8,
                        new Date(2018, 3, 16, 6, 6, 6)
                )
        );

        posts.add(
                new Post(
                        "Теребонька",
                        "\"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                        R.drawable.mem9,
                        new Date(2018, 3, 16, 6, 6, 6)
                )
        );

        posts.add(
                new Post(
                        "Слава Путину!",
                        "\"Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n" +
                                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                        R.drawable.mem10,
                        new Date(2018, 3, 16, 6, 6, 6)
                )
        );

        return posts;
    }

    public interface OnMainFragmentPostListener {

        void onFragmentPost(Post post);
    }
}
