package com._1easy.hashtables;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1436
 * You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.
 * <p>
 * It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.
 * <p>
 * Example 1:
 * <p>
 * Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
 * Output: "Sao Paulo"
 * Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
 */
public class DestinationCity {

    public static void main(String[] args) {
        System.out.println(destCityFaster(List.of(
                List.of("London", "New York"),
                List.of("New York", "Lima"),
                List.of("Lima", "Sao Paulo")
        )));

        System.out.println(destCityFaster(List.of(
                List.of("pYyNGfBYbm", "wxAscRuzOl"), // wxAscRuzOl
                List.of("kzwEQHfwce", "pYyNGfBYbm"))
        ));  // should be wxAscRuzOl
    }


    // 2ms, Runtime beats 100%, Memory beats 15%
    // (can be probably optimized by using
    public static String destCityFaster(List<List<String>> paths) {

        Set<String> outCities = new HashSet<>();

        // collect all out cities (by definition NOT correct output)
        for (List<String> cityPairs : paths) {
            outCities.add(cityPairs.getFirst());
        }

        // loop over pairs again, and...
        for (List<String> cityPairs : paths) {
            String inCity = cityPairs.get(1);
            // as soon as we find a city that is NOT among out cities
            // then that MUST be the one we want
            if (!outCities.contains(inCity)) {
                return inCity;
            }
        }
        return null;
    }

    // 5ms, Runtime beats 7.2%, Memory beats 5.20%
    public static String destCity(List<List<String>> paths) {

        Set<String> inCities = new HashSet<>();
        Set<String> outCities = new HashSet<>();

        for (List<String> cityPairs : paths) {
            String outCity = cityPairs.getFirst();
            String inCity = cityPairs.get(1);

            outCities.add(outCity);
            inCities.add(inCity);
            inCities.remove(outCity);
        }
        inCities.removeAll(outCities);
        return inCities.stream().toList().getFirst();
    }
}
