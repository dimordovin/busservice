package com.dimordovin.busservice.util;

import java.util.Map;
import java.util.Set;

public interface StationMapReader {
    Map<Integer, Set<Integer>> readMap();
}
