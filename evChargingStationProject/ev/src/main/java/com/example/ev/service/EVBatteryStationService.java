package com.example.ev.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.ev.model.Station;
import com.example.ev.repository.StationRepository;

@Service
public class EVBatteryStationService {

    @Autowired
    StationRepository stationRepository;
    
    public List<Station> getAllChargingStations(){
        List<Station> stations = new ArrayList<>();
        stationRepository.findAll().forEach(station -> stations.add(station));
        return stations;
    }
    
    public List<Station> getNChargingStations(Integer number){
        List<Station> stations = new ArrayList<>();
        Pageable limit = PageRequest.of(0, number);
        stationRepository.findAll(limit).forEach(station -> stations.add(station));
        return stations;
    }
    public List<Station> getSortedStations(String sort,String param){
        List<Station> stations = new ArrayList<>();
        if(sort.equals("Asc")) {
         stationRepository.findAll(Sort.by(Sort.Direction.ASC,param)).forEach(station -> stations.add(station));
        }else {
        	stationRepository.findAll(Sort.by(Sort.Direction.DESC,param)).forEach(station -> stations.add(station));
        }
        return stations;
    }
    
    public Station getChargingStation(Integer id){
        return stationRepository.findById(id).get();
    }
   
    public void addStation(Station station){
        stationRepository.save(station);
    }

    public String saveChangedStationDetail(int id,Station station){
        stationRepository.save(station);
        return "Successfully updated";
    }
    public void removeChargingStation(int id){
        stationRepository.deleteById(id);
    }

}
