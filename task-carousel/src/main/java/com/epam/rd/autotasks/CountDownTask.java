package com.epam.rd.autotasks;

public class CountDownTask implements Task {
    private int value;

    public CountDownTask(int value) {
//        Это начальное значение обратного отсчета.
        if (value > 0) {
            this.value = value;
        } else {
            this.value = 0;
//        Если задача инициализирована с нулевым значением,
//        считайте ее завершенной сразу после создания.
        }
    }

    public int getValue() {
        return value;
    }


    @Override
    public void execute() {
//        Каждый раз, когда вызывается метод execute,
//        value уменьшается на единицу, пока не достигнет нуля.
        if (value > 0) {
            value--;
//        После этого метод execute больше не уменьшает значение,
//        и задача считается завершенной.
        }

    }

    @Override
    public boolean isFinished() {
        if (value == 0) {
            TaskCarousel.incrementCountForWork();
        }
        return (value == 0);
    }

    public boolean isFinishedNonDisrupting() {
        return (value == 0);
    }
}
