package com.example.hello;

import java.util.*;

public class DealerSelector {


    List<Dealer> allDealers = DealerReader.readDealersFromFile();

    // create a method to get dealers from the dealer list and randomize
    public static List<Dealer> getRandomDealers(List<Dealer> dealers, int count) {
        if (count >= dealers.size()) {
            return new ArrayList<>(dealers);
        }

        // randomize to the give count
        Set<Dealer> randomDealersSet = new HashSet<>();
        Random random = new Random();
        while (randomDealersSet.size() < count) {
            Dealer dealer = dealers.get(random.nextInt(dealers.size()));
            randomDealersSet.add(dealer);
        }

        // sorted them using their location in ascending order
        // create array list to hold random dealers
        List<Dealer> randomDealers = new ArrayList<>(randomDealersSet);

         for (int i = 0; i < randomDealers.size() - 1; i++) {
            for (int j = 0; j < randomDealers.size() - i - 1; j++) {
                if (randomDealers.get(j).getLocation().compareTo(randomDealers.get(j + 1).getLocation()) > 0) {
                    Dealer temp = randomDealers.get(j);
                    randomDealers.set(j, randomDealers.get(j + 1));
                    randomDealers.set(j + 1, temp);
                }
            }
        }

        System.out.println(randomDealers);
        return randomDealers;
    }
}


