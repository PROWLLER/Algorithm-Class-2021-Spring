package day01;

import tools.AlgorithmTools;

import java.util.ArrayList;
import java.util.Collection;

/**
 * PriorityQueue creates a PriorityQueue powered by big top heap.
 *
 *
 *
 * @author PROWLLER
 * @version 1.0
 * */
public class PriorityQueue <T extends Comparable>{

    private ArrayList<T> arr = new ArrayList<T>();// big top heap

    public PriorityQueue(){

    }

    public PriorityQueue(Iterable<T> iterable){
        for(T t : iterable){
            arr.add(t);
        }
        sortAll();
    }

    /**
     * The function make the part of a unsorted heap to be partly sorted.
     * It make the index to be sorted.
     * For example:
     *          5
     *         / \
     *        4   3
     *       / \   \
     *      2   0   6(unsorted, run{@code swim(5)})
     *
     *      ------->
     *
     *          6
     *         / \
     *        4   5
     *       / \   \
     *      2   0   3
     * @param k input the index of the array to be resorted to be sorted.
     *
     *
     *
     * */
    private void swim(int k) {
        while(k > 0 && AlgorithmTools.less(arr.get(k/2), arr.get(k))){
            AlgorithmTools.exchange(arr, k/2, k);
            k = k / 2;
        }
    }
    /**
     *
     *The function make the part of a unsorted heap to be partly sorted.
     * It make the index to be sorted.
     * For example:
     *           5(unsorted, run{@code sink(0)})
     *          / \
     *         4   3
     *        / \   \
     *       2   0   6
     *
     *       ------->
     *
     *           6
     *          / \
     *         4   5
     *        / \   \
     *       2   0   3
     * @param k input the index of the array to be resorted to be sorted.
     *
     *
     *
     * */
    private void sink(int k){
        int size = arr.size();

        while(2 * k < size){
            int j = 2 * k;
            if(j < size - 1 && AlgorithmTools.less(arr.get(j), arr.get(j+1))) j++;
            if(!AlgorithmTools.less(arr.get(k), arr.get(j))) break;
            AlgorithmTools.exchange(arr, k, j);
            k = j;
        }
    }

    private void sortAll(){
        for(int i=0;i<arr.size();i++){
            swim(i);
        }
    }
    /**
     * push a element into the heap
     *
     *
     * */
    public void push(T element){
        arr.add(element);
        swim(arr.size() - 1);
    }

    public void push(Iterable<T> iterable){
        for(T element : iterable){
            this.push(element);
        }
    }

    public T pop(){
        if(arr.size() == 0)return null;

        T result = arr.get(0);
        AlgorithmTools.exchange(arr, 0, arr.size() - 1);
        arr.remove(arr.size() - 1);
        sink(0);

        return result;
    }

    public T top(){
        if(arr.size() == 0)return null;

        return arr.get(0);
    }






}
