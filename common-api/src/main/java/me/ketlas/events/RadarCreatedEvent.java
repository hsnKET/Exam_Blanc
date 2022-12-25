package me.ketlas.events;

import lombok.Getter;

public class RadarCreatedEvent extends BaseEvent<String> {

    @Getter private double maxVitesse;
    @Getter private double longitude;
    @Getter private double latitude;


    public RadarCreatedEvent(String id,double maxVitesse, double longitude, double latitude) {
        super(id);
        this.maxVitesse = maxVitesse;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
