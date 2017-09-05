package com.dimordovin.busservice.service;

import com.dimordovin.busservice.util.StationMapReader;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.*;

@Service
public class StationService {
    // stationId -> routeIds map
    private Map<Integer, Set<Integer>> map = null;

    @Inject
    public StationService(StationMapReader stationMapReader) {
        this.map = stationMapReader.readMap();
    }

    public boolean haveDirectRoute(int stationFromId, int stationToId) {

        if (! map.containsKey(stationFromId) || ! map.containsKey(stationToId)) {
            return false;
        }

        if (stationFromId == stationToId) {
            return true;
        }

        Set<Integer> smallerSet = map.get(stationFromId);
        Set<Integer> largerSet = map.get(stationToId);

        // slight optimisation
        if (smallerSet.size() > largerSet.size()) {
            Set<Integer> temp = smallerSet;
            smallerSet = largerSet;
            largerSet = temp;
        }

        for (Integer routeId : smallerSet) {
            if (largerSet.contains(routeId)) {
                return true;
            }
        }

        return false;
    }
}
