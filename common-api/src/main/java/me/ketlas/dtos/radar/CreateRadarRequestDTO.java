package me.ketlas.dtos.radar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRadarRequestDTO {
    private double maxVitesse;
    private double longitude;
    private double latitude;
}
