package me.ketlas.dtos.immatriculation;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.crypto.Data;

@AllArgsConstructor
@NoArgsConstructor
@lombok.Data
public class CreateProprietaireRequestDTO {
    private String nom;
    private Data dateNaissance;
    private String email;
}
