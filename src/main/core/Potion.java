public abstract class Potion {
    public Grade grade;
    public Effects[] effects;
    public double price;

    public Potion(Ingridient a, Ingridient b, Ingridient c) {
        this.effects = receiveEffects(a, b, c);
        price = effects[0].getEffectPrice() + effects[1].getEffectPrice() + effects[2].getEffectPrice();
        // randoming grade
        byte randomGradeValue = (byte) (Math.random()*100);
        if (randomGradeValue < 8){
            this.grade = Grade.Useless;
            price /= 8;
        }
        else if (randomGradeValue < 36){
            this.grade = Grade.Low;
            price /= 3;
        }
        else if (randomGradeValue < 61){
            this.grade = Grade.Middle;
            price /= 2;
        }
        else if (randomGradeValue < 78){
            this.grade = Grade.Good;
        }
        else if (randomGradeValue < 89){
            this.grade = Grade.Great;
            price *= 2;
        }
        else if (randomGradeValue < 96){
            this.grade = Grade.Fantastic;
            price *= 4;
        }
        else if (randomGradeValue < 99){
            this.grade = Grade.Legendary;
            price *= 11;
        }
        else{
            this.grade = Grade.Unique;
            price *= 47;
        }
    }

    protected abstract Effects[] receiveEffects(Ingridient a, Ingridient b, Ingridient c);
}
