public class AVLTree {
    private class AVLNode {
        private final Patient patient;
        private int height;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode(Patient patient) {
            this.patient = patient;
        }

        @Override
        public String toString() {
            return "Value = " + this.patient.getPatientKey();
        }
    }

    /** Line color */
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    private AVLNode root;

    public void insertKey(Patient patient) {
        root = insertWithOrderKey(root, patient);
    }

    public void insertHealth(Patient patient) {
        root = insertWithOrderHealth(root, patient);
    }

    /** Create AVLTree With ID */
    private AVLNode insertWithOrderKey(AVLNode root,Patient patient) {
        if (root == null)
            return new AVLNode(patient);

        if (patient.getPatientKey() < root.patient.getPatientKey())
            root.leftChild = insertWithOrderKey(root.leftChild, patient);
        else
            root.rightChild = insertWithOrderKey(root.rightChild, patient);

        setHeight(root);

        return balance(root);
    }

    /** Create AVLTree With HealthMeasure */
    private AVLNode insertWithOrderHealth(AVLNode root,Patient patient) {
        if (root == null)
            return new AVLNode(patient);

        if (patient.getPatientHealthMeasure() < root.patient.getPatientHealthMeasure())
            root.leftChild = insertWithOrderHealth(root.leftChild, patient);
        else
            root.rightChild = insertWithOrderHealth(root.rightChild, patient);

        setHeight(root);

        return balance(root);
    }

    public Patient minValueNode() {
        AVLNode current = root;

        while (current.leftChild != null)
            current = current.leftChild;

        return current.patient;
    }

    public AVLNode minValueNode(AVLNode node) {
        AVLNode current = node;

        while (current.leftChild != null)
            current = current.leftChild;

        return current;
    }

    public void deleteNodeKey(Patient patient){
        root = deleteNodeMainKey(root, patient);
    }

    private AVLNode deleteNodeMainKey(AVLNode root, Patient patient) {

        if (root == null)
            return null;

        if (patient.getPatientKey() < root.patient.getPatientKey())
            root.leftChild = deleteNodeMainKey(root.leftChild, patient);

        else if (patient.getPatientKey() > root.patient.getPatientKey())
            root.rightChild = deleteNodeMainKey(root.rightChild, patient);

        else {
            if ((root.leftChild == null) || (root.rightChild == null)) {

                AVLNode temp;
                if (null == root.leftChild)
                    temp = root.rightChild;
                else
                    temp = root.leftChild;

                if (temp == null) {
                    root = null;
                }
                else
                    root = temp;
            }
            else {

                AVLNode temp = minValueNode(root.rightChild);

                root.patient.setPatientKey(temp.patient.getPatientKey());
                root.patient.setPatientHealthMeasure(temp.patient.getPatientHealthMeasure());

                root.rightChild = deleteNodeMainKey(root.rightChild, temp.patient);
            }
        }

        if (root == null)
            return null;

        root.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;

        int balance = balanceFactor(root);

        if (balance > 1 && balanceFactor(root.leftChild) >= 0)
            return rotateRight(root);

        if (balance > 1 && balanceFactor(root.leftChild) < 0) {
            root.leftChild = rotateLeft(root.leftChild);
            return rotateRight(root);
        }

        if (balance < -1 && balanceFactor(root.rightChild) <= 0)
            return rotateLeft(root);

        if (balance < -1 && balanceFactor(root.rightChild) > 0) {
            root.rightChild = rotateRight(root.rightChild);
            return rotateLeft(root);
        }

        return root;
    }

    public void deleteNodeHealth(Patient patient){
        root = deleteNodeMainHealth(root, patient);
    }

