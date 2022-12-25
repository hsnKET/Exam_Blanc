package me.ketlas.radarcommandservice.commands.controllers;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ketlas.commands.CreateRadarCommand;
import me.ketlas.dtos.CreateRadarRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/radars/commands")
public class RadarCommandController {

    private CommandGateway commandGateway;

    @PostMapping("/create")
    public void createRadar(@RequestBody  CreateRadarRequestDTO request){

        commandGateway.send(
                new CreateRadarCommand(
                        UUID.randomUUID().toString(),
                        request.getMaxVitesse(),
                        request.getLongitude(),
                        request.getLatitude()
                )
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
