package me.ketlas.events.immatriculation;

import lombok.Getter;
import me.ketlas.events.BaseEvent;


@Getter
public class VehicleCreatedEvent extends BaseEvent<String> {

    private String marque;
    private String model;
    private int puissanceFiscale;
    private int numeroMatricule;
    private String idPropritaire;


    public VehicleCreatedEvent(String id, String marque, String model, int puissanceFiscale, int numeroMatricule, String idPropritaire) {
        super(id);
        this.marque = marque;
        this.model = model;
        this.puissanceFiscale = puissanceFiscale;
        this.numeroMatricule = numeroMatricule;
        this.idPropritaire = idPropritaire;
    }
}