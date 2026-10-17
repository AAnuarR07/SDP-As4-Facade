package smarthome;

public class SecuritySystem {
    private boolean armed;

    public void arm() {
        armed = true;
        System.out.println("Security: intrusion monitoring ARMED");
    }

    public void disarm() {
        armed = false;
        System.out.println("Security: intrusion monitoring DISARMED");
    }

    public boolean isArmed() {
        return armed;
    }
}