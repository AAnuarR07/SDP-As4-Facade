package smarthome;

public class ClimateControlSystem {
    private boolean running;
    private int targetTemperature = 22;

    public void startAt(int temperature) {
        validateTemperature(temperature);
        running = true;
        targetTemperature = temperature;
        System.out.println(
                "Climate: system ON, target temperature " + temperature + "°C"
        );
    }

    public void stop() {
        running = false;
        System.out.println("Climate: system OFF");
    }

    public boolean isRunning() {
        return running;
    }

    public int getTargetTemperature() {
        return targetTemperature;
    }

    private void validateTemperature(int temperature) {
        if (temperature < 16 || temperature > 30) {
            throw new IllegalArgumentException(
                    "Target temperature must be between 16 and 30°C"
            );
        }
    }
}