package com.fanfte.collection;

public class Student implements Comparable<Student> {

    private int score;
    private String name;

    public Student(int score, String name) {
        this.score = score;
        this.name = name;
    }

    @Override
    public int compareTo(Student s) {
        if(this.score < s.score) {
            return 1;
        } else if(this.score > s.score){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return this.name + " -> " + this.score;
    }
}
