package me.ketlas.radarcommandservice.commands.aggregates;


import lombok.extern.slf4j.Slf4j;
import me.ketlas.commands.radar.CreateRadarCommand;
import me.ketlas.commands.radar.DeleteRadarCommand;
import me.ketlas.commands.radar.UpdateRadarCommand;
import me.ketlas.events.radar.RadarCreatedEvent;
import me.ketlas.events.radar.RadarDeletedEvent;
import me.ketlas.events.radar.RadarUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.hibernate.sql.Delete;

@Aggregate
@Slf4j
public class RadarAggregate {

    @AggregateIdentifier
    private String id;
    private double maxVitesse;
    private double longitude;
    private double latitude;

    public RadarAggregate(){
        //Required by AXON Framework
    }

    @CommandHandler
    public RadarAggregate(CreateRadarCommand command){

        //emit the event
        AggregateLifecycle.apply(
                new RadarCreatedEvent(
                        command.getId(),
                        command.getMaxVitesse(),
                        command.getLongitude(),
                        command.getLatitude()
                )
        );

    }

    @CommandHandler
    public void on(UpdateRadarCommand command){

        //emit the event
        AggregateLifecycle.apply(
                new RadarUpdatedEvent(
                        command.getId(),
                        command.getMaxVitesse(),
                        command.getLongitude(),
                        command.getLatitude()
                )
        );

    }

    @CommandHandler
    public void on(DeleteRadarCommand command){

        //emit the event
        AggregateLifecycle.apply(
                new RadarDeletedEvent(command.getId())
        );

    }



    @EventSourcingHandler
    public void on(RadarCreatedEvent event){
        this.id = event.getId();
        this.maxVitesse  = event.getMaxVitesse();
        this.latitude = event.getLatitude();
        this.longitude = event.getLongitude();
        log.info("---------RadarCreatedEvent---------");
        //we can emit another event here like to activate the account..

    }

    @EventSourcingHandler
    public void on(RadarUpdatedEvent event){
        this.id = event.getId();
        this.maxVitesse  = event.getMaxVitesse();
        this.latitude = event.getLatitude();
        this.longitude = event.getLongitude();
        log.info("---------RadarUpdatedEvent---------");
        //we can emit another event here like to activate the account..

    }

    @EventSourcingHandler
    public void on(RadarDeletedEvent event){
        this.id = event.getId();
        log.info("---------RadarDeletedEvent---------");
        //we can emit another event here like to activate the account..
    }




}
