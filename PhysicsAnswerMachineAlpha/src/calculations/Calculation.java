package calculations;

public class Calculation {
  private String[] variables;
  
  public static final int KINEMATICS = 0;
  public static final int DYNAMICS = 1;
  public static final int ENERGY = 2;
  public static final int MOMENTUM = 3;
  public static final int POWER = 4;
  public static final int ELECTRICTY = 5;
  public static final int MAGNETISM = 6;
  public static final int WAVES = 7;
  
  public Calculation(int calcType) {
    setCalculation(calcType);
  }
  
  public String[] getVariables() {
    return variables;
  }
  
  public void setCalculation(int calcType) {
    if (calcType==KINEMATICS)
      variables = new String[] {"v", "d", "t", "v1", "v2", "a"};
    else if (calcType==DYNAMICS)
      variables = new String[] {"Fnet", "m", "a", "Fg", "Ff", "Fn", "Fc",
      "g", "mew", "k", "x", "r", "v", 
        "T", "f"};
  }
}