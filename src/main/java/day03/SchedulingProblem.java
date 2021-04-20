package day03;

import day01.QuickSort;
import tools.AlgorithmTools.Pair;

public class SchedulingProblem {
    public static Integer[] solve(Integer[] times){
         Job[] jobs = new Job[times.length];
        for (int i = 0; i < times.length; i++) {
            jobs[i] = new Job(i, times[i]);
        }
        QuickSort.quickSort(jobs, true);
        Integer[] result = new Integer[times.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = jobs[i].i;
        }
        return result;
    }

    private static class Job extends Pair<Integer, Integer>
                                    implements Comparable{

        public Job(Integer i, Integer j){
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Object o) {
            Job job = (Job)o;
            return this.j - job.j;
        }
    }
}
