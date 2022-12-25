package me.ketlas.events.radar;

import lombok.Getter;
import me.ketlas.events.BaseEvent;

public class RadarUpdatedEvent extends BaseEvent<String> {

    @Getter private double maxVitesse;
    @Getter private double longitude;
    @Getter private double latitude;


    public RadarUpdatedEvent(String id, double maxVitesse, double longitude, double latitude) {
        super(id);
        this.maxVitesse = maxVitesse;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
