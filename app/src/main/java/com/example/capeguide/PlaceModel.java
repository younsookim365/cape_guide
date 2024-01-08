//Deep Programming (2021) Near Me | Firebase, Google Map, Place & Direction API's | Intro & Setup Project Android Java source code (Version 1.0) [Source code]. https://www.youtube.com/watch?v=dfTzz5AhBNQ&list=PLpQFhyCcxiCqDFYQabluYIYsNSsCFMNFk&index=1
package com.example.capeguide;

public class PlaceModel {

    int id, drawableId;
    String name;
    String placeType;

    public PlaceModel() {
    }

    public PlaceModel(int id, int drawableId, String name, String placeType) {
        this.id = id;
        this.drawableId = drawableId;
        this.name = name;
        this.placeType = placeType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }
}