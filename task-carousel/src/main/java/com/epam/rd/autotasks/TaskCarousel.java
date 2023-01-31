package com.epam.rd.autotasks;

public class TaskCarousel {
    private static int capacity;
    private final Task[] tasksCarousel;
    private int countForAdding = 0;
    private static int countForWork = 0;

    public TaskCarousel(int capacity) {
        countForWork = 0;
        this.capacity = capacity;
        tasksCarousel = new Task[capacity];
    }

    public boolean addTask(Task task) {
//        добавляет задачи в карусель.
//        Возвращает true, если задача принята, и false в противном случае.
//        Задание может быть не принято по следующим причинам:
//         аргумент задачи равен нулю
//         задача уже завершена
//         карусель заполнена
        if (!isFull() && !task.isFinishedNonDisrupting()) {
            for (int i = 0; i < capacity; i++) {
                if (tasksCarousel[countForAdding] == null) {
                    tasksCarousel[countForAdding] = task;
                    countForAdding++;
                    if (countForAdding >= capacity) {
                        countForAdding = 0;
                    }
                    return true;
                } else {
                    countForAdding++;
                    if (countForAdding >= capacity) {
                        countForAdding = 0;
                    }
                }
            }
        }
        return false;
    }

    public boolean execute() {
//выполняет задачи в карусели
//каждый раз при вызове этого метода карусель должна переключаться на
//следующую задачу и выполнять ее.
        for (int i = 0; i < capacity; i++) {
            if (tasksCarousel[countForWork] != null && !tasksCarousel[countForWork].isFinishedNonDisrupting()) {
                tasksCarousel[countForWork].execute();
                if (tasksCarousel[countForWork].isFinishedNonDisrupting()) {
                    tasksCarousel[countForWork] = null;
                }
                incrementCountForWork();
                return true;
            }
            incrementCountForWork();
        }
        return false;
//Итерация круговая. Если внутри карусели 4 задачи, то если мы вызовем
//метод на карусели 4 раза подряд, каждая задача должна быть
//выполнена один раз
//Если задача завершена после выполнения, удалить ее из карусели.
//Метод возвращает true, если какая-либо задача была выполнена. В противном
//случае возвращает false.
    }

    public boolean isFull() {
//        возвращает true если в карусели больше нет места
//        для добавления другой задачи. В противном случае возвращает false.
        for (int i = 0; i < capacity; i++) {
                if (tasksCarousel[i] == null || tasksCarousel[i].isFinishedNonDisrupting()) {
                    return false;
                }
        }
        return true;
    }

    public boolean isEmpty() {
//        возвращает true если в карусели нет задачи для выполнения.
//        В противном случае возвращает false.
        for (int i = 0; i < capacity; i++) {
            int counterFinished = 0;
            for (Task task : tasksCarousel) {
                if (task == null || task.isFinishedNonDisrupting()) {
                    counterFinished++;
                }
            }
            if (counterFinished == capacity) {
                return true;
            }
        }
        return false;
    }

    public static void incrementCountForWork() {
        countForWork++;
        if (countForWork >= capacity) {
            countForWork = 0;
        }
    }
}
