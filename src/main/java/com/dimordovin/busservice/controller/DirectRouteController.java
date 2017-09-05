package com.dimordovin.busservice.controller;

import com.dimordovin.busservice.service.StationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class DirectRouteController {

    @Inject
    private StationService stationService;

    @GetMapping("/direct")
    public @ResponseBody DirectRouteAnswer direct(@RequestParam("dep_sid") int departureStationId,
                             @RequestParam("arr_sid") int arrivalStationId) {
        boolean haveDirectRoute = stationService.haveDirectRoute(departureStationId, arrivalStationId);

        return new DirectRouteAnswer(departureStationId, arrivalStationId, haveDirectRoute);
    }
}
