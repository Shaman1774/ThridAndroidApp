package ru.bstu.vt41.bli.thridandroidapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        Post post = (Post) getActivity().getIntent().getSerializableExtra("post");

        ImageView image = (ImageView) view.findViewById(R.id.imageView);
        image.setImageResource(post.getImageID());

        TextView title = (TextView) view.findViewById(R.id.tv_title);
        title.setText(post.getTitle());

        TextView text = (TextView) view.findViewById(R.id.tv_text);
        text.setText(post.getText());

        TextView date = (TextView) view.findViewById(R.id.tv_time);
        date.setText(post.getTime().toString());

        return view;
    }
}
