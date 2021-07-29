public class Reception {

    private final AVLTree patientStorageKeyAvl = new AVLTree();
    private final AVLTree patientStorageHealthAvl = new AVLTree();
    private final Deque patientStorageQueue = new Deque();


    /** Line color */
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public void insertPatient(Patient patient){
        patientStorageKeyAvl.insertKey(patient);
        patientStorageHealthAvl.insertHealth(patient);
        patientStorageQueue.insertRear(patient);
    }

    public void serveFirst(){
        System.out.println("\n" + "\t \t" + ANSI_RED +  "--> ServeFirst " + ANSI_RED);
        System.out.println(ANSI_RESET);
        while (true) {
            Patient patientDelete = patientStorageQueue.deleteFront();
            Patient patientDeleteOriginal = patientStorageKeyAvl.find(patientDelete.getPatientKey());
            if (patientDeleteOriginal.getPatientKey() != 0) {
                System.out.println("\t \t \t" + ANSI_BLUE + patientDeleteOriginal.getPatientKey() + " " + patientDeleteOriginal.getPatientHealthMeasure());
                System.out.print(ANSI_RESET);
                patientStorageKeyAvl.deleteNodeKey(patientDeleteOriginal);
                patientStorageHealthAvl.deleteNodeHealth(patientDeleteOriginal);
                return;
            }
        }
    }

    public void serveSickest(){
        System.out.println("\n" + "\t \t" + ANSI_RED + "--> ServeSickest ");
        System.out.println(ANSI_RESET);
        Patient sickestPatient  = patientStorageHealthAvl.minValueNode();
        System.out.println("\t \t \t " + ANSI_BLUE + sickestPatient.getPatientKey()+ " " + sickestPatient.getPatientHealthMeasure());
        System.out.print(ANSI_RESET);
        patientStorageKeyAvl.deleteNodeKey(sickestPatient);
        patientStorageHealthAvl.deleteNodeHealth(sickestPatient);
    }

    public void updatePatient(int key,int health){

        Patient updatePatient = patientStorageKeyAvl.find(key);

        patientStorageKeyAvl.updatePatient(updatePatient.getPatientKey(),updatePatient.getPatientHealthMeasure(),0);
        patientStorageHealthAvl.updatePatient(updatePatient.getPatientKey(),updatePatient.getPatientHealthMeasure(),1);

        patientStorageKeyAvl.insertKey(new Patient(key,health));
        patientStorageHealthAvl.insertHealth(new Patient(key,health));

        System.out.println("\n" + "\t \t" + ANSI_PURPLE + "--> UPDATE DO WORK CORRECTLY :) ");
        System.out.print(ANSI_RESET);
    }

    public void disPlayPatient(){
        System.out.println(ANSI_RESET);
        System.out.println("\t \t" + ANSI_GREEN + "--> Display Patient By Id --> traverseInOrder " + ANSI_GREEN);
        System.out.println(ANSI_RESET);
        patientStorageKeyAvl.traverseInOrder();
        System.out.print(ANSI_RESET);
        System.out.println("\n" + "\t \t" + ANSI_GREEN + "--> Display Patient By Health --> traverseInOrder " + ANSI_GREEN );
        System.out.println(ANSI_RESET);
        patientStorageHealthAvl.traverseInOrder();
        System.out.print(ANSI_RESET);
    }

}
