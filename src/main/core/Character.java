import java.io.Serializable;

public class Character implements Serializable {
    private int level; // 1 to 80
    private int faceMutation = 0; // [-2 -1 0 1 2] evil<->good
    private int coins;

    public Character(int level, int faceMutation) {
        if (level <= 80 && level >= 1) {
            this.level = level;
        }
        else this.level = 1;
        this.faceMutation = faceMutation;
        this.coins = 100;
    }
}
