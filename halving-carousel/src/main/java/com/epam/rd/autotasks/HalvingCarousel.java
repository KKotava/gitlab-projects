package com.epam.rd.autotasks;

public class HalvingCarousel extends DecrementingCarousel {
    public HalvingCarousel(final int capacity) {
        super(capacity);
    }

    @Override
    public int next() {
        int counter = 0;
        if (isFinished()) {
            return -1;
        }
        while (counter < capacity
                && storage[position] == 0) {
            position++;
            counter++;
            if (position == capacity) {
                position = 0;
            }
        }
        int temp = storage[position];
        storage[position] = storage[position] / 2;
        position++;
        if (position >= capacity) {
            position = 0;
        }
        return temp;
    }
}
