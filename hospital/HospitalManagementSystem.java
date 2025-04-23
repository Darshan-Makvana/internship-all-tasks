import java.io.*;
import java.util.*;

// Base class for common attributes
class Person implements Serializable {
    private String name;
    private int age;
    private String gender;
    private String contactNumber;

    public Person(String name, int age, String gender, String contactNumber) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Contact: " + contactNumber;
    }
}

// Patient class
class Patient extends Person {
    private String address;
    private String medicalHistory;
    private String admissionDate;

    public Patient(String name, int age, String gender, String contactNumber, String address,
                   String medicalHistory, String admissionDate) {
        super(name, age, gender, contactNumber);
        this.address = address;
        this.medicalHistory = medicalHistory;
        this.admissionDate = admissionDate;
    }

    public String getAddress() {
        return address;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    @Override
    public String toString() {
        return super.toString() + ", Address: " + address + ", Medical History: " + medicalHistory +
                ", Admission Date: " + admissionDate;
    }
}

// Staff class
class Staff extends Person {
    private String role;
    private String department;

    public Staff(String name, int age, String gender, String contactNumber, String role, String department) {
        super(name, age, gender, contactNumber);
        this.role = role;
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return super.toString() + ", Role: " + role + ", Department: " + department;
    }
}

// Appointment class
class Appointment implements Serializable {
    private final String patientName;
    private final String doctorName;
    private final String dateTime;
    private final String reason;

    public Appointment(String patientName, String doctorName, String dateTime, String reason) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.dateTime = dateTime;
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Patient: " + patientName + ", Doctor: " + doctorName +
                ", DateTime: " + dateTime + ", Reason: " + reason;
    }
}

// Bill class
class Bill implements Serializable {
    private final String patientName;
    private final double consultationFee;
    private final double roomCharges;
    private final double serviceCharges;
    private boolean isPaid;

    public Bill(String patientName, double consultationFee, double roomCharges, double serviceCharges) {
        this.patientName = patientName;
        this.consultationFee = consultationFee;
        this.roomCharges = roomCharges;
        this.serviceCharges = serviceCharges;
        this.isPaid = false;
    }

    public double calculateTotal() {
        return consultationFee + roomCharges + serviceCharges;
    }

    public void markAsPaid() {
        isPaid = true;
    }

    @Override
    public String toString() {
        return "Patient: " + patientName + ", Total: " + calculateTotal() +
                ", Paid: " + isPaid;
    }
}

// Main Hospital Management System
public class HospitalManagementSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Patient> patients = new ArrayList<>();
    private static final List<Staff> staffMembers = new ArrayList<>();
    private static final List<Appointment> appointments = new ArrayList<>();
    private static final List<Bill> bills = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Staff Member");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View Appointments");
            System.out.println("5. Generate Bill");
            System.out.println("6. View Bills");
            System.out.println("7. Generate Reports");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1 -> addPatient();
                case 2 -> addStaffMember();
                case 3 -> scheduleAppointment();
                case 4 -> viewAppointments();
                case 5 -> generateBill();
                case 6 -> viewBills();
                case 7 -> generateReports();
                case 8 -> {
                    System.out.println("Exiting the system...");
                    return;
                }
                default -> System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private static void addPatient() {
        System.out.println("Enter patient details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        System.out.print("Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Contact Number: ");
        String contact = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Medical History: ");
        String history = scanner.nextLine();
        System.out.print("Admission Date (dd/mm/yyyy): ");
        String date = scanner.nextLine();

        Patient patient = new Patient(name, age, gender, contact, address, history, date);
        patients.add(patient);
        System.out.println("Patient added successfully!");
    }

    private static void addStaffMember() {
        System.out.println("Enter staff details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        System.out.print("Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Contact Number: ");
        String contact = scanner.nextLine();
        System.out.print("Role: ");
        String role = scanner.nextLine();
        System.out.print("Department: ");
        String department = scanner.nextLine();

        Staff staff = new Staff(name, age, gender, contact, role, department);
        staffMembers.add(staff);
        System.out.println("Staff member added successfully!");
    }

    private static void scheduleAppointment() {
        System.out.println("Enter appointment details:");
        System.out.print("Patient Name: ");
        String patientName = scanner.nextLine();
        System.out.print("Doctor Name: ");
        String doctorName = scanner.nextLine();
        System.out.print("Date and Time (dd/mm/yyyy hh:mm): ");
        String dateTime = scanner.nextLine();
        System.out.print("Reason for Appointment: ");
        String reason = scanner.nextLine();

        Appointment appointment = new Appointment(patientName, doctorName, dateTime, reason);
        appointments.add(appointment);
        System.out.println("Appointment scheduled successfully!");
    }

    private static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
        } else {
            System.out.println("\n--- List of Appointments ---");
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }

    private static void generateBill() {
        System.out.println("Enter billing details:");
        System.out.print("Patient Name: ");
        String patientName = scanner.nextLine();
        System.out.print("Consultation Fee: ");
        double consultationFee = scanner.nextDouble();
        System.out.print("Room Charges: ");
        double roomCharges = scanner.nextDouble();
        System.out.print("Service Charges: ");
        double serviceCharges = scanner.nextDouble();
        scanner.nextLine(); // Clear buffer

        Bill bill = new Bill(patientName, consultationFee, roomCharges, serviceCharges);
        bills.add(bill);
        System.out.println("Bill generated successfully!");
    }

    private static void viewBills() {
        if (bills.isEmpty()) {
            System.out.println("No bills found.");
        } else {
            System.out.println("\n--- List of Bills ---");
            for (Bill bill : bills) {
                System.out.println(bill);
            }
        }
    }

    private static void generateReports() {
        System.out.println("\n--- Reports ---");
        System.out.println("1. Appointments for a Day");
        System.out.println("2. Total Earnings");
        System.out.print("Choose a report type: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        switch (choice) {
            case 1 -> {
                System.out.print("Enter date (dd/mm/yyyy): ");
                String date = scanner.nextLine();
                System.out.println("\n--- Appointments on " + date + " ---");
                for (Appointment appointment : appointments) {
                    if (appointment.toString().contains(date)) {
                        System.out.println(appointment);
                    }
                }
            }
            case 2 -> {
                double totalEarnings = 0;
                for (Bill bill : bills) {
                    totalEarnings += bill.calculateTotal();
                }
                System.out.println("Total Earnings: " + totalEarnings);
            }
            default -> System.out.println("Invalid report type.");
        }
    }
}
