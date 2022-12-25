package me.ketlas.radarqueryservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Radar {
    @Id
    private String id;
    private double maxVitesse;
    private double longitude;
    private double latitude;
}
