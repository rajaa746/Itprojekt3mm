import java.util.ArrayList;
import java.util.List;

public class PatientDao {
    private List<Patient> patients = new ArrayList<>();
    private static PatientDao instance = new PatientDao();

    private PatientDao(){
        Patient melman = new Patient();
        Patient marius = new Patient();
        melman.setName("melman");
        marius.setName("marius");
        patients.add(melman);
        patients.add(marius);
    }

    public static  PatientDao getInstance(){
        return instance;
    }


    public List<Patient> getPatients() {
        return patients;
    }
}
