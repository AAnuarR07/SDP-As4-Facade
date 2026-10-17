package smarthome;

public class SmartLockSystem {
    private boolean locked = true;

    public void lockAllEntrances() {
        locked = true;
        System.out.println("Smart lock: all entrances LOCKED");
    }

    public void unlockMainEntrance() {
        locked = false;
        System.out.println("Smart lock: main entrance UNLOCKED");
    }

    public boolean areEntrancesLocked() {
        return locked;
    }
}