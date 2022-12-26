package me.ketlas.events.immatriculation;

import lombok.Getter;
import me.ketlas.events.BaseEvent;

import javax.xml.crypto.Data;

@Getter
public class ProprietaireDeletedEvent extends BaseEvent<String> {

    public ProprietaireDeletedEvent(String id) {
        super(id);
    }
}
