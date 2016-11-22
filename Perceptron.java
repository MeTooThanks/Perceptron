public class Perceptron {
	private double weight;
	
	private double output;
	private double secondOutput;
	
	public Perceptron(boolean input) {
 		if (input)
			weight = Math.random()-1;
 		else
			weight = Math.random()*(-1);
	}
	
	public Perceptron() {
	}
	
	public void setWeight(double changeWeight) {
		weight += changeWeight;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setOutput(double targetInput) {
		secondOutput = targetInput;
		output = targetInput * weight;
	}
	
	public double getOutput() {
		return output;
	}
	
	public void setSO(double tI) {
		secondOutput = tI;
	}
	
	public double getSO() {
		return secondOutput;
	}
	
}