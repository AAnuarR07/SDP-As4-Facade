package smarthome;

public class SmartHomeFacade {
    private final LightingSystem lighting;
    private final ClimateControlSystem climate;
    private final SecuritySystem security;
    private final SmartLockSystem locks;
    private final EnergyManagementSystem energy;

    public SmartHomeFacade(
            LightingSystem lighting,
            ClimateControlSystem climate,
            SecuritySystem security,
            SmartLockSystem locks,
            EnergyManagementSystem energy) {

        if (lighting == null) {
            throw new IllegalArgumentException("Lighting must not be null");
        }
        if (climate == null) {
            throw new IllegalArgumentException("Climate must not be null");
        }
        if (security == null) {
            throw new IllegalArgumentException("Security must not be null");
        }
        if (locks == null) {
            throw new IllegalArgumentException("Locks must not be null");
        }
        if (energy == null) {
            throw new IllegalArgumentException("Energy must not be null");
        }

        this.lighting = lighting;
        this.climate = climate;
        this.security = security;
        this.locks = locks;
        this.energy = energy;
    }

    public void activateHomeMode() {
        try {
            System.out.println("\n---Home mode---");

            locks.unlockMainEntrance();
            security.disarm();
            energy.enableNormalMode();
            climate.startAt(22);
            lighting.turnOnAll(70);

            System.out.println("Home mode activated successfully");
        } catch (IllegalArgumentException exception) {
            throw new IllegalStateException(
                    "Could not activate Home mode: "
                            + exception.getMessage()
            );
        }
    }

    public void activateAwayMode() {
        try {
            System.out.println("\n---Away mode---");

            lighting.turnOffAll();
            climate.stop();
            energy.enableSavingMode();
            locks.lockAllEntrances();
            security.arm();

            System.out.println("Away mode activated successfully");
        } catch (IllegalArgumentException exception) {
            throw new IllegalStateException(
                    "Could not activate Away mode: "
                            + exception.getMessage()
            );
        }
    }

    public void activateNightMode() {
        try {
            System.out.println("\n---Night mode---");

            lighting.turnOffAll();
            climate.startAt(19);
            energy.enableSavingMode();
            locks.lockAllEntrances();
            security.arm();

            System.out.println("Night mode activated successfully");
        } catch (IllegalArgumentException exception) {
            throw new IllegalStateException(
                    "Could not activate Night mode: "
                            + exception.getMessage()
            );
        }
    }

    public void activateEnergySavingMode() {
        try {
            System.out.println("\n---Energy-saving mode---");

            lighting.setBrightness(30);
            climate.startAt(19);
            energy.enableSavingMode();

            System.out.println("Energy-saving mode activated successfully");
        } catch (IllegalArgumentException exception) {
            throw new IllegalStateException(
                    "Could not activate Energy-saving mode: "
                            + exception.getMessage()
            );
        }
    }
}
