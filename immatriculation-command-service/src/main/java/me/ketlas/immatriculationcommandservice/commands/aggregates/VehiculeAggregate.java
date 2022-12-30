package me.ketlas.immatriculationcommandservice.commands.aggregates;

import lombok.extern.slf4j.Slf4j;
import me.ketlas.commands.immatriculation.CreateVehicleCommand;
import me.ketlas.events.immatriculation.VehicleCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class VehiculeAggregate {
    @AggregateIdentifier
    private String id;
    private String marque;
    private String model;
    private int puissanceFiscale;
    private int numeroMatricule;
    private String idPropritaire;

    public VehiculeAggregate() {
    }

    @CommandHandler
    public VehiculeAggregate(CreateVehicleCommand command) {

        AggregateLifecycle.apply(new VehicleCreatedEvent(
                command.getId(),
                command.getMarque(),
                command.getModel(),
                command.getPuissanceFiscale(),
                command.getNumeroMatricule(),
                command.getIdPropritaire()
                ));
    }


    @EventSourcingHandler
    public void on(CreateVehicleCommand event) {
        this.id = event.getId();
        this.marque = event.getMarque();
        this.model = event.getModel();
        this.puissanceFiscale = event.getPuissanceFiscale();
        this.numeroMatricule = event.getNumeroMatricule();
        this.idPropritaire = event.getIdPropritaire();
    }
}
