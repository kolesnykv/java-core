package com.knubisoft.base.queue;

import com.knubisoft.base.queue.car.Car;
import com.knubisoft.base.queue.car.CarComparator;

import java.util.*;

public class QueueTasksImpl implements QueueTasks {

    @Override
    public Queue<Integer> reverseQueueUsingRecursion(Queue<Integer> queue) {
        if (queue.isEmpty())
            return queue;
        // Dequeue current item (from front)
        int data = queue.peek();
        queue.remove();
        // Reverse remaining queue
        queue = reverseQueueUsingRecursion(queue);
        // Enqueue current item (to rear)
        queue.add(data);
        return queue;

    }

    @Override
    public Queue<Integer> reverseFirstKElementsOfQueue(Queue<Integer> queue, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        if (k<=queue.size()) {
            for (int i = 0; i < k; i++) {
                list.addFirst(queue.peek());
                queue.poll();
            }
            while (!queue.isEmpty()) {
                list.addLast(queue.peek());
                queue.poll();
            }
            for (int i : list) {
                queue.offer(i);
            }
        }
        return queue;
    }

    @Override
    public Queue<Integer> sortQueueOfInt(Queue<Integer> queue) {
        return null;
    }

    @Override
    public boolean validParentheses(String parentheses) {
        return false;
    }

    @Override
    public PriorityQueue<Car> implementPriorityQueueThroughComparator(List<Car> cars) {
        PriorityQueue<Car> queue = new PriorityQueue<>(cars.size(), new CarComparator());
        queue.addAll(cars);
        return queue;
    }

}
