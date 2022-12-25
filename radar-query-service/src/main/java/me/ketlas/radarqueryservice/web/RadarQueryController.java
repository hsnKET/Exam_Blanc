package me.ketlas.radarqueryservice.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import me.ketlas.query.radar.GetAllRadarsQuery;
import me.ketlas.query.radar.GetRadarByIdQuery;
import me.ketlas.radarqueryservice.entities.Radar;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/radars/query")
public class RadarQueryController {

    private QueryGateway queryGateway;

    @GetMapping("/all")
    public CompletableFuture<List<Radar>> radars(){
        return queryGateway.query(new GetAllRadarsQuery(),
                ResponseTypes.multipleInstancesOf(Radar.class));
    }

    @GetMapping("/byId/{id}")
    public CompletableFuture<Radar> RadarById(@PathVariable String id){
        return queryGateway.query(new GetRadarByIdQuery(id),
                ResponseTypes.instanceOf(Radar.class));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handler(Exception e){
        return new ResponseEntity<String>(
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}
