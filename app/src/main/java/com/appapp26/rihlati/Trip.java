package com.appapp26.rihlati;


public class Trip {
    int id;
    int av_places;
    String destination;

String time;
int price;

    public Trip() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAv_places() {
        return av_places;
    }

    public void setAv_places(int av_places) {
        this.av_places = av_places;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    Trip(int id, int av_places, String destination, String time, int price){
    this.id=id;
    this.av_places=av_places;
    this.destination =destination;
    this.price=price;
    this.time=time;
}
    Trip( int av_places, String destination, String time, int price){

        this.av_places=av_places;
        this.destination =destination;
        this.price=price;
        this.time=time;
    }


}
