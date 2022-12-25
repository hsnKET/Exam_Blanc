package me.ketlas.events.radar;

import lombok.Getter;
import me.ketlas.events.BaseEvent;

public class RadarDeletedEvent extends BaseEvent<String> {

    public RadarDeletedEvent(String id) {
        super(id);
    }
}
