package me.ketlas.dtos.immatriculation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateVehiculeRequestDTO {

    private String id;
    private String marque;
    private String model;
    private int puissanceFiscale;
    private int numeroMatricule;
    private String idPropritaire;
}
