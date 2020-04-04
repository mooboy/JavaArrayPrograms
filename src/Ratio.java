public class Ratio {
    int carbRatio;
    int correctionConstant;
    int correctionRatio;

    public Ratio(int carbRatio, int correctionConstant, int correctionRatio) {
        this.carbRatio = carbRatio;
        this.correctionConstant = correctionConstant;
        this.correctionRatio = correctionRatio;
    }

    public String toString()
    {
        return "Carb Ratio: " + this.carbRatio + ", " + "Correction Constant: " + this.correctionConstant + ", " + "Correction Ratio: " + this.correctionRatio;
    }
}

