package smarthome;

public class Main {
    public static void main(String[] args) {
        SmartHomeFacade smartHome = new SmartHomeFacade(
                new LightingSystem(),
                new ClimateControlSystem(),
                new SecuritySystem(),
                new SmartLockSystem(),
                new EnergyManagementSystem()
        );

        smartHome.activateHomeMode();
        smartHome.activateNightMode();
        smartHome.activateAwayMode();
        smartHome.activateEnergySavingMode();
    }
}