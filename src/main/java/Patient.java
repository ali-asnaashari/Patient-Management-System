public class Patient {
    private int patientKey;
    private int patientHealthMeasure;

    public Patient(int patientKey,int healthMeasure){
        this.patientKey = patientKey;
        this.patientHealthMeasure = healthMeasure;
    }

    public int getPatientKey() {
        return patientKey;
    }

    public void setPatientKey(int patientKey) {
        this.patientKey = patientKey;
    }

    public int getPatientHealthMeasure() {
        return patientHealthMeasure;
    }

    public void setPatientHealthMeasure(int patientHealthMeasure) {
        this.patientHealthMeasure = patientHealthMeasure;
    }
}
