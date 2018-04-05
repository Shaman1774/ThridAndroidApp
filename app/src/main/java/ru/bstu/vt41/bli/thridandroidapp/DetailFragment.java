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
        try {
            mListener = (OnFragmentPostListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentPostListener");
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Post post = mListener.onFragmentPost();
        setViewData(post);
    }

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
