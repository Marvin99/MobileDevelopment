package com.yablonskyi.model;

import com.google.gson.annotations.SerializedName;

public class Hit {

    @SerializedName("largeImageURL")
    private String largeImageURL;

    @SerializedName("webformatHeight")
    private int webformatHeight;

    @SerializedName("webformatWidth")
    private int webformatWidth;

    @SerializedName("likes")
    private int likes;

    @SerializedName("imageWidth")
    private int imageWidth;

    @SerializedName("id")
    private int id;

    @SerializedName("user_id")
    private int user_id;

    @SerializedName("views")
    private int views;

    @SerializedName("comments")
    private int comments;

    @SerializedName("pageURL")
    private String pageURL;

    @SerializedName("imageHeight")
    private int imageHeight;

    @SerializedName("webformatURL")
    private String webformatURL;

    @SerializedName("type")
    private String type;

    @SerializedName("previewHeight")
    private int previewHeight;

    @SerializedName("tags")
    private String tags;

    @SerializedName("downloads")
    private int downloads;

    @SerializedName("user")
    private String user;

    @SerializedName("favorites")
    private int favorites;

    @SerializedName("imageSize")
    private int imageSize;

    @SerializedName("previewWidth")
    private int previewWidth;

    @SerializedName("userImageURL")
    private String userImageURL;

    @SerializedName("previewURL")
    private String previewURL;

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public int getWebformatHeight() {
        return webformatHeight;
    }

    public int getWebformatWidth() {
        return webformatWidth;
    }

    public int getLikes() {
        return likes;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getViews() {
        return views;
    }

    public int getComments() {
        return comments;
    }

    public String getPageURL() {
        return pageURL;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public String getWebformatURL() {
        return webformatURL;
    }

    public String getType() {
        return type;
    }

    public int getPreviewHeight() {
        return previewHeight;
    }

    public String getTags() {
        return tags;
    }

    public int getDownloads() {
        return downloads;
    }

    public String getUser() {
        return user;
    }

    public int getFavorites() {
        return favorites;
    }

    public int getImageSize() {
        return imageSize;
    }

    public int getPreviewWidth() {
        return previewWidth;
    }

    public String getUserImageURL() {
        return userImageURL;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    @Override
    public String toString() {
        return "\nlargeImageURL: " + largeImageURL +
                "\nwebformatHeight: " + webformatHeight +
                "\nwebformatWidth: " + webformatWidth +
                "\nlikes: " + likes +
                "\nimageWidth: " + imageWidth +
                "\nid: " + id +
                "\nuser_id: " + user_id +
                "\nviews: " + views +
                "\ncomments: " + comments +
                "\npageURL: " + pageURL +
                "\nimageHeight: " + imageHeight +
                "\nwebformatURL: " + webformatURL +
                "\ntype: " + type +
                "\npreviewHeight: " + previewHeight +
                "\ntags: " + tags +
                "\ndownloads: " + downloads +
                "\nuser: " + user +
                "\nfavorites: " + favorites +
                "\nimageSize: " + imageSize +
                "\npreviewWidth: " + previewWidth +
                "\nuserImageURL: " + userImageURL +
                "\npreviewURL: " + previewURL;
    }
}
