package me.ketlas.radarcommandservice.commands.controllers;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ketlas.commands.radar.CreateRadarCommand;
import me.ketlas.commands.radar.DeleteRadarCommand;
import me.ketlas.commands.radar.UpdateRadarCommand;
import me.ketlas.dtos.radar.CreateRadarRequestDTO;
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
@RequestMapping("/radars/commands")
public class RadarCommandController {

    private CommandGateway commandGateway;

    @PostMapping("/create")
    public  CompletableFuture<String> createRadar(@RequestBody  CreateRadarRequestDTO request){

        return commandGateway.send(
                new CreateRadarCommand(
                        UUID.randomUUID().toString(),
                        request.getMaxVitesse(),
                        request.getLongitude(),
                        request.getLatitude()
                )
        );
    }

    @PutMapping("/update/{id}")
    public  CompletableFuture<String> updateRadar(@PathVariable String id,@RequestBody UpdateRadarRequestDTO request){

        return commandGateway.send(
                new UpdateRadarCommand(
                        id,
                        request.getMaxVitesse(),
                        request.getLongitude(),
                        request.getLatitude()
                )
        );
    }

    @DeleteMapping("/delete/{id}")
    public  CompletableFuture<String> deleteRadar(@PathVariable String id){

        return commandGateway.send(
                new DeleteRadarCommand(id)
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
