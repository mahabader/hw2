
package logisticssystem;

interface Shippable {
    double calculateCost();
    void dispatch();
}

abstract class Shipment implements Shippable {
    protected String trackingNumber;
    protected double weightKg;

    public Shipment(String trackingNumber, double weightKg) {
        this.trackingNumber = trackingNumber;
        this.weightKg = weightKg;
    }

    public void printInfo() {
        System.out.println("Tracking Number: " + trackingNumber + " | Total Weight: " + weightKg + " kg");
    }

    public abstract double calculateCost();
    public abstract void dispatch();
}

class DroneShipment extends Shipment {
    private double batteryRangeKm;

    public DroneShipment(String trackingNumber, double weightKg, double batteryRangeKm) {
        super(trackingNumber, weightKg);
        this.batteryRangeKm = batteryRangeKm;
    }

    @Override
    public double calculateCost() {
        return weightKg * 5.0 + 15.0;
    }

    @Override
    public void dispatch() {
        System.out.println(" Drone taking off for express delivery with a battery range of " + batteryRangeKm + " km.");
    }
}

class AirCargo extends Shipment {
    private String airlineName;

    public AirCargo(String trackingNumber, double weightKg, String airlineName) {
        super(trackingNumber, weightKg);
        this.airlineName = airlineName;
    }

    @Override
    public double calculateCost() {
        return weightKg * 12.5 + 100.0;
    }

    @Override
    public void dispatch() {
        System.out.println("Loading cargo onto the commercial aircraft operated by " + airlineName + ".");
    }
}

class GroundTruck extends Shipment {
    private int truckCapacityTons;

    public GroundTruck(String trackingNumber, double weightKg, int truckCapacityTons) {
        super(trackingNumber, weightKg);
        this.truckCapacityTons = truckCapacityTons;
    }

    @Override
    public double calculateCost() {
        return weightKg * 2.0 + 30.0;
    }

    @Override
    public void dispatch() {
        System.out.println(" Ground transport truck departing with a max capacity of " + truckCapacityTons + " tons.");
    }
}

public class LogisticsSystem {
    public static void main(String[] args) {
        Shipment[] shipments = {
            new DroneShipment("DRN-9081", 2.5, 45.0),
            new AirCargo("AIR-4421", 120.0, "Qatar Cargo"),
            new GroundTruck("TRK-1102", 500.0, 15)
        };

        System.out.println("===  Smart Logistics & Shipping Management System ===");
        for (Shipment s : shipments) {
            System.out.println("--------------------------------------------------");
            s.printInfo();
            s.dispatch();
            System.out.println(" Calculated Shipping Cost: $" + s.calculateCost());
        }
        System.out.println("--------------------------------------------------");
    }
}