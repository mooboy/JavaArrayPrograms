import javax.management.modelmbean.InvalidTargetObjectTypeException;
import java.io.InvalidObjectException;

public class InsulinCalculator {

    public static double InsulinCalculator(
            int currentBG,
            Meal meal,
            RatioConfiguration ratioConfig) {

        int carbInput = meal.getCarbInput();
        return InsulinCalculator(carbInput, currentBG, ratioConfig);
    }

   public static double InsulinCalculator(
           int carbInput,
           int currentBG,
           RatioConfiguration ratioConfig){

       if(carbInput <= 0 && carbInput > 1000) {
           throw new IllegalArgumentException("Carb input should be between (1-1000)");
       }

       if(currentBG <= 0 && currentBG > 1000) {
           throw new IllegalArgumentException("Current blood glucose should be between (1-1000)");
       }

       if(ratioConfig == null) {
           throw new IllegalArgumentException("Ratio configuration is not valid");
       }

       if(ratioConfig == null) {
            throw new IllegalArgumentException("Ratio configuration is not valid");
        }

       double units = ((currentBG - ratioConfig.getTargetBG())/ratioConfig.getCorrectionRatio())
               + (carbInput/ratioConfig.getCarbRatio());

       return units;
    }
}
