package smarthome;

public class LightingSystem {
    private boolean lightsOn;
    private int brightness = 70;

    public void turnOnAll(int brightness) {
        validateBrightness(brightness);
        this.lightsOn = true;
        this.brightness = brightness;
        System.out.println("Lighting: all lights ON at " + brightness + "%");
    }

    public void turnOffAll() {
        lightsOn = false;
        System.out.println("Lighting: all lights OFF");
    }

    public void setBrightness(int brightness) {
        validateBrightness(brightness);
        this.brightness = brightness;
        System.out.println("Lighting: brightness set to " + brightness + "%");
    }

    public boolean areLightsOn() {
        return lightsOn;
    }

    public int getBrightness() {
        return brightness;
    }

    private void validateBrightness(int brightness) {
        if (brightness < 0 || brightness > 100) {
            throw new IllegalArgumentException(
                    "Brightness must be between 0 and 100"
            );
        }
    }
}