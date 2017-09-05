package com.dimordovin.busservice.service;

import com.dimordovin.busservice.util.StationMapReader;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;


public class StationServiceTest {

    private StationService stationService = new StationService(() -> {
        // stationId -> routeIds
        Map<Integer, Set<Integer>> m = new HashMap<>();

        Set<Integer> s1 =  new HashSet<>();
        s1.add(1);
        s1.add(5);
        s1.add(9);
        s1.add(17);
        m.put(1, s1);

        Set<Integer> s2 =  new HashSet<>();
        s2.add(100);
        s2.add(5);
        s2.add(10);
        m.put(2, s2);

        Set<Integer> s3 =  new HashSet<>();
        s3.add(7);
        s3.add(1);
        s3.add(9);
        m.put(3, s3);

        return m;
    });

    @Test
    public void testDirectRoute() {
        assertTrue(stationService.haveDirectRoute(1, 2));
        assertTrue(stationService.haveDirectRoute(2, 1));
        assertTrue(stationService.haveDirectRoute(1, 3));
        assertTrue(stationService.haveDirectRoute(3, 1));
    }

    @Test
    public void testEqualExistingIds() {
        assertTrue(stationService.haveDirectRoute(1, 1));
        assertTrue(stationService.haveDirectRoute(2, 2));
        assertTrue(stationService.haveDirectRoute(3, 3));
    }

    @Test
    public void testNotExistingIds() {
        assertFalse(stationService.haveDirectRoute(1, 5));
        assertFalse(stationService.haveDirectRoute(5, 3));
        assertFalse(stationService.haveDirectRoute(5, 5));
    }

    @Test
    public void testNoDirectRoute() {
        assertFalse(stationService.haveDirectRoute(2, 3));
        assertFalse(stationService.haveDirectRoute(3, 2));
    }
}
