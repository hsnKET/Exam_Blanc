package me.ketlas.commands.immatriculation;

import lombok.Getter;
import me.ketlas.commands.BaseCommand;

import javax.xml.crypto.Data;

public class UpdatePropritaireCommand extends BaseCommand<String> {
    @Getter private String nom;
    @Getter private Data dateNaissance;
    @Getter private String email;

    public UpdatePropritaireCommand(String id, String nom, Data dateNaissance, String email) {
        super(id);
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.email = email;
    }
}
