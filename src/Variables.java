public class Variables extends Ratio{
    public int bloodGlucose;
    public int carbAmount;

    public Variables (int carbRatio, int correctionConstant, int correctionRatio, int bloodGlucose, int carbAmount){
        super(carbRatio,correctionConstant,correctionRatio);
        this.bloodGlucose = bloodGlucose;
        this.carbAmount = carbAmount;
    }

    public String toString() { return super.toString() + ", Blood Glucose: " + this.bloodGlucose + ", Carb Amount: " + this.carbAmount; }

    }
