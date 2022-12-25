package me.ketlas.commands;

import lombok.Getter;

public class CreateRadarCommand extends BaseCommand<String> {
    @Getter private double maxVitesse;
    @Getter private double longitude;
    @Getter private double latitude;


    public CreateRadarCommand(String id,double maxVitesse, double longitude, double latitude) {
        super(id);
        this.maxVitesse = maxVitesse;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
