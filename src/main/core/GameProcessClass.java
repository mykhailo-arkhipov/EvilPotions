import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GameProcessClass {

    public static final ArrayList<Effect> listOfEffects;
    public static final ArrayList<Ingredient> listOfIngredients;
    static {
        try {
            listOfEffects = getEffects();
            // for (Effect effect : listOfEffects){System.out.println(effect.getEffectName());}
            listOfIngredients = getIngredients();
            // for (Ingredient ingredient : listOfIngredients){System.out.println(ingredient.name);}
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Map of Ingredients wasn't initialized");
        }
    }
    /**
     * Takes a txt table with effects and initializing inner map
     * Effects in the file have this order:
     * NAME ANCESTOR1_ID ANCESTOR2_ID PRICE RANK. example: Willpower 2 3 4 2
     * @return ArrayList
     */

    private static ArrayList<Effect> getEffects() {
        ArrayList<Effect> effects = new ArrayList<>();
        effects.add(new Effect("defaultEffect", 0, 0, 0, (byte) 0));
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/data/effects_table.txt"))){
            while (bufferedReader.ready()){
                String[] oneLineEffect = bufferedReader.readLine().split(" ");
                effects.add(new Effect(oneLineEffect[0].replace("_", " "), Integer.parseInt(oneLineEffect[1]),
                        Integer.parseInt(oneLineEffect[2]), Double.parseDouble(oneLineEffect[3]),
                        Byte.parseByte(oneLineEffect[4])));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // НАПИСАТЬ
        return effects;
    }

    /**
     * Takes a txt table with ingredients and initializing inner map
     * Ingredients in the file have this order:
     * NAME EFFECT1 EFFECT2. example: Sunshade_Herb 7 15
     * @return ArrayList
     */
    private static ArrayList<Ingredient> getIngredients() throws FileNotFoundException {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/data/ingredients_table.txt"))){
            while (bufferedReader.ready()){
                String[] oneIngredientLine = bufferedReader.readLine().split(" ");
                Effect[] effects = {listOfEffects.get(Byte.parseByte(oneIngredientLine[1])),
                        listOfEffects.get(Byte.parseByte(oneIngredientLine[2]))};
                double price = (effects[0].getEffectPrice() + effects[1].getEffectPrice()) *
                        ((((double) effects[0].getRank()) + 0.5 + ((double) effects[0].getRank()))/2.0);
                ingredients.add(new Ingredient(oneIngredientLine[0].replace("_", " "), effects, price));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // НАПИСАТЬ
        return ingredients;
    }
    private void initArea(){
        // НАПИСАТЬ LIBGDX
    }

    public static void main(String[] args) {
        Character character = new Character(0, 0);
        int size = listOfIngredients.size();
        int a = ThreadLocalRandom.current().nextInt(size);
        int b = ThreadLocalRandom.current().nextInt(size);
        int c = ThreadLocalRandom.current().nextInt(size);
        Potion potion = new Potion(listOfIngredients.get(a), listOfIngredients.get(b),
                listOfIngredients.get(c));
        System.out.println(potion);
    }

}
