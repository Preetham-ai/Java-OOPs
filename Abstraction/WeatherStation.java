interface WeatherSensor {
    double getTemperature();
    double getHumidity();
    default String getSensorType() {
        return "Generic Weather Sensor";
    }
}

class OutdoorSensor implements WeatherSensor {
    public double getTemperature() {
        return 72.5 + (Math.random() * 10 - 5); // Random variation
    }
    
    public double getHumidity() {
        return 45.8 + (Math.random() * 20 - 10); // Random variation
    }
    
    public String getSensorType() {
        return "Outdoor Weather Sensor";
    }
}

public class WeatherStation {
    public static void main(String[] args) {
        WeatherSensor sensor = new OutdoorSensor();
        
        System.out.println("Sensor Type: " + sensor.getSensorType());
        System.out.printf("Current Temperature: %.1f°F%n", sensor.getTemperature());
        System.out.printf("Current Humidity: %.1f%%%n", sensor.getHumidity());
    }
}
