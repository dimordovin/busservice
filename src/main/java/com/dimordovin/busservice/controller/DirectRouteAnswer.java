package com.dimordovin.busservice.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DirectRouteAnswer {

    private Integer departureStationId;

    private Integer arrivalStationId;

    private Boolean haveDirectRoute;

    public DirectRouteAnswer(Integer departureStationId, Integer arrivalStationId, Boolean haveDirectRoute) {
        this.departureStationId = departureStationId;
        this.arrivalStationId = arrivalStationId;
        this.haveDirectRoute = haveDirectRoute;
    }

    public DirectRouteAnswer() {

    }

    @JsonProperty("dep_sid")
    public Integer getDepartureStationId() {
        return departureStationId;
    }

    public void setDepartureStationId(Integer departureStationId) {
        this.departureStationId = departureStationId;
    }

    @JsonProperty("arr_sid")
    public Integer getArrivalStationId() {
        return arrivalStationId;
    }

    public void setArrivalStationId(Integer arrivalStationId) {
        this.arrivalStationId = arrivalStationId;
    }

    @JsonProperty("direct_bus_route")
    public Boolean getHaveDirectRoute() {
        return haveDirectRoute;
    }

    public void setHaveDirectRoute(Boolean haveDirectRoute) {
        this.haveDirectRoute = haveDirectRoute;
    }
}