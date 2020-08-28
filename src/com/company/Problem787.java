package com.company;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem787 {

    private static class Flight {

        public Flight(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
            this.times = 0;
        }

        int start;
        int end;
        int cost;
        int times;
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        if (src>=n || dst >=n) {
            return -1 ;
        }

        boolean findStart = false, findEnd  = false;

        Map<Integer, List<Flight>> map = new HashMap<>();
        for (int i = 0; i < flights.length; i++) {
            if (n > flights[i][0] && n > flights[i][1]) {
                if (!map.containsKey(flights[i][0])) {
                    map.put(flights[i][0], new ArrayList<>());
                }

                if (!findStart && flights[i][0] == src) {
                    findStart = true;
                }

                if (!findEnd && flights[i][1] == dst) {
                    findEnd = true;
                }

                map.get(flights[i][0]).add(new Flight(flights[i][0], flights[i][1], flights[i][2]));
            }
        }

        if (!findEnd || !findStart) {
            return -1;
        }

        int total = K;

        while (--K >= 0) {

            List<Flight> newFlights = new ArrayList<>();

            for (Integer key : map.keySet()) {
                for (Flight f : map.get(key)) {
                    List<Flight> endF = map.get(f.end);
                    if (endF != null) {
                        for (Flight e : endF) {
                            if (f.times + e.times + 1 <= total) {
                                for (Flight exist : this.getFlight(map, f.start, e.end)) {
                                    if (exist != null) {
                                        if (exist.cost > f.cost + e.cost) {
                                            if (f.times + e.times + 1 <= exist.times) {
                                                exist.cost = f.cost + e.cost;
                                                exist.times = f.times + e.times + 1;
                                            } else {
                                                Flight newFlight = new Flight(f.start, e.end, f.cost + e.cost);
                                                newFlight.times = f.times + e.times + 1;
                                                newFlights.add(newFlight);
                                            }
                                        }
                                    } else {
                                        Flight newFlight = new Flight(f.start, e.end, f.cost + e.cost);
                                        newFlight.times = f.times + e.times + 1;
                                        newFlights.add(newFlight);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            for(Flight f : newFlights) {
                map.get(f.start).add(f);
            }
        }

        return getResult(getFlight(map, src, dst));
    }

    private int getResult(List<Flight> flights) {

        if (flights.size() == 0) {
            return -1;
        }

        int v = Integer.MAX_VALUE;
        for (Flight f:flights) {
            v= Math.min(v, f.cost);
        }

        return v;
    }

    private List<Flight> getFlight(Map<Integer, List<Flight>> map, int start, int end) {

        List<Flight> list = new ArrayList<>();

        if (map.containsKey(start)) {
            for (Flight f : map.get(start)) {
                if (f.end == end) {
                    list.add(f);
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Problem787 p = new Problem787();
        long start = System.currentTimeMillis();
        System.out.println(p.findCheapestPrice(3,
                new int[][]{{0,1,100},{1,2,100},{0,2,500}},
                0, 2, 1));

        System.out.println("total cost: " + (System.currentTimeMillis() - start));
    }
}