public class OutputPerceptron extends Perceptron {
	private double input;
	
	public OutputPerceptron() {
	}
	
	public void save(double sentInput) {
		input += sentInput;
	}
	
	public void reset() {
		input = 0;
	}
	
	public double activate() {
		if (input >= 0)
			return 1;
		else
			return 0;
	}
	
	public double getInput() {
		return input;
	}
}