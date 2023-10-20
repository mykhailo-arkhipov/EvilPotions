package character;

import java.io.Serializable;

public class Character implements Serializable {
    private int level;
    private int faceMutation = 0; // [-2 -1 0 1 2] evil<->good

    public Character(int level, int faceMutation) {
        this.level = level;
        this.faceMutation = faceMutation;
    }
}
