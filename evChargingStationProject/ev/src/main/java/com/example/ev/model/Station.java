package com.example.ev.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table
public class Station {
    @Id
    @JsonProperty
    @Column(name = "station_id")
    private int stationId;
    
    @JsonProperty
    @Column(name = "station_name")
    private String stationName;
    
    @JsonProperty
    @Column(name = "station_image")
    private String stationImage;
    
    @JsonProperty
    @Column(name = "station_pricing")
    private float stationPricing;
    
    @JsonProperty
    @Column(name = "station_address")
    private String stationAddress;
}
