import java.sql.Time;
import java.util.ArrayList;

public class RatioConfiguration {

    private int targetBG;
    private double correctionR;
    private double carbR;
    private TimeOfMeal tom;

    // Setup default configuration for testing getRatioConfig
    private ArrayList<RatioConfiguration> ratios = new ArrayList<RatioConfiguration>();

    // default constructor
    public RatioConfiguration() {

    }

    // Constructor to setup ration config by time of meal
    private RatioConfiguration(int targetBloodGlucose,
                               double correctionRatio,
                               double carbRatio,
                               TimeOfMeal mealTime) {
        this.targetBG = targetBloodGlucose;
        this.correctionR = correctionRatio;
        this.carbR = carbRatio;
        this.tom = mealTime;
    }

    public int getTargetBG() {
        return this.targetBG;
    }

    public double getCorrectionRatio() {
        return this.correctionR;
    }

    public double getCarbRatio() {
        return this.carbR;
    }

    public String AddRatioConfig(int targetBloodGlucose,
                               double correctionRatio,
                               double carbRatio,
                               TimeOfMeal mealTime) {

        RatioConfiguration r = getRatioConfiguration(mealTime);
        if(r == null){
            r = new RatioConfiguration(
                    targetBloodGlucose,
                    correctionRatio,
                    carbRatio,
                    mealTime);
            ratios.add(r);
            return "Ratio Config for " + mealTime + " has been added";
        }

        return "Ratio Config for " + mealTime + " already exists. Cannot add";
    }

    public String toString() {
        return "Carb Ratio: " + this.carbR + "\n"
                + "Correction Constant: " + this.correctionR + "\n"
                + "Target Blood Glucose: " + this.targetBG + "\n"
                + "Time of Meal: " + this.tom;
    }

    public RatioConfiguration getRatioConfiguration(TimeOfMeal timeOfMeal) {
        for (RatioConfiguration r : ratios) {
            if (r.tom == timeOfMeal) {
                return r;
            }
        }

        return null;
    }

    public ArrayList<RatioConfiguration> getAllRatioConfiguration() {
        return ratios;
    }

    public String deleteRatioConfiguration(TimeOfMeal mealTime) {
        RatioConfiguration r = getRatioConfiguration(mealTime);
        if(r == null){
            return "Ratio config for " + mealTime + " was not found. Cannot delete";
        }

        ratios.remove(r);
        return "Ratio config for " + mealTime + " is deleted";
    }

    public String editRatioConfig(int targetBloodGlucose,
                                  double correctionRatio,
                                  double carbRatio,
                                  TimeOfMeal mealTime){

        RatioConfiguration r = getRatioConfiguration(mealTime);
        if (r == null){
            return "Ratio config for " + mealTime + " was not found. Cannot edit";
        }

        r.targetBG = targetBloodGlucose;
        r.correctionR = correctionRatio;
        r.carbR = carbRatio;

        return "Ratio config changes for " + mealTime + " are saved";
    }
}



