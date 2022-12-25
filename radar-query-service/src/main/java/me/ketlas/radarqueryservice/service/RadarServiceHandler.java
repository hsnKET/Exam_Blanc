package me.ketlas.radarqueryservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ketlas.events.radar.RadarCreatedEvent;
import me.ketlas.events.radar.RadarDeletedEvent;
import me.ketlas.events.radar.RadarUpdatedEvent;
import me.ketlas.radarqueryservice.entities.Radar;
import me.ketlas.radarqueryservice.repositories.RadarRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class RadarServiceHandler {

    private RadarRepository radarRepository;

    @EventHandler
    public void on(RadarCreatedEvent event){
        Radar radar = new Radar();
        radar.setId(event.getId());
        radar.setMaxVitesse(event.getMaxVitesse());
        radar.setLatitude(event.getLatitude());
        radar.setLongitude(event.getLongitude());
        radarRepository.save(radar);
        log.info("Radar Created");
    }

    @EventHandler
    public void on(RadarUpdatedEvent event){
        Radar radar = radarRepository.findById(event.getId())
                        .orElseThrow(()->new RuntimeException("Radar not found exception!"));
        radar.setId(event.getId());
        radar.setMaxVitesse(event.getMaxVitesse());
        radar.setLatitude(event.getLatitude());
        radar.setLongitude(event.getLongitude());
        radarRepository.save(radar);
        log.info("Radar Updated");
    }

    @EventHandler
    public void on(RadarDeletedEvent event){
        radarRepository.deleteById(event.getId());
        log.info("Radar Updated");
    }

}
