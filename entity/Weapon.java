package entity;

public class Weapon {
    int might;
    int weight;
    int type; // 0 is phys, 1 is mag

    public int getType() {
        return type;
    }

    public int getMight() {
        return might;
    }

    public int getWeight() {
        return weight;
    }
}
