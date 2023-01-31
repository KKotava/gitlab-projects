package com.epam.rd.autotasks;

import java.util.Arrays;

public class DecrementingCarousel {
    protected int[] storage;
    protected final int capacity;
    private boolean isRunning = false;
    private int currentStorageSize = 0;
    protected int position = 0;

    /**
     * @throws IllegalArgumentException if provided capacity is not positive
     * @param capacity carousel capacity
     */
    public DecrementingCarousel(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
            storage = new int[capacity];
        } else {
            throw new IllegalArgumentException("Carousel can't contain zero or less elements");
        }
    }

    /**
     * Add element to carousel. Return true if added successfully.
     * @param element number to add to storage
     * @return false if carousel is running or element is negative or storage is full, otherwise true
     */
    public boolean addElement(int element) {
        if (isRunning || element <= 0 || currentStorageSize >= capacity) {
            return false;
        } else {
            storage[currentStorageSize] = element;
            currentStorageSize++;
            return true;
        }
    }
    public int next() {
        int counter = 0;
        if (isFinished()) {
            return -1;
        }
        while (counter < capacity
                && storage[position %= capacity] == 0) {
            position++;
            counter++;
        }
        if (counter == capacity) {
            return -1;
        }
        return storage[position++]--;
    }

    public CarouselRun run() {
        if (!isRunning) {
            setRunning();
            return new CarouselRun(this);
        } else {
            return null;
        }
    }

    public boolean isFinished() {
        return Arrays.stream(storage).collect(element -> element <= 0);
    }

    private void setRunning() {
        isRunning = true;
    }
}
