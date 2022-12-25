package me.ketlas.radarqueryservice.repositories;

import me.ketlas.radarqueryservice.entities.Radar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RadarRepository extends JpaRepository<Radar,String> {
}
