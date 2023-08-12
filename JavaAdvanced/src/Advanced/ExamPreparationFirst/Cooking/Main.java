package Advanced.ExamPreparationFirst.Cooking;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquids = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredients::push);

        Set<String> ingredientKeys = new HashSet<>();
        Collections.addAll(ingredientKeys, "Bread, Cake, Pastry, Fruit Pie".split(", "));

        Map<String, Integer> advancedMaterials = new TreeMap<>();

        ingredientKeys.forEach(ingredientKey -> advancedMaterials.put(ingredientKey, 0));

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int firstLiquid = liquids.poll();
            int lastIngredient = ingredients.pop();
            int sum = firstLiquid + lastIngredient;
            String cookedFood;

            switch (sum) {
                case 25:
                    cookedFood = "Bread";
                    break;
                case 50:
                    cookedFood = "Cake";
                    break;
                case 75:
                    cookedFood = "Pastry";
                    break;
                case 100:
                    cookedFood = "Fruit Pie";
                    break;
                default:
                    cookedFood = null;
                    break;
            }

            if (cookedFood == null) {
                ingredients.push(lastIngredient + 3);
            } else {
                advancedMaterials.put(cookedFood, advancedMaterials.get(cookedFood) + 1);
            }
        }

        boolean isAllFoodCooked = advancedMaterials.entrySet().stream().noneMatch(entry -> entry.getValue() == 0);

        String result = isAllFoodCooked
                ? "Wohoo! You succeeded in cooking all the food!"
                : "Ugh, what a pity! You didn't have enough materials to cook everything.";

        System.out.println(result);

        System.out.println("Liquids left: " + getRemainingIngredients(liquids));

        System.out.println("Ingredients left: " + getRemainingIngredients(ingredients));

        advancedMaterials.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }

    private static String getRemainingIngredients(ArrayDeque<Integer> ingredients) {
        return ingredients.isEmpty() ? "none" : ingredients.stream()
                .map(String::valueOf).collect(Collectors.joining(", "));
    }
}
