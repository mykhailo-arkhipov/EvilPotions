import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

public class Potion {
    public final Grade grade;
    public final Effect effect;
    public final double price;
    public final String name;

    public Potion(Ingredient a, Ingredient b, Ingredient c) {

        this.price = (a.price + b.price + c.price) / 3d;
        ArrayList<Effect> localTempEffectsList = new ArrayList<>(){
            {
                Collections.addAll(this, a.effects);
                Collections.addAll(this, a.effects);
                Collections.addAll(this, a.effects);
            }};
        // searching distinct effects, sorting by rank
        localTempEffectsList = (ArrayList<Effect>) localTempEffectsList.stream().distinct().sorted(new Comparator<Effect>() {
            @Override
            public int compare(Effect o1, Effect o2) {
                return o1.getRank() - o2.getRank();
            }
        }).toList();

        // calculating a grade from effects ranks
        switch (localTempEffectsList.size()) {
            case 1 -> {
                Effect effect1 = localTempEffectsList.get(0);
                this.grade = Grade.values()[effect1.getRank()];
                this.effect = effect1;
                this.name = "Potion of " + effect1.getEffectName();
            }
            case 2 -> {
                boolean randomBoolean = ThreadLocalRandom.current().nextBoolean();
                this.grade = randomBoolean ? Grade.values()[localTempEffectsList.get(0).getRank()] :
                        Grade.values()[localTempEffectsList.get(1).getRank()];
                this.effect = randomBoolean ? localTempEffectsList.get(0) : localTempEffectsList.get(1);
                this.name = randomBoolean ? "Potion of " + localTempEffectsList.get(0).getEffectName() :
                        "Potion of " + localTempEffectsList.get(1).getEffectName();
            }
            case 3 -> {
                double randomRankValue3 = ThreadLocalRandom.current().nextDouble(10);
                if (randomRankValue3 > 6.7) {
                    this.grade = Grade.values()[localTempEffectsList.get(0).getRank()];
                    this.effect = localTempEffectsList.get(0);
                    this.name = "Potion of " + localTempEffectsList.get(0).getEffectName();
                } else if (randomRankValue3 > 3.3) {
                    this.grade = Grade.values()[localTempEffectsList.get(1).getRank()];
                    this.effect = localTempEffectsList.get(1);
                    this.name = "Potion of " + localTempEffectsList.get(1).getEffectName();
                } else {
                    this.grade = Grade.values()[localTempEffectsList.get(2).getRank()];
                    this.effect = localTempEffectsList.get(2);
                    this.name = "Potion of " + localTempEffectsList.get(2).getEffectName();
                }
            }
            default -> {
                this.grade = Grade.Useless;
                int randomNameValue = ThreadLocalRandom.current().nextInt(6);
                this.effect = GameProcessClass.listOfEffects.get(0);
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

    }
}
