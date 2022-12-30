package me.ketlas.immatriculationcommandservice.commands.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ketlas.commands.immatriculation.CreateVehicleCommand;
import me.ketlas.dtos.immatriculation.CreateVehiculeRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@Slf4j
@RequestMapping("/vehicules/commands")
@AllArgsConstructor
public class VehiculeCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;


    @PostMapping("/create")
    public CompletableFuture<String> addNewVehicleCommand(@RequestBody CreateVehiculeRequestDTO request){
        return this.commandGateway.send(new CreateVehicleCommand(
                UUID.randomUUID().toString(),
                request.getMarque(),
                request.getModel(),
                request.getPuissanceFiscale(),
                request.getNumeroMatricule(),
                request.getIdPropritaire()
        ));
    }

}
