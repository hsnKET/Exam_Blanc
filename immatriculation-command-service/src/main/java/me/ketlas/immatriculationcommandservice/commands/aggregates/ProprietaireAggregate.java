package me.ketlas.immatriculationcommandservice.commands.aggregates;


import lombok.extern.slf4j.Slf4j;
import me.ketlas.commands.immatriculation.CreatePropritaireCommand;
import me.ketlas.commands.immatriculation.UpdatePropritaireCommand;
import me.ketlas.commands.radar.CreateRadarCommand;
import me.ketlas.commands.radar.DeleteRadarCommand;
import me.ketlas.commands.radar.UpdateRadarCommand;
import me.ketlas.events.immatriculation.ProprietaireCreatedEvent;
import me.ketlas.events.immatriculation.ProprietaireDeletedEvent;
import me.ketlas.events.immatriculation.ProprietaireUpdatedEvent;
import me.ketlas.events.radar.RadarCreatedEvent;
import me.ketlas.events.radar.RadarDeletedEvent;
import me.ketlas.events.radar.RadarUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import javax.xml.crypto.Data;

@Aggregate
@Slf4j
public class ProprietaireAggregate {

    @AggregateIdentifier
    private String id;
    private String nom;
    private Data dateNaissance;
    private String email;

    public ProprietaireAggregate(){
        //Required by AXON Framework
    }

    @CommandHandler
    public ProprietaireAggregate(CreatePropritaireCommand command){

        //emit the event
        AggregateLifecycle.apply(
                new ProprietaireCreatedEvent(
                        command.getId(),
                        command.getNom(),
                        command.getDateNaissance(),
                        command.getEmail()
                )
        );

    }

    @CommandHandler
    public void on(UpdatePropritaireCommand command){

        //emit the event
        AggregateLifecycle.apply(
                new ProprietaireUpdatedEvent(
                        command.getId(),
                        command.getNom(),
                        command.getDateNaissance(),
                        command.getEmail()
                )
        );

    }

    @CommandHandler
    public void on(DeleteRadarCommand command){

        //emit the event
        AggregateLifecycle.apply(
                new ProprietaireDeletedEvent(command.getId())
        );

    }



    @EventSourcingHandler
    public void on(ProprietaireCreatedEvent event){
        this.id = event.getId();
        this.nom = event.getEmail();
        this.dateNaissance = event.getDateNaissance();
        this.email = event.getEmail();
        log.info("---------ProprietaireCreatedEvent---------");
        //we can emit another event here like to activate the account..

    }

    @EventSourcingHandler
    public void on(ProprietaireUpdatedEvent event){
        this.id = event.getId();
        this.nom = event.getEmail();
        this.dateNaissance = event.getDateNaissance();
        this.email = event.getEmail();
        log.info("---------ProprietaireUpdatedEvent---------");
        //we can emit another event here like to activate the account..

    }

    @EventSourcingHandler
    public void on(ProprietaireDeletedEvent event){
        this.id = event.getId();
        log.info("---------ProprietaireDeletedEvent---------");
        //we can emit another event here like to activate the account..
    }




}
