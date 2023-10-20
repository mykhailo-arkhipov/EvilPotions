public class Effect {
    private final String effectName;
    private final double price;
    private final int ancestor1;
    private final int ancestor2;
    private final byte rank;
    public int getAncestor1() {
        return ancestor1;
    }
    public int getAncestor2() {
        return ancestor2;
    }
    public byte getRank() {
        return rank;
    }
    public String getEffectName(){
        return effectName;
    }
    public double getEffectPrice(){
        return price;
    }

    Effect(String effectName, int ancestor1, int ancestor2, double price, byte rank){
        this.effectName = effectName;
        this.price = price;
        this.ancestor1 = ancestor1;
        this.ancestor2 = ancestor2;
        this.rank = rank;
    }
}
