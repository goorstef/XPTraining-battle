package be.cegeka.battle;

import org.apache.commons.lang3.StringUtils;

public class Soldier {

    private String name;

    public Soldier(String name) {
        if (this.name == null && name != null && name != "" && StringUtils.isNotBlank(name)) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Soldier already has a name!");
        }

    }

    String getName() {
        return this.name;
    }
}
