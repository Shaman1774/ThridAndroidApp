package ru.bstu.vt41.bli.thridandroidapp;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailFragment extends Fragment {

    private OnFragmentPostListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //Проверка реализует ли контекст(активити, в котором находится фрагмент) интерфейс OnFragmentPostListener
        try {
            //Приводим к типу интерфейса OnFragmentPostListener наш контекст
            mListener = (OnFragmentPostListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentPostListener");
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Вызываем метод получения поста
        Post post = mListener.onFragmentPost();
        setViewData(post);
    }
    
    //Интерфейс для получения данных из активити
    public interface OnFragmentPostListener {

        Post onFragmentPost();
    }

    public void setViewData(Post post){
        ImageView image = (ImageView) getView().findViewById(R.id.imageView);
        image.setImageResource(post.getImageID());

        TextView title = (TextView) getView().findViewById(R.id.tv_title);
        title.setText(post.getTitle());

        TextView text = (TextView) getView().findViewById(R.id.tv_text);
        text.setText(post.getText());

        TextView date = (TextView) getView().findViewById(R.id.tv_time);
        date.setText(post.getTime().toString());
    }
}
