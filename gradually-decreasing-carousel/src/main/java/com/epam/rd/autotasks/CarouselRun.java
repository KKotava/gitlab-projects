package com.epam.rd.autotasks;

public class CarouselRun {
    private DecrementingCarousel decrementingCarousel;
    public CarouselRun(DecrementingCarousel carousel) {
        this.decrementingCarousel = carousel;
    }


    public int next() {
        return decrementingCarousel.next();
    }

    public boolean isFinished() {
        return decrementingCarousel.isFinished();
    }

}