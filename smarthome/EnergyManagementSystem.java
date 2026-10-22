package smarthome;

public class EnergyManagementSystem {

    private boolean savingMode = false;

    public void enableSavingMode() {
        savingMode = true;
        System.out.println("Energy: saving mode ENABLED");
    }

    public void enableNormalMode() {
        savingMode = false;
        System.out.println("Energy: normal mode ENABLED");
    }

    public boolean isSavingMode() {
        return savingMode;
    }
}
