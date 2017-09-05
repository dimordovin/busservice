package com.dimordovin.busservice.util;

import com.dimordovin.busservice.service.StationMapReaderException;

import java.io.File;
import java.util.*;

public class FileStationMapReader implements StationMapReader {

    private String filename;

    public FileStationMapReader(String filename) {

        this.filename = filename;
    }

    public Map<Integer, Set<Integer>> readMap() {
        try {

            Scanner sc = new Scanner(new File(filename));

            Map<Integer, Set<Integer>> map = new HashMap<>();

            int n = Integer.parseInt(sc.nextLine().trim());

            while (n > 0 && sc.hasNextLine()) {
                n--;

                String[] tokens = sc.nextLine().trim().split(" ");

                int routeId = Integer.parseInt(tokens[0]);

                for (int i = 1; i < tokens.length; ++i) {
                    int stationId = Integer.parseInt(tokens[i]);
                    map.computeIfAbsent(stationId, k -> new HashSet<>()).add(routeId);
                }
            }
            sc.close();

            return map;
        } catch (Exception e) {
            throw new StationMapReaderException(e);
        }
    }
}
