package calculations;

public class DynamicsCalculation extends Calculation{
//  private final String[] VARIABLES = new String[]{"v", 
//    "d",
//    "t",
//    "v1",
//    "v2",
//    "a"};
//  public static final int VELOCITY = 0;
//  public static final int DISTANCE = 1;
//  public static final int TIME = 2;
//  public static final int INITIAL_VELOCITY = 3;
//  public static final int FINAL_VELOCITY = 4;
//  public static final int ACCELERATION = 5;
//  
//  private double[] variableValues = new double[VARIABLES.length];
//  private boolean[] variableFlag = new boolean[VARIABLES.length];
  
  public DynamicsCalculation() {
    super(Calculation.DYNAMICS);
  }
  
//  public Double getVariableValue (String variableName) {
//    for (int i=0;i<VARIABLES.length;i++) {
//      if (VARIABLES[i].equals(variableName)) {
//        if (variableFlag[i])
//          return variableValues[i];
//      }
//    }
//    return null;
//  }
  
//  public void setValue(String variable, double value) {
//    for (int i=0;i<VARIABLES.length;i++) {
//      if (variable.equals(VARIABLES[i])) {
//        variableValues[i] = value;
//        variableFlag[i] = true;
//      }
//    }
//  }
  
  public Double calculate (String variableName) {
    return null;
  }
  
  
  public static void main(String[]args) {
    KinematicsCalculation kC = new KinematicsCalculation();
    kC.setValue("d", -5);
    kC.setValue("v1", 20);
    kC.setValue("a", 2);
    System.out.println(kC.calculate("t"));
  }
}