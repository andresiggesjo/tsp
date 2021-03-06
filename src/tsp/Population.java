/*
* Population.java
* Manages a population of candidate tours
*/

package tsp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Population {

    // Holds population of tours
    Tour[] tours;

    // Construct a population
    public Population(int populationSize, boolean initialise) {
        tours = new Tour[populationSize];
        // If we need to initialise a population of tours do so
        if (initialise) {
            // Loop and create individuals
            for (int i = 0; i < populationSize(); i++) {
                Tour newTour = new Tour();
                newTour.generateIndividual();
                saveTour(i, newTour);
            }
        }
    }

    // Saves a tour
    public void saveTour(int index, Tour tour) {
        tours[index] = tour;
    }
    
    // Gets a tour from population
    public Tour getTour(int index) {
        
        return tours[index];
    }
    public void removeTour(Tour i){
        List<Tour> list = new ArrayList<Tour>(Arrays.asList(tours));
        list.removeAll(Arrays.asList(i));
        tours = list.toArray(tours);
        System.out.println(tours.length);
    }

    // Gets the best tour in the population
    public Tour getFittest() {
        Tour fittest = tours[0];
        // Loop through individuals to find fittest
        for (int i = 1; i < populationSize(); i++) {
            if (fittest.getFitness() <= getTour(i).getFitness()) {
                fittest = getTour(i);
            }
        }
        return fittest;
    }

    // Gets population size
    public int populationSize() {
        return tours.length;
    }

    public void updateTour(Tour updateTour, int index) {
        tours[index] = updateTour;
    }

}