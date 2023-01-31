package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {
    private boolean isFin = false;
    private boolean isCompl = false;
//    Конструктор CompleteByRequestTask не принимает параметров.

    @Override
    public void execute() {
//        Вызов метода execute для задачи не завершает ее до тех пор,
//        пока не будет вызван метод complete.
//        После вызова полного метода complete следующий вызов
//        метода execute завершает задачу.
//        Обратите внимание, что задача не завершается сразу после
//        вызова метода complete.
//        Задача завершается только тогда, когда происходит последующий
//        вызов для выполнения.
        if (isCompl) {
            isFin = true;
        }
    }

    @Override
    public boolean isFinished() {
        return isFin;
    }

    public void complete() {
        isCompl = true;
    }

    public boolean isFinishedNonDisrupting() {
        return isFin;
    }
}
