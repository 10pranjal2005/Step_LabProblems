package LabProblems;
class Vehicle {
    private String vehicleId, brand, model;
    private double rentPerDay;
    private boolean isAvailable = true;
    private static int totalVehicles = 0;
    private static double totalRevenue = 0;

    public Vehicle(String b, String m, double r) {
        totalVehicles++;
        this.vehicleId = "V" + totalVehicles;
        this.brand = b; this.model = m; this.rentPerDay = r;
    }

    public void rentVehicle(int days) {
        if (isAvailable) {
            isAvailable = false;
            double rent = days * rentPerDay;
            totalRevenue += rent;
            System.out.println(vehicleId + " rented for " + rent);
        }
    }

    public void returnVehicle() { isAvailable = true; }

    public void display() {
        System.out.println(vehicleId + " | " + brand + " | " + model + " | Rent: " + rentPerDay + " | " + (isAvailable ? "Available" : "Rented"));
    }

    public static void showStats() {
        System.out.println("Total Vehicles: " + totalVehicles + ", Total Revenue: " + totalRevenue);
    }
}

public class RentalSystem {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Toyota", "Corolla", 1000);
        Vehicle v2 = new Vehicle("Honda", "Civic", 1200);

        v1.rentVehicle(3);
        v2.rentVehicle(2);
        v1.display();
        v2.display();

        Vehicle.showStats();
    }
}
