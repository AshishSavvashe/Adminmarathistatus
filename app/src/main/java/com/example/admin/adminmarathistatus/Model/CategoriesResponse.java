package com.example.admin.adminmarathistatus.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Admin on 06-11-2017.
 */

public class CategoriesResponse implements Serializable {
    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("count")
    @Expose
    private String count;

    @SerializedName("categories")
    @Expose
    private List<Categories> categories = null;

    public String getStatus() {
        return status;
    }

    public String getCount() {
        return count;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }
}