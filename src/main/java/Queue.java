import java.util.Arrays;

public class Queue {
    public static Patient[] items;
    private static int rear;
    private static int front;
    private static int count;

    public Queue(int capacity) {
        items = new Patient[capacity];
    }

    public void enqueue(Patient item) {
        if (isFull())
            throw new IllegalStateException();

        items[rear] = item;
        rear = (rear + 1) % items.length;
        count++;
    }

    public Patient dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        Patient item = items[front];
        items[front] = new Patient(0,0);
        front = (front + 1) % items.length;
        count--;

        return item;
    }

    public Patient peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return items[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public static boolean isFull() {
        return count == items.length;
    }

    public static void display(){
        for (int i = 0;i<count;i++){
            System.out.println(items[i].getPatientKey() + "  " + items[i].getPatientHealthMeasure());
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

}
