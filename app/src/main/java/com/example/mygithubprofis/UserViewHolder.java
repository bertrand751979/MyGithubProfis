package com.example.mygithubprofis;

import android.view.View;
import android.webkit.WebSettings;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;

public class UserViewHolder extends RecyclerView.ViewHolder {
    private  ImageView vhAvatarUrl;
    private TextView vhlogin;
    private TextView vhUrl;

    public UserViewHolder(@NonNull View view) {
        super(view);
       vhAvatarUrl=view.findViewById(R.id.raw_avatarUrl);
       vhlogin=view.findViewById(R.id.raw_login);
       vhUrl=view.findViewById(R.id.raw_url);
    }

    public ImageView getVhAvatarUrl() {
        return vhAvatarUrl;
    }

    public void setVhAvatarUrl(ImageView vhAvatarUrl) {
        this.vhAvatarUrl = vhAvatarUrl;
    }

    public TextView getVhlogin() {
        return vhlogin;
    }

    public void setVhlogin(TextView vhlogin) {
        this.vhlogin = vhlogin;
    }

    public TextView getVhUrl() {
        return vhUrl;
    }

    public void setVhUrl(TextView vhUrl) {
        this.vhUrl = vhUrl;
    }

    public void bind(User user){
        vhlogin.setText(user.getLogin());
        vhUrl.setText(user.getUrl());

        Glide.with(vhAvatarUrl.getContext())
                .load(user.getAvatar_url())
                .into(vhAvatarUrl);



    }




}
