public class Deque {
    private class QueueNode {
        private final Patient patient;
        private QueueNode prev, next;

        public QueueNode(Patient patient) {
            this.patient = patient;
            this.prev = this.next = null;
        }

        public Patient getPatient(){
            return patient;
        }
    }

    public QueueNode front;
    public QueueNode rear;
    private int Size;

    public Deque() {
        front = rear = null;
        Size = 0;
    }

    public boolean isEmpty() { return (front == null); }

    public int size() { return Size; }

    public void insertRear(Patient patient) {
        QueueNode newNode = new QueueNode(patient);

        if (rear == null)
            front = rear = newNode;
        else {
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
        }

        Size++;
    }

    public Patient deleteFront() {

        QueueNode temp = front;

        if (isEmpty())
            System.out.println("\t \t" + "PatientStorage Is Empty");
        else {

            front = front.next;

            if (front == null)
                rear = null;
            else
                front.prev = null;
            Size--;
        }
        return temp.getPatient();
    }

    public Patient getFront() {
        if (isEmpty())
            return null;
        return front.getPatient();
    }

    public void cleanUp() {
        rear = null;
        while (front != null) {
            QueueNode temp = front;
            front = front.next;
        }
        Size = 0;
    }

}
