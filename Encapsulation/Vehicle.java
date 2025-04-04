public class Vehicle {
    private String licensePlate;
    private double speed;
    private boolean isMoving;
    private Location currentLocation;
    
    private static class Location {
        double latitude;
        double longitude;
        
        Location(double lat, double lon) {
            this.latitude = lat;
            this.longitude = lon;
        }
    }
    
    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
        this.speed = 0;
        this.isMoving = false;
        this.currentLocation = new Location(0, 0);
    }
    
    public void updateLocation(double lat, double lon) {
        this.currentLocation = new Location(lat, lon);
    }
    
    public void accelerate(double acceleration) {
        if(acceleration < 0) throw new IllegalArgumentException("Negative acceleration not allowed");
        this.speed += acceleration;
        this.isMoving = speed > 0;
    }
    
    public void brake(double deceleration) {
        if(deceleration < 0) throw new IllegalArgumentException("Negative deceleration not allowed");
        this.speed = Math.max(0, speed - deceleration);
        this.isMoving = speed > 0;
    }
    
    public String getStatus() {
        return String.format("%s - Speed: %.1f km/h - %s at (%.4f, %.4f)",
            licensePlate, speed, isMoving ? "Moving" : "Stopped",
            currentLocation.latitude, currentLocation.longitude);
    }

    public static void main(String[] args) {
        Vehicle car = new Vehicle("ABC123");
        car.updateLocation(40.7128, -74.0060); // New York coordinates
        
        System.out.println("Initial status: " + car.getStatus());
        
        car.accelerate(50.0);
        car.updateLocation(40.7135, -74.0065);
        System.out.println("After acceleration: " + car.getStatus());
        
        car.brake(30.0);
        System.out.println("After braking: " + car.getStatus());
        
        car.brake(30.0);
        System.out.println("After full stop: " + car.getStatus());
    }
}
