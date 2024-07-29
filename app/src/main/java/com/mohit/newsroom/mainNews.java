package com.mohit.newsroom;

import java.util.ArrayList;

public class mainNews {

    private String status;
    private String totalResults;
    // below is teh array list is intialzied cause the entire data of news
    // of different categories is inside arraylist names articles
    private ArrayList<ModelClass> articles;

    public mainNews(String status, String totalResults, ArrayList<ModelClass> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<ModelClass> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<ModelClass> articles) {
        this.articles = articles;
    }
}
