package com.example.ev.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ev.model.Station;
import com.example.ev.service.EVBatteryStationService;

@RestController
public class EVBatteryStationController {

    @Autowired
    EVBatteryStationService evBatteryStationService;
    
    @GetMapping("/")
    public ResponseEntity<List<Station>> getAllChargingStations(){
    	
         List<Station> stations = evBatteryStationService.getAllChargingStations();
         if(stations.size()==0) {
        	 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
         return ResponseEntity.of(Optional.of(stations));
    }
    
    @GetMapping("/number/")
    public ResponseEntity<List<Station>> getNChargingStations(@RequestParam("limit") Integer limit){
    	
         List<Station> stations = evBatteryStationService.getNChargingStations(limit);
         if(stations.size()==0) {
        	 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
         return ResponseEntity.of(Optional.of(stations));
    }
    @GetMapping("/sort/")
    public ResponseEntity<List<Station>> getSortedStations(@RequestParam("sort") String sort,@RequestParam("param") String param){
    	
         List<Station> stations = evBatteryStationService.getSortedStations(sort,param);
         if(stations.size()==0) {
        	 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
         return ResponseEntity.of(Optional.of(stations));
    }
    
    @GetMapping("/show/{id}")
    public ResponseEntity<Station> getChargingStation(@PathVariable("id") Integer id){
             Station station = evBatteryStationService.getChargingStation(id);
             if(station==null) {
            	 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
             }
             return ResponseEntity.of(Optional.of(station));
    }

    @PostMapping("/")
    public ResponseEntity<Void> addStation(@RequestBody Station station){
    	try {
    		evBatteryStationService.addStation(station);
    		return ResponseEntity.status(HttpStatus.CREATED).build();
    		
    	}catch(Exception e){
    		e.printStackTrace();
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    	}
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<String> saveChangedStationDetail(@PathVariable("id") int id,
                                        @RequestBody Station station){
        try {
        	 String changedStation = evBatteryStationService.saveChangedStationDetail(id,station);
        	 return ResponseEntity.ok().body(changedStation);
        }catch(Exception e) {
        	e.printStackTrace();
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> removeChargingStation(@PathVariable("id") int id){
         try {
        	        evBatteryStationService.removeChargingStation(id);
        	 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
         }catch(Exception e) {
        	 e.printStackTrace();
        	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
         }
    }
}
