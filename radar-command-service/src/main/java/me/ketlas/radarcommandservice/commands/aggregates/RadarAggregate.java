package me.ketlas.radarcommandservice.commands.aggregates;


import lombok.Getter;
import me.ketlas.commands.CreateRadarCommand;
import me.ketlas.events.RadarCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
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

    @EventSourcingHandler
    public void on(RadarCreatedEvent event){
        this.id = event.getId();
        this.maxVitesse  = event.getMaxVitesse();
        this.latitude = event.getLatitude();
        this.longitude = event.getLongitude();
        //we can emit another event here like to activate the account..

    }



}
