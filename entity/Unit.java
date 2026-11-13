package entity;

public abstract class Unit {
    // stats
    Stat hp;
    Stat atk;
    Stat mag;
    Stat def;
    Stat res;
    Stat spd;
    Stat bld;

    // other unit info
    String name;
    String unitClass;
    Weapon[] inventory;
    int exp;
    int currentHP = hp.getValue();

    void attack(Unit enemy, Weapon weapon) {
        int dmg = 0;
        // physical
        if (weapon.getType() == 0) {
            dmg = enemy.getDef() - (atk.getValue() + weapon.getMight());
        }
        // magical
        else {
            dmg = enemy.getRes() - (mag.getValue() + weapon.getMight());
        }

        enemy.setCurrentHP(enemy.getCurrentHP() - dmg);
    }

    // some units may have support depending on class

    void gainExp(int earnedExp) {
        exp += earnedExp;
        if (exp >= 100) {
            levelUp();
            exp -= 100;
        }
    }

    void levelUp() {
        hp.calcStatGain();
        atk.calcStatGain();
        mag.calcStatGain();
        def.calcStatGain();
        res.calcStatGain();
        spd.calcStatGain();
    }

    // getters and setters -- this will be long
    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    // getters from the Stat instances
    public int getHp() {
        return hp.getValue();
    }

    public int getAtk() {
        return atk.getValue();
    }

    public int getMag() {
        return mag.getValue();
    }

    public int getDef() {
        return def.getValue();
    }

    public int getRes() {
        return res.getValue();
    }

    public int getSpd() {
        return spd.getValue();
    }

    public int getBld() {
        return bld.getValue();
    }

    @Override
    public String toString() {
        return unitClass + " " + name + ": {EXP:" + exp + " HP:" + currentHP + "/" + hp.getValue()
                + " INVENTORY:" + inventory
                + " STATS: [" + hp + " | " + atk + " | " + mag + " | " + def + " | " + res + " | " + spd + " | " + bld
                + "]";
    }
}