    private AVLNode deleteNodeMainHealth(AVLNode root, Patient patient) {

        if (root == null)
            return null;

        if (patient.getPatientHealthMeasure() < root.patient.getPatientHealthMeasure())
            root.leftChild = deleteNodeMainHealth(root.leftChild, patient);

        else if (patient.getPatientHealthMeasure() > root.patient.getPatientHealthMeasure())
            root.rightChild = deleteNodeMainHealth(root.rightChild, patient);

        else {
            if ((root.leftChild == null) || (root.rightChild == null)) {

                AVLNode temp;
                if (null == root.leftChild)
                    temp = root.rightChild;
                else
                    temp = root.leftChild;

                if (temp == null) {
                    root = null;
                }
                else
                    root = temp;
            }
            else {

                AVLNode temp = minValueNode(root.rightChild);

                root.patient.setPatientKey(temp.patient.getPatientKey());
                root.patient.setPatientHealthMeasure(temp.patient.getPatientHealthMeasure());

                root.rightChild = deleteNodeMainHealth(root.rightChild, temp.patient);
            }
        }

        if (root == null)
            return null;

        root.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;

        int balance = balanceFactor(root);

        if (balance > 1 && balanceFactor(root.leftChild) >= 0)
            return rotateRight(root);

        if (balance > 1 && balanceFactor(root.leftChild) < 0) {
            root.leftChild = rotateLeft(root.leftChild);
            return rotateRight(root);
        }

        if (balance < -1 && balanceFactor(root.rightChild) <= 0)
            return rotateLeft(root);

        if (balance < -1 && balanceFactor(root.rightChild) > 0) {
            root.rightChild = rotateRight(root.rightChild);
            return rotateLeft(root);
        }

        return root;
    }

    private AVLNode balance(AVLNode root) {
        if (isLeftHeavy(root)) {
            if (balanceFactor(root.leftChild) < 0)
                root.leftChild = rotateLeft(root.leftChild);
            return rotateRight(root);
        }
        else if (isRightHeavy(root)) {
            if (balanceFactor(root.rightChild) > 0)
                root.rightChild = rotateRight(root.rightChild);
            return rotateLeft(root);
        }
        return root;
    }

    private AVLNode rotateLeft(AVLNode root) {
        AVLNode newRoot = root.rightChild;

        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private AVLNode rotateRight(AVLNode root) {
        AVLNode newRoot = root.leftChild;

        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private void setHeight(AVLNode node) {
        node.height = Math.max(
                height(node.leftChild),
                height(node.rightChild)) + 1;
    }

    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node) {
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    public void updatePatient(int key,int health,int code) {

        if (code == 0)
            deleteNodeKey(find(key));
        else if (code == 1) {
            deleteNodeHealth(findHealth(health));
        }
    }

    public Patient find(int key){
        AVLNode current = root;

        while (current != null) {
            int comparison = key - (current.patient.getPatientKey());
            if (comparison == 0) {
                return current.patient;
            }
            else if (comparison < 0)
                current = current.leftChild;
            else
                current = current.rightChild;
        }
        return new Patient(0,0);
    }

    public Patient findHealth(int key){
        AVLNode current = root;

        while (current != null) {
            int comparison = key - (current.patient.getPatientHealthMeasure());
            if (comparison == 0) {
                return current.patient;
            }
            else if (comparison < 0)
                current = current.leftChild;
            else
                current = current.rightChild;
        }
        return new Patient(0,0);
    }

    public boolean contains(int key){
        AVLNode current = root;

        while (current != null) {
            int comparison = key - (current.patient.getPatientKey());
            if (comparison == 0) {
                return true;
            }
            else if (comparison < 0)
                current = current.leftChild;
            else
                current = current.rightChild;
        }

        return false;
    }

    private AVLNode updatePatientMain(int key,int health) {

        Patient patient = new Patient(key,health);
        AVLNode current = root;

        while (current != null) {
            int comparison = patient.getPatientKey() - (current.patient.getPatientKey());
            if (comparison == 0) {
                current.patient.setPatientHealthMeasure(patient.getPatientHealthMeasure());
                setHeight(root);
                return balance(root);
            }
            else if (comparison < 0)
                current = current.leftChild;
            else
                current = current.rightChild;
        }

        return balance(root);
    }

    /** TraverseInOrder */

    public void traverseInOrder() {
        traverseInOrderMain(root);
    }

    private void traverseInOrderMain(AVLNode root) {
        if (root == null)
            return;
        traverseInOrderMain(root.leftChild);
        System.out.println("\t \t \t" + ANSI_BLUE + root.patient.getPatientKey() + " " + root.patient.getPatientHealthMeasure());
        traverseInOrderMain(root.rightChild);
    }

    /** TraversePreOrder */
    public void traversePreOrder(){
        traversePreOrderMain(root);
    }

    private void traversePreOrderMain(AVLNode root) {
        if (root != null) {
            System.out.println(root.patient.getPatientKey() + " " + root.patient.getPatientHealthMeasure());
            traversePreOrderMain(root.leftChild);
            traversePreOrderMain(root.rightChild);
        }
    }

}



















