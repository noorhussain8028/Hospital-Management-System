package hospitalmanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();

    static int patientId = 1;
    static int appointmentId = 1;


    public static void main(String[] args) {

        // Default Doctors

        doctors.add(new Doctor(1, "Gulsher laghari", "Cardiologist"));
        doctors.add(new Doctor(2, "Noor Hussain", "Neurologist"));
        doctors.add(new Doctor(3, "Nazil lohana", "Dermatologist"));

        while (true) {

            System.out.println("\n==================================");
            System.out.println("    HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("==================================");

            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. View Doctors");
            System.out.println("4. Book Appointment");
            System.out.println("5. View Appointments");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    addPatient();
                    break;

                case 2:
                    viewPatients();
                    break;

                case 3:
                    viewDoctors();
                    break;

                case 4:
                    bookAppointment();
                    break;

                case 5:
                    viewAppointments();
                    break;

                case 6:
                    System.out.println("Thank you for using Hospital Management System!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid Choice! Try Again.");
            }
        }
    }


    // Add Patient

    public static void addPatient() {

        scanner.nextLine();

        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Patient Age: ");
        int age = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter Patient Gender: ");
        String gender = scanner.nextLine();

        Patient patient = new Patient(patientId, name, age, gender);

        patients.add(patient);

        System.out.println("Patient Added Successfully!");
        System.out.println("Patient ID: " + patientId);

        patientId++;
    }



    public static void viewPatients() {

        if (patients.isEmpty()) {
            System.out.println("No Patients Found!");
            return;
        }

        System.out.println("\n------ PATIENT LIST ------");

        for (Patient patient : patients) {
            patient.displayPatient();
        }
    }


    // View Doctors

    public static void viewDoctors() {

        System.out.println("\n------ DOCTOR LIST ------");

        for (Doctor doctor : doctors) {
            doctor.displayDoctor();
        }
    }


    // Book Appointment

    public static void bookAppointment() {

        if (patients.isEmpty()) {
            System.out.println("No Patients Registered!");
            return;
        }

        System.out.print("Enter Patient ID: ");
        int pId = scanner.nextInt();

        System.out.print("Enter Doctor ID: ");
        int dId = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter Appointment Date (DD-MM-YYYY): ");
        String date = scanner.nextLine();

        Patient selectedPatient = null;
        Doctor selectedDoctor = null;

        // Find Patient

        for (Patient patient : patients) {

            if (patient.getId() == pId) {
                selectedPatient = patient;
                break;
            }
        }

        // Find Doctor

        for (Doctor doctor : doctors) {

            if (doctor.getId() == dId) {
                selectedDoctor = doctor;
                break;
            }
        }

        // Check Patient and Doctor

        if (selectedPatient == null || selectedDoctor == null) {
            System.out.println("Invalid Patient ID or Doctor ID!");
            return;
        }

        // Check Doctor Availability

        for (Appointment appointment : appointments) {

            if (appointment.getDoctorId() == dId &&
                    appointment.getAppointmentDate().equals(date)) {

                System.out.println("Doctor is not available on this date!");
                return;
            }
        }

        // Create Appointment

        Appointment appointment = new Appointment(
                appointmentId,
                selectedPatient,
                selectedDoctor,
                date
        );

        appointments.add(appointment);

        System.out.println("Appointment Booked Successfully!");
        System.out.println("Appointment ID: " + appointmentId);

        appointmentId++;
    }


    // View Appointments

    public static void viewAppointments() {

        if (appointments.isEmpty()) {
            System.out.println("No Appointments Found!");
            return;
        }

        System.out.println("\n------ APPOINTMENT LIST ------");

        for (Appointment appointment : appointments) {
            appointment.displayAppointment();
        }
    }
}