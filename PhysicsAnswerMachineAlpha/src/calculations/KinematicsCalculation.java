package calculations;

public class KinematicsCalculation extends Calculation{
	private String[] variables;
	public static final int VELOCITY = 0;
	public static final int DISTANCE = 1;
	public static final int TIME = 2;
	public static final int INITIAL_VELOCITY = 3;
	public static final int FINAL_VELOCITY = 4;
	public static final int ACCELERATION = 5;

	private double[] variableValues = new double[variables.length];
	private boolean[] variableFlag = new boolean[variables.length];

	public KinematicsCalculation() {
		super(Calculation.KINEMATICS);
		this.variables = super.getVariables();
	}

	public Double getVariableValue (String variableName) {
		for (int i=0;i<variables.length;i++) {
			if (variables[i].equals(variableName)) {
				if (variableFlag[i])
					return variableValues[i];
			}
		}
		return null;
	}

	public Double getVelocity() {
		return getVariableValue("v");
	}

	public Double getDistance() {
		return getVariableValue("d");
	}

	public Double getTime() {
		return getVariableValue("t");
	}

	public Double getInitialVelocity(){
		return getVariableValue("v1");
	}

	public Double getFinalVelocity() {
		return getVariableValue("v2");
	}

	public Double getAcceleration() {
		return getVariableValue("a");
	}

	public void setValue(String variable, double value) {
		for (int i=0;i<variables.length;i++) {
			if (variable.equals(variables[i])) {
				variableValues[i] = value;
				variableFlag[i] = true;
			}
		}
	}

	public Double calculate (String variableName) {
		if (variableName.equals(variables[VELOCITY])) {
			return calcVelocity();
		} else if (variableName.equals(variables[DISTANCE])) {
			return calcDistance();
		} else if (variableName.equals(variables[TIME])) {
			return calcTime();
		} else if (variableName.equals(variables[INITIAL_VELOCITY])) {
			return calcInitialVelocity();
		} else if (variableName.equals(variables[FINAL_VELOCITY])) {
			return calcFinalVelocity();
		} else if (variableName.equals(variables[ACCELERATION])) {
			return calcAcceleration();
		}
		return null;
	}

	private Double calcVelocity() {
		if (variableFlag[DISTANCE]&&variableFlag[TIME]) {
			return variableValues[DISTANCE]/variableValues[TIME];
		} else if (variableFlag[INITIAL_VELOCITY]&&variableFlag[FINAL_VELOCITY]){
			return (variableValues[INITIAL_VELOCITY]+variableValues[FINAL_VELOCITY])/2;
		}
		return null;
	}

	private Double calcDistance() {
		try {
			return getVelocity()*getTime();
		} catch (NullPointerException e) {}
		try {
			return getFinalVelocity()*getTime()-0.5*getAcceleration()*Math.pow(getTime(), 2);
		} catch (NullPointerException e) {}
		try {
			return getInitialVelocity()*getTime()+0.5*getAcceleration()*Math.pow(getTime(), 2);
		} catch (NullPointerException e) {}
		try {
			return (Math.pow(getFinalVelocity(), 2)-Math.pow(getInitialVelocity(), 2))/(2*getAcceleration());
		} catch (NullPointerException e) {}
		return null;
	}

	private Double calcTime() {
		try {
			return getDistance()/getVelocity();
		} catch (NullPointerException e) {}
		try {
			return (getFinalVelocity()-getInitialVelocity())/getAcceleration();
		} catch (NullPointerException e) {}
		try {
			double x = (-getInitialVelocity()+
					Math.sqrt(Math.pow(getInitialVelocity(), 2)-4*0.5*getAcceleration()*getDistance()))/
					(2*0.5*getAcceleration());
			if (x<0) {
				return (-getInitialVelocity()-
						Math.sqrt(Math.pow(getInitialVelocity(), 2)-4*0.5*getAcceleration()*getDistance()))/
						(2*getAcceleration());
			} else {
				return x;
			}
		} catch (NullPointerException e) {}
		try {
			double x = (-getFinalVelocity()+
					Math.sqrt(Math.pow(getFinalVelocity(), 2)-4*0.5*getAcceleration()*getDistance()))/
					(2*0.5*getAcceleration());
			if (x<0) {
				return (-getFinalVelocity()-
						Math.sqrt(Math.pow(getFinalVelocity(), 2)-4*0.5*getAcceleration()*getDistance()))/
						(2*getAcceleration());
			} else {
				return x;
			}
		} catch (NullPointerException e) {}
		return null;
	}

	private Double calcInitialVelocity() {
		try {
			return getDistance()/getTime()-0.5*getAcceleration()*getTime();
		} catch (NullPointerException e) {}
		try {
			return getFinalVelocity()-getAcceleration()*getTime();
		} catch (NullPointerException e) {}
		try {
			return Math.sqrt(Math.pow(getFinalVelocity(), 2)-2*getAcceleration()*getDistance());
		} catch (NullPointerException e) {}
		try {
			return 2*getVelocity()-getFinalVelocity();
		} catch (NullPointerException e) {}
		return null;
	}

	private Double calcFinalVelocity() {
		try {
			return getDistance()/getTime()+0.5*getAcceleration()*getTime();
		} catch (NullPointerException e) {}
		try {
			return getInitialVelocity()-getAcceleration()*getTime();
		} catch (NullPointerException e) {}
		try {
			return Math.sqrt(Math.pow(getInitialVelocity(), 2)+2*getAcceleration()*getDistance());
		} catch (NullPointerException e) {}
		try {
			return 2*getVelocity()-getInitialVelocity();
		} catch (NullPointerException e) {}
		return null;
	}

	private Double calcAcceleration() {
		try {
			return (getFinalVelocity()-getInitialVelocity())/getTime();
		} catch (NullPointerException e) {}
		try {
			return 2*(getDistance()/getTime()-getInitialVelocity());
		} catch (NullPointerException e) {}
		try {
			return -2*(getDistance()/getTime()-getFinalVelocity());
		} catch (NullPointerException e) {}
		try {
			return Math.pow(getFinalVelocity(), 2)-Math.pow(getInitialVelocity(), 2)-(2*getDistance());
		} catch (NullPointerException e) {}
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