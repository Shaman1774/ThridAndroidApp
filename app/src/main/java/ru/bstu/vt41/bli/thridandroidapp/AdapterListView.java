package ru.bstu.vt41.bli.thridandroidapp;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class AdapterListView extends BaseAdapter {
    LayoutInflater lInflater;
    List<Post> posts;

    public AdapterListView(Context context, List<Post> posts) {
        lInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.posts = posts;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Post getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView==null){
            convertView = lInflater.inflate(R.layout.fragment_detail, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Post post = posts.get(position);

        viewHolder.imageView.setImageResource(post.getImageID());
        viewHolder.textView.setText(post.getText());
        //Выводить только 3 строчки
        viewHolder.textView.setMaxLines(3);
        viewHolder.textView.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.titleView.setText(post.getTitle());
        viewHolder.timeView.setText(post.getTime().toString());

        return convertView;
    }

    private class ViewHolder {
        final ImageView imageView;
        final TextView textView, titleView;
        final TextView timeView;

        ViewHolder(View view){
            imageView = (ImageView)view.findViewById(R.id.imageView);
            textView = (TextView) view.findViewById(R.id.tv_text);
            titleView = (TextView) view.findViewById(R.id.tv_title);
            timeView = (TextView) view.findViewById(R.id.tv_time);
        }
    }
}
