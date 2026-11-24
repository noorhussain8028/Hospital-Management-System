
package hospitalmanagementsystem;

public class Appointment {

    private int appointmentId;
    private Patient patient;
    private Doctor doctor;
    private String appointmentDate;

    public Appointment(int appointmentId, Patient patient,
                       Doctor doctor, String appointmentDate) {

        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
    }

    public int getDoctorId() {
        return doctor.getId();
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void displayAppointment() {
        System.out.println("--------------------------------");
        System.out.println("Appointment ID : " + appointmentId);
        System.out.println("Patient Name   : " + patient.getName());
        System.out.println("Doctor Name    : " + doctor.getName());
        System.out.println("Date           : " + appointmentDate);
        System.out.println("--------------------------------");
    }
}
