package com.example.mygithubprofis;

import android.widget.ImageView;

import java.io.Serializable;

public class User implements Serializable {
    private String avatar_url;
    private String login;
    private String url;

    public User(String avatarUrl, String login, String url) {
        this.avatar_url = avatarUrl;
        this.login = login;
        this.url = url;
    }

    public User(){}

    public String getAvatar_url() {
        return avatar_url;
    }

    public ImageView setAvatarUrl(String avatarUrl) {
        this.avatar_url = avatarUrl;
        return null;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
