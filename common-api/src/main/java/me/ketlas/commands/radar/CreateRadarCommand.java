package me.ketlas.commands.radar;

import lombok.Getter;
import me.ketlas.commands.BaseCommand;

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
