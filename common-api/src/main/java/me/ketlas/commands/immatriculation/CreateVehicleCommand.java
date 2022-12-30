package me.ketlas.commands.immatriculation;

import lombok.Getter;
import me.ketlas.commands.BaseCommand;

@Getter
public class CreateVehicleCommand extends BaseCommand<String> {

    private String marque;
    private String model;
    private int puissanceFiscale;
    private int numeroMatricule;
    private String idPropritaire;

    public CreateVehicleCommand(String id, String marque, String model, int puissanceFiscale, int numeroMatricule, String idPropritaire) {
        super(id);
        this.marque = marque;
        this.model = model;
        this.puissanceFiscale = puissanceFiscale;
        this.numeroMatricule = numeroMatricule;
        this.idPropritaire = idPropritaire;
    }
}
