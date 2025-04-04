)    interface SmartDevice {
    void turnOn();
    void turnOff();
    String getStatus();
}

class SmartLight implements SmartDevice {
    private boolean isOn = false;
    
    public void turnOn() {
        isOn = true;
        System.out.println("Light turned on");
    }
    
    public void turnOff() {
        isOn = false;
        System.out.println("Light turned off");
    }
    
    public String getStatus() {
        return "Light is " + (isOn ? "ON" : "OFF");
    }
}

class TestSmartHome {
    public static void main(String[] args) {
        SmartDevice light = new SmartLight();
        light.turnOn();
        System.out.println(light.getStatus());
    }
}
