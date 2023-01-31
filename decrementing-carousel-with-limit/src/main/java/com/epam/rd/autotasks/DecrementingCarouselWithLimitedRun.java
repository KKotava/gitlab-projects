package com.epam.rd.autotasks;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel {
    private final int limit;
    protected int count = 0;

    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
        limit = actionLimit;
    }

    @Override
    public int next() {
        if (count < limit) {
            count++;
            return super.next();
        } else {
            isFin = true;
            return -1;
        }
    }

    @Override
    public boolean isFinished() {
        if (count >= limit) {
            return true;
        } else {
            return super.isFinished();
        }
    }
}
