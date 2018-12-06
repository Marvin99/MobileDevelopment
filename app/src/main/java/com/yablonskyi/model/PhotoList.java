package com.yablonskyi.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PhotoList {

    @SerializedName("totalHits")
    private String totalHits;

    @SerializedName("total")
    private String total;

    @SerializedName("hits")
    private ArrayList<Hit> hits;

    public String getTotalHits() {
        return totalHits;
    }

    public String getTotal() {
        return total;
    }

    public ArrayList<Hit> getHits() {
        return hits;
    }

    @Override
    public String toString() {
        return "totalHits: " + totalHits +
                "\ntotal: " + total +
                "\nhits: " + hits;
    }
}