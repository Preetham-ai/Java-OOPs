public class Thermostat {
    private double currentTemp;
    private double targetTemp;
    private boolean isHeating;
    
    public Thermostat(double initialTemp) {
        this.currentTemp = initialTemp;
        this.targetTemp = initialTemp;
    }
    
    public void setTargetTemperature(double temp) {
        if(temp < 10 || temp > 35) {
            throw new IllegalArgumentException("Temperature must be between 10°C and 35°C");
        }
        this.targetTemp = temp;
        updateHeatingStatus();
    }
    
    private void updateHeatingStatus() {
        this.isHeating = currentTemp < targetTemp;
    }
    
    public void updateCurrentTemperature(double newTemp) {
        this.currentTemp = newTemp;
        updateHeatingStatus();
    }
    
    public String getStatus() {
        return String.format("Current: %.1f°C | Target: %.1f°C | Mode: %s", 
            currentTemp, targetTemp, isHeating ? "HEATING" : "IDLE");
    }

    public static void main(String[] args) {
        Thermostat nest = new Thermostat(20.0);
        System.out.println(nest.getStatus());
        
        nest.setTargetTemperature(22.5);
        nest.updateCurrentTemperature(21.0);
        System.out.println(nest.getStatus());
        
        nest.updateCurrentTemperature(23.0);
        System.out.println(nest.getStatus());
    }
}
