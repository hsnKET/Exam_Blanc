package me.ketlas.radarqueryservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ketlas.events.radar.RadarCreatedEvent;
import me.ketlas.events.radar.RadarDeletedEvent;
import me.ketlas.events.radar.RadarUpdatedEvent;
import me.ketlas.query.radar.GetAllRadarsQuery;
import me.ketlas.query.radar.GetRadarByIdQuery;
import me.ketlas.radarqueryservice.entities.Radar;
import me.ketlas.radarqueryservice.repositories.RadarRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class RadarQueryHandler {

    private RadarRepository radarRepository;

    @QueryHandler
    public List<Radar> handle(GetAllRadarsQuery query){
        return this.radarRepository.findAll();
    }

    @QueryHandler
    public Radar handle(GetRadarByIdQuery query){
        return this.radarRepository.findById(query.getId()).orElseThrow(() ->
                new RuntimeException("Radar not found!"));
    }

}
