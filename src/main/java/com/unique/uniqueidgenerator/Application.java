package com.unique.uniqueidgenerator;

public class Application {

    public static void majority(int[] numbs) {
        int candidate = 0;
        int count = 0;
        for(int in : numbs) {
            if(count == 0) {
                candidate = in;
                count = 1;
            }
           else if(candidate == in) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for(int in : numbs) {
            if(in == candidate)
                count++;
        }

        System.out.println("Candidate is :: " + candidate + " and count is :: " + count);
    }

    public static void main(String[] args) {
        int[] numbs = { 1, 1, 1, 1, 2, 2, 2, 2, 2 };

        majority(numbs);
    }
}
