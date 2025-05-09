package com.example.os_project;

public class CounterModel {
    private volatile long counter;
    private volatile int updateInterval;
    private boolean running;

    public CounterModel(long counter, boolean running, int updateInterval) {
        this.counter = counter;
        this.running = running;
        this.updateInterval = updateInterval;
    }

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getUpdateInterval() {
        return updateInterval;
    }

    public void setUpdateInterval(int updateInterval) {
        this.updateInterval = updateInterval;
    }

    @Override
    public String toString() {
        return "CounterModel{" +
                "counter=" + counter +
                ", updateInterval=" + updateInterval +
                ", running=" + running +
                '}';
    }
}
