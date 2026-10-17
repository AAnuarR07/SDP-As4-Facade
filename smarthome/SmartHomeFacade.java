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

        this.lighting = requireNonNull(lighting, "lighting");
        this.climate = requireNonNull(climate, "climate");
        this.security = requireNonNull(security, "security");
        this.locks = requireNonNull(locks, "locks");
        this.energy = requireNonNull(energy, "energy");
    }

    public void activateHomeMode() {
        runRoutine("Home mode", () -> {
            locks.unlockMainEntrance();
            security.disarm();
            energy.enableNormalMode();
            climate.startAt(22);
            lighting.turnOnAll(70);
        });
    }

    public void activateAwayMode() {
        runRoutine("Away mode", () -> {
            lighting.turnOffAll();
            climate.stop();
            energy.enableSavingMode();
            locks.lockAllEntrances();
            security.arm();
        });
    }

    public void activateNightMode() {
        runRoutine("Night mode", () -> {
            lighting.turnOffAll();
            climate.startAt(19);
            energy.enableSavingMode();
            locks.lockAllEntrances();
            security.arm();
        });
    }

    public void activateEnergySavingMode() {
        runRoutine("Energy-saving mode", () -> {
            lighting.setBrightness(30);
            climate.startAt(19);
            energy.enableSavingMode();
        });
    }

    private void runRoutine(String routineName, Runnable routine) {
        try {
            System.out.println("\n---" + routineName + "---");
            routine.run();
            System.out.println(routineName + " activated successfully");
        } catch (IllegalArgumentException exception) {
            throw new IllegalStateException(
                    "Could not activate " + routineName + ": "
                            + exception.getMessage(),
                    exception
            );
        }
    }

    private static <T> T requireNonNull(T value, String name) {
        if (value == null) {
            throw new IllegalArgumentException(
                    name + " subsystem must not be null"
            );
        }
        return value;
    }
}