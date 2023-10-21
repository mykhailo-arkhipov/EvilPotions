import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Potion {
    public final Grade grade;
    public final Effect effect;
    public double price;
    public final String name;

    public Potion(Ingredient a, Ingredient b, Ingredient c) {

        this.price = (a.price + b.price + c.price) / 3d;

        ArrayList<Effect> localTempEffectsList = findDuplicatesAndSort(a, b, c);

        // calculating a grade from effects ranks
        switch (localTempEffectsList.size()) {
            case 1 -> {
                Effect effect1 = localTempEffectsList.get(0);
                this.grade = Grade.values()[effect1.getRank()];
                this.effect = effect1;
                this.name = effect1.getEffectName() + " potion";
            }
            case 2 -> {
                boolean randomBoolean = ThreadLocalRandom.current().nextBoolean();
                this.grade = randomBoolean ? Grade.values()[localTempEffectsList.get(0).getRank()] :
                        Grade.values()[localTempEffectsList.get(1).getRank()];
                this.effect = randomBoolean ? localTempEffectsList.get(0) : localTempEffectsList.get(1);
                this.name = randomBoolean ? localTempEffectsList.get(0).getEffectName() + " potion" :
                        localTempEffectsList.get(1).getEffectName() + " potion";
            }
            case 3 -> {
                double randomRankValue3 = ThreadLocalRandom.current().nextDouble(10);
                if (randomRankValue3 > 6.7) {
                    this.grade = Grade.values()[localTempEffectsList.get(0).getRank()];
                    this.effect = localTempEffectsList.get(0);
                    this.name = localTempEffectsList.get(0).getEffectName() + " potion";
                } else if (randomRankValue3 > 3.3) {
                    this.grade = Grade.values()[localTempEffectsList.get(1).getRank()];
                    this.effect = localTempEffectsList.get(1);
                    this.name = localTempEffectsList.get(1).getEffectName() + " potion";
                } else {
                    this.grade = Grade.values()[localTempEffectsList.get(2).getRank()];
                    this.effect = localTempEffectsList.get(2);
                    this.name = localTempEffectsList.get(2).getEffectName() + " potion";
                }
            }
            default -> {
                this.grade = Grade.USELESS;
                int randomNameValue = ThreadLocalRandom.current().nextInt(6);
                this.effect = GameProcessClass.listOfEffects.get(0);
                price /= 10;
                switch (randomNameValue){
                    case 1 -> this.name = "Heartburn remedy";
                    case 2 -> this.name = "Elixir of elongating ears";
                    case 3 -> this.name = "Nail growth potion";
                    case 4 -> this.name = "Forgetfulness remedy";
                    case 5 -> this.name = "Cockroach attraction potion";
                    default -> this.name = "Very suspicious beer";
                }
            }
        }
        price+= effect.getEffectPrice() * (Math.pow(this.grade.ordinal(),3) + 0.4);
        if (grade == Grade.UNIQUE) price *= 71;
    }

    @Override
    public String toString(){
        return String.format("%s: \n Grade is %s \n Price is %s \n",
                name, grade.name(), price);
    }

    private ArrayList<Effect> findDuplicatesAndSort(Ingredient a, Ingredient b, Ingredient c){
        ArrayList<Effect> possibleEffects = new ArrayList<>();
        ArrayList<Effect> resultEffects = new ArrayList<>();

        // adding effect to possible* list
        Collections.addAll(possibleEffects, a.effects);
        Collections.addAll(possibleEffects, b.effects);
        Collections.addAll(possibleEffects, c.effects);

        // sorting by rank
        possibleEffects.sort(new Comparator<Effect>() {
            @Override
            public int compare(Effect o1, Effect o2) {
                return o1.getRank() - o2.getRank();
            }
        });

        for (int i = 0; i < possibleEffects.size()-1; i++) {
            if (possibleEffects.get(i) == possibleEffects.get(i+1)){
                resultEffects.add(possibleEffects.get(i));

                // could be 3 same effects
                if (i < possibleEffects.size()-2 && possibleEffects.get(i) == possibleEffects.get(i+2)){
                    i +=2;
                }
                else i+=1;
            }
        }

        return resultEffects;
    }


}
