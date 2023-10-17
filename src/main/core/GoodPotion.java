public class GoodPotion extends Potion{
    // переписать всё
    public GoodPotion(Ingridient a, Ingridient b, Ingridient c) {
        super(a, b, c);
    }

    protected Effects[] receiveEffects(Ingridient a, Ingridient b, Ingridient c) {
        return new Effects[0];
    }
}
