package com.example.foodrecommendation;

public class foodconst {
    private String desc;
    private String title;
    private String image;
    private String fruits;
    private String fat;



    public foodconst() {
    }


    public foodconst(String desc, String title, String image, String fruits, String fat1) {
        this.desc = desc;
        this.title = title;
        this.image=image;
        this.fruits = fruits;
        this.fat = fat1;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }

    public String getFruits() {
        return fruits;
    }

    public void setFruits(String fruits) {
        this.fruits = fruits;
    }

    public String getFat1() {
        return fat;
    }

    public void setFat1(String fat) {
        this.fat = fat;
    }


}
