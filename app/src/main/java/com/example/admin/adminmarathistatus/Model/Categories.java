package com.example.admin.adminmarathistatus.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 06-11-2017.
 */

public class Categories {
    @SerializedName("id")
    @Expose
    private String Categories_id;

    @SerializedName("title")
    @Expose
    private String Title;

    public Categories(String Categories_id, String Title) {
        this.Categories_id=Categories_id;
        this.Title=Title;


    }


    public String getId() {
        return Categories_id;
    }

    public String getTitle() {
        return Title;
    }

    public void setId(String id) {
        this.Categories_id = id;
    }

    public void setTitle(String title) {
        Title = title;
    }


}
