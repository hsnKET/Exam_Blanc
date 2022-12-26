package me.ketlas.immatriculationcommandservice.commands.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ketlas.commands.immatriculation.CreatePropritaireCommand;
import me.ketlas.commands.immatriculation.DeleteProprietaireCommand;
import me.ketlas.commands.immatriculation.UpdatePropritaireCommand;
import me.ketlas.commands.radar.UpdateRadarCommand;
import me.ketlas.dtos.immatriculation.CreateProprietaireRequestDTO;
import me.ketlas.dtos.immatriculation.UpdateProprietaireRequestDTO;
import me.ketlas.dtos.radar.UpdateRadarRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/proprietaires/commands")
public class ProprietaireCommandController {

    private CommandGateway commandGateway;

    @PostMapping("/create")
    public CompletableFuture<String> createProprietaire(@RequestBody CreateProprietaireRequestDTO request){

        return commandGateway.send(
                new CreatePropritaireCommand(
                        UUID.randomUUID().toString(),
                        request.getNom(),
                        request.getDateNaissance(),
                        request.getEmail()
                )
        );
    }

    @PutMapping("/update/{id}")
    public  CompletableFuture<String> updateProprietaire(@PathVariable String id,@RequestBody UpdateProprietaireRequestDTO request){

        return commandGateway.send(
                new UpdatePropritaireCommand(
                        id,
                        request.getNom(),
                        request.getDateNaissance(),
                        request.getEmail()
                )
        );
    }

    @DeleteMapping("/delete/{id}")
    public  CompletableFuture<String> deleteProprietaire(@PathVariable String id){

        return commandGateway.send(
                new DeleteProprietaireCommand(id)
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handler(Exception e){
        return new ResponseEntity<String>(
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}
