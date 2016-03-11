package com.example.midas.domain;

/**
 * Created by Midas on 11/3/2559.
 */
public class User {
    private final int id;

    public User(int id) {
        this.id = id;
    }

    private String login;
    private String avatar_url;
    private String html_url;

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    @Override public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("***** User Details *****\n");
        stringBuilder.append("id=" + this.getId() + "\n");
        stringBuilder.append("login=" + this.getLogin() + "\n");
        stringBuilder.append("avatar_url=" + this.getAvatar_url() + "\n");
        stringBuilder.append("html_url=" + this.getHtml_url() + "\n");
        stringBuilder.append("*******************************");

        return stringBuilder.toString();
    }
}
