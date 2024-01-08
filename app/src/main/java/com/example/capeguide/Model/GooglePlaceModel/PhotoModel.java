//Deep Programming (2021) Near Me | Firebase, Google Map, Place & Direction API's | Intro & Setup Project Android Java source code (Version 1.0) [Source code]. https://www.youtube.com/watch?v=dfTzz5AhBNQ&list=PLpQFhyCcxiCqDFYQabluYIYsNSsCFMNFk&index=1
package com.example.capeguide.Model.GooglePlaceModel;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhotoModel {

    @SerializedName("height")
    @Expose
    private Integer height;

    @SerializedName("html_attributions")
    @Expose
    private List<String> htmlAttributions = null;

    @SerializedName("photo_reference")
    @Expose
    private String photoReference;

    @SerializedName("width")
    @Expose
    private Integer width;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public List<String> getHtmlAttributions() {
        return htmlAttributions;
    }

    public void setHtmlAttributions(List<String> htmlAttributions) {
        this.htmlAttributions = htmlAttributions;
    }

    public String getPhotoReference() {
        return photoReference;
    }

    public void setPhotoReference(String photoReference) {
        this.photoReference = photoReference;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @BindingAdapter("loadImage")
    public static void loadImage(ImageView view, String image) {
        Glide.with(view.getContext()).load(image).into(view);
    }
}
