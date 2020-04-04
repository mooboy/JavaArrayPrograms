public class InsulinCalculatorTest {

    private static RatioConfiguration ratio = new RatioConfiguration();

    public static void TestCalculation() {
        System.out.println("\n~~~TestCalculation~~~\n");
        ratio.AddRatioConfig(120, 70, 10, TimeOfMeal.Breakfast);
        ratio.AddRatioConfig(140, 70, 12, TimeOfMeal.Lunch);

        double units = InsulinCalculator.InsulinCalculator(
                55,
                130,
                ratio.getRatioConfiguration(TimeOfMeal.Lunch));
        System.out.println(units);
    }
}
