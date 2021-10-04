package com.duncan_robertson.counter;

public class CounterResponse {
    int counter;

    public CounterResponse(int counter) {
        this.counter = counter;
    }

    public int getCounter() {
        return this.counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}