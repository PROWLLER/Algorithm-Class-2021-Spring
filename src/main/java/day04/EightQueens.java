package day04;

import tools.AlgorithmTools.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

public class EightQueens {

    public static Set<Set<Pair<Integer, Integer>>> solve(Integer dimension, Integer Queens){
        Set<Pair<Integer, Integer>> available = new HashSet<>();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                available.add(new Pair<>(i, j));
            }
        }

        Set<Set<Pair<Integer, Integer>>> solved = new HashSet<>();
        backpack(available, new HashSet<>(), Queens, solved);
        return solved;
        HashMap
    }

    private static void backpack(Set<Pair<Integer, Integer>> available,
                                 Set<Pair<Integer, Integer>> installed,
                                 Integer Queens,
                                 Set<Set<Pair<Integer, Integer>>> solved){
        if(installed.size() == Queens){
            solved.add(installed);
        }

        for(Pair<Integer, Integer> index : available){
            Set<Pair<Integer, Integer>> newInstalled = new HashSet<>();
            Set<Pair<Integer, Integer>> newAvailable = new HashSet<>();

            newInstalled.addAll(installed);
            newInstalled.add(index);

            newAvailable.addAll(available);
            newAvailable.removeIf(new Predicate<Pair<Integer, Integer>>() {
                @Override
                public boolean test(Pair<Integer, Integer> pair) {

                    return pair.i == index.i ||
                            pair.j == index.j ||
                            (pair.i - index.i) == (pair.j - index.j) ||
                            (pair.i - index.i) == (index.j - pair.j);
                }
            });

            backpack(newAvailable, newInstalled, Queens, solved);
        }


    }

    private static class ComparablePair extends Pair<Integer, Integer>
                                        implements Comparable<ComparablePair>{
        @Override
        public int compareTo(ComparablePair o) {
            if(this.i != o.i)return this.i - o.i;
            else return this.j - o.j;
        }


    }
}
