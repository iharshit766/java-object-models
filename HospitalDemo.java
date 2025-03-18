import java.util.ArrayList;
import java.util.List;

// Hospital class containing doctors and patients
class Hospital {
    private String name;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void displayHospitalInfo() {
        System.out.println("Hospital: " + name);
        System.out.println("Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("  " + doctor.getName());
        }
        System.out.println("\nPatients:");
        for (Patient patient : patients) {
            System.out.println("  " + patient.getName());
        }
    }
}

// Doctor class (associated with multiple patients)
class Doctor {
    private String name;
    private List<Patient> patients;

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void consult(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
            patient.addDoctor(this);
        }
        System.out.println(name + " is consulting " + patient.getName());
    }
}

// Patient class (associated with multiple doctors)
class Patient {
    private String name;
    private List<Doctor> doctors;

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }
}

// HospitalDemo class to demonstrate association and communication
public class HospitalDemo {
    public static void main(String[] args) {
        // Creating a hospital
        Hospital hospital = new Hospital("City Hospital");

        // Creating doctors
        Doctor drSmith = new Doctor("Dr. Smith");
        Doctor drJones = new Doctor("Dr. Jones");
        hospital.addDoctor(drSmith);
        hospital.addDoctor(drJones);

        // Creating patients
        Patient patientAlice = new Patient("Alice");
        Patient patientBob = new Patient("Bob");
        hospital.addPatient(patientAlice);
        hospital.addPatient(patientBob);

        // Consulting between doctors and patients
        drSmith.consult(patientAlice);
        drJones.consult(patientBob);
        drSmith.consult(patientBob);

        // Displaying hospital info
        hospital.displayHospitalInfo();
    }
}
