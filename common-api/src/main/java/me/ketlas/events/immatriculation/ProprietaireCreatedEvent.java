package me.ketlas.events.immatriculation;

import lombok.Getter;
import me.ketlas.events.BaseEvent;

import javax.xml.crypto.Data;

@Getter
public class ProprietaireCreatedEvent extends BaseEvent<String> {

    private String nom;
    private Data dateNaissance;
    private String email;


    public ProprietaireCreatedEvent(String id, String nom, Data dateNaissance, String email) {
        super(id);
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.email = email;
    }
}
