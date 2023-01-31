package com.epam.rd.autotasks;

public class GraduallyDecreasingCarousel extends DecrementingCarousel{
    private int decrease = 1;
    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
    }

    @Override
    public int next(){
        int count = 0;
        if (allNegative(storage)) {
            return -1;
        }
        while (count < capacity &&
                storage[position] == 0) {
            position++;
            count++;
            if (position == capacity) {
                position = 0;
                decrease++;
            }
        }
        int temp = storage[position];
        if (storage[position] <= decrease) {
            storage[position] = 0;
        } else {
            storage[position] = storage[position] - decrease;
        }
        position++;
        if (position == capacity) {
            position = 0;
            decrease++;
        }
        return temp;
    }

}
