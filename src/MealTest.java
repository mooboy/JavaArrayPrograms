public class MealTest extends Meal {
    // Implement Add/Delete/Edit/Get/GetAll test methods

    private static Meal m = new Meal();


    public void runMealTests() {
        TestAddMeal();
        TestGetMeal();
        TestDeleteMeal();
        TestMealList();
        TestEditMeal();
    }

    public static void TestGetMeal() {
        System.out.println("\n~~~TestGetMeal~~~\n");
        boolean condition1 = false;
        boolean condition2 = false;

        String searchFor = "Cheese";
        m.addMeal(searchFor, 5,5,5);
        Meal plate = m.getMeal(searchFor);
        Meal plate2 = m.getMeal("MealThatShouldNotBeThere");

        if (plate != null) {
            condition1 = true;
        }
        if(plate2 == null){
            condition2 = true;
        }

        if(condition1 && condition2){
            System.out.println("PASS");
        }
        else {
            System.out.println("FAIL");
        }
    }

    public static void TestMealList() {
        System.out.println("\n~~~TestMealList~~~\n");

        if(m.getAllMeals().size() > 0) {
            System.out.println("PASS");
        }
        else {
            System.out.println("FAIL");
        }
    }

    public static void TestAddMeal() {
        System.out.println("\n~~~TestAddMeal~~~");
        String mealName = "TestMealForAddOp";
        boolean condition1 = false;
        boolean condition2 = false;

        int priorCount = m.getAllMeals().size();
        m.addMeal(mealName, 30, 50, 70);
        int afterCount = m.getAllMeals().size();

        if (priorCount == afterCount - 1) {
            condition1 = true;
        }


        String message = m.addMeal(mealName, 30, 50, 70);
        if (message.equalsIgnoreCase(mealName + " already exists")) {
            condition2 = true;
        }

        if (condition1 && condition2) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }

    public static void TestDeleteMeal() {
        System.out.println("\n~~~ Begin TestDeleteMeal ~~~");
        String mealName = "mealTotestDeleteOp";
        boolean condition1 = false;
        boolean condition2 = false;

        m.addMeal(mealName, 50, 12, 8);
        int countPriorDelete = m.getAllMeals().size();

        m.deleteMeal(mealName);
        int countAfterDelete = m.getAllMeals().size();

        if (countAfterDelete == countPriorDelete - 1) {
            condition1 = true;
        }

        String message = m.deleteMeal(mealName);
        if (message.equalsIgnoreCase(mealName + " was not found")) {
            condition2 = true;
        }

        if (condition1 && condition2) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }

    public static void TestEditMeal() { //objects are not receiving attributes
        System.out.println("\n~~~TestEditMeal~~~\n");

        String mealName = "Salad";

        boolean condition1 = false;
        boolean condition2 = false;
        boolean condition3 = false;

        m.addMeal(mealName, 10, 10, 10);
        String beforeEdit = m.getMeal(mealName).toString();
        m.editMeal(mealName, 5, 5, 5);
        String afterEdit = m.getMeal(mealName).toString();
        m.editMeal(mealName, 10, 10, 10);
        String after2Edit = m.getMeal(mealName).toString();

        if (beforeEdit.equals(after2Edit)) {
            condition1 = true;
        }

        if(beforeEdit.equals(after2Edit)) {
            condition2 = true;
        }

        mealName = "Rice";
        String message = m.editMeal(mealName, 4, 4, 4);
        if (message.equalsIgnoreCase(mealName + " was not found")) {
            condition3 = true;
        }

        if (condition1 && condition2 && condition3) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

    }
}