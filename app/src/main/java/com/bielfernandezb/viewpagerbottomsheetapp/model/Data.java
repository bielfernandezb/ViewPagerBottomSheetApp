package com.bielfernandezb.viewpagerbottomsheetapp.model;

public class Data {

    private String Title;
    private String Description;

    public Data(String title, String description) {
        Title = title;
        Description = description;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
