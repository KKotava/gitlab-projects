package com.epam.rd.autotasks;

public class DecrementingCarousel {
    protected int[] storage;

    protected int capacity;

    private boolean isRunning = false;

    private int size = 0;
    protected int position = 0;

    public DecrementingCarousel(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
            storage = new int[capacity];
        } else {
            throw new IllegalArgumentException("Carousel can't contain zero or less elements");
        }

    }

    public boolean addElement(int element) {
        if (isRunning || element <= 0 || size >= capacity) {
            return false;
        } else {
            storage[size] = element;
            size++;
            return true;
        }
    }

    public CarouselRun run() {
        if (!isRunning) {
            setRunning(true);
            return new CarouselRun(this);
        } else {
            return null;
        }

    }

    public int next() {
        int count = 0;

        if (allNegative(storage)) {
            return -1;
        }
        if (position >= capacity) {
            position = 0;
        }
        while (count < capacity &&
                storage[position %= capacity] <= 0) {
            position++;
            count++;
        }
        if (count == capacity) {
            return -1;
        }

        return storage[position++]--;

    }

    public boolean isFinished() {
        for (int i : storage) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean allNegative(int carousel[]) {
        for (int i = 0; i < capacity; i++) {
            if (carousel[i] > 0) return false;
        }
        return true;
    }


    public void setRunning(boolean running) {
        isRunning = running;
    }
}
