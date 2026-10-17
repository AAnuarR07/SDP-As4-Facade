package smarthome;

public class EnergyManagementSystem {
    public enum EnergyMode {
        NORMAL, SAVING
    }

    private EnergyMode mode = EnergyMode.NORMAL;

    public void enableSavingMode() {
        mode = EnergyMode.SAVING;
        System.out.println("Energy: saving mode ENABLED");
    }

    public void enableNormalMode() {
        mode = EnergyMode.NORMAL;
        System.out.println("Energy: normal mode ENABLED");
    }

    public EnergyMode getMode() {
        return mode;
    }
}