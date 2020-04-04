import java.lang.reflect.MalformedParametersException;
import java.util.ArrayList;

public class Meal {
    // Implement Add/Delete/Edit/Get/

    private String nameOfMeal;
    private int carbCount;
    private int sugarCount;
    private int fatCount;

    private ArrayList<Meal> mealList = new ArrayList<Meal>();

    public Meal () {

    }

    private Meal(String mealName, int carbContent, int sugarContent, int fatContent){
        this.nameOfMeal = mealName;
        this.carbCount = carbContent;
        this.sugarCount = sugarContent;
        this.fatCount = fatContent;
    }

    public String addMeal(String mealName, int carbContent, int sugarContent, int fatContent) {
        Meal m = getMeal(mealName);
        if (m == null) {
            m = new Meal(mealName, carbContent, sugarContent, fatContent);
            mealList.add(m);
            return mealName + " has been added";
        }
        return mealName + " already exists";
    }

    public String toString () {
        return "~~~~~" + this.nameOfMeal + "~~~~~\n" +
                "Sugar: " + this.sugarCount + " grams\n" +
                "Fat: " + this.fatCount + " grams\n" +
                "Carb: " + this.carbCount + " grams\n";
    }

    public Meal getMeal(String mealName) {
        for (Meal m : mealList) {
            if(m.nameOfMeal.equalsIgnoreCase(mealName)){
                return m;
            }
        }
        return null;
    }

    public ArrayList<Meal> getAllMeals () {
        return mealList;
    }

    public String deleteMeal(String mealName) {
        Meal m = getMeal(mealName) ;
        if (m == null) {
                return mealName + " was not found";
        }

        mealList.remove(m);
        return mealName + " was deleted";
    }

        public String editMeal(String mealName, int carbContent, int sugarContent, int fatContent){
            Meal m = getMeal(mealName);
            if (m == null){
                return mealName + " was not found";
            }
            m.sugarCount = sugarContent;
            m.fatCount = fatContent;
            m.carbCount = carbContent;

            return mealName + "\'s changes are saved";
            }

    public int getCarbInput() {
        return this.carbCount;
    }
}
