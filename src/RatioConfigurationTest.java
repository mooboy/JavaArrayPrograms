public class RatioConfigurationTest {

    private static RatioConfiguration rc = new RatioConfiguration();

    public void runRatioConfigTests() {
        TestAddRatioConfig();
        TestGetRatioByTimeOfMeal();
        TestRatioList();
        TestDeleteRatioConfig();
        TestEditRatioConfig();
    }

    public static void TestGetRatioByTimeOfMeal() {
        System.out.println("\n~~~TestGetRatioByTimeOfMeal~~~\n");
        RatioConfiguration ratio = rc.getRatioConfiguration(TimeOfMeal.Dinner);
        if(ratio != null) {
            System.out.println(ratio.toString());
        }
        else
        {
            System.out.println("No Ratio config is found for meal time (dinner)");
        }
    }

    public static void TestRatioList() {
        System.out.println("\n~~~TestRatioList~~~\n");
        for (RatioConfiguration r : rc.getAllRatioConfiguration()) {
            System.out.println(r.toString());
            System.out.println();
        }
    }

    public static void TestAddRatioConfig() {
        System.out.println("\n~~~TestAddRatioConfig~~~\n");
        System.out.println(
                rc.AddRatioConfig(120, 70, 10, TimeOfMeal.Breakfast));
        System.out.println(
                rc.AddRatioConfig(140, 70, 10, TimeOfMeal.Lunch));
        System.out.println
                (rc.AddRatioConfig(120, 70, 12, TimeOfMeal.Snack));
        System.out.println(
                rc.AddRatioConfig(120, 70, 8, TimeOfMeal.Dinner));
        System.out.println
                (rc.AddRatioConfig(120, 80, 8, TimeOfMeal.Dinner));
        System.out.println
                (rc.AddRatioConfig(120, 90, 8, TimeOfMeal.Dinner));
    }

    public static void TestDeleteRatioConfig(){
        System.out.println("\n~~~TestDeleteRatioConfig~~~\n");
        System.out.println(rc.deleteRatioConfiguration(TimeOfMeal.Dinner));
        System.out.println(rc.deleteRatioConfiguration(TimeOfMeal.Lunch));


        // Add it back
        System.out.println(
                rc.AddRatioConfig(140, 70, 10, TimeOfMeal.Lunch));
        System.out.println(
                rc.AddRatioConfig(120, 70, 8, TimeOfMeal.Dinner));
    }

    public static void TestEditRatioConfig(){
        System.out.println("\n~~~TestEditRatioConfig~~~\n");

        // Change Lunch and test
        System.out.println(rc.editRatioConfig(150,40,7,TimeOfMeal.Lunch));
        RatioConfiguration afterChange = rc.getRatioConfiguration(TimeOfMeal.Lunch);
        System.out.println("Changed values: \n" + afterChange.toString());

        // Remove the Lunch config
        System.out.println(rc.deleteRatioConfiguration(TimeOfMeal.Lunch));

        // Try edit Lunch, when it does not exists
        System.out.println(rc.editRatioConfig(150,40,7,TimeOfMeal.Lunch));

        // Add it back
        System.out.println(
                rc.AddRatioConfig(140, 70, 10, TimeOfMeal.Lunch));
    }
}
