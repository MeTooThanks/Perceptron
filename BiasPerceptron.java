public class BiasPerceptron extends Perceptron {
	
	OutputPerceptron outputTarget = new OutputPerceptron();
	public BiasPerceptron(OutputPerceptron initOutputTarget) {
		super(false);
		outputTarget = initOutputTarget;
	}
	
	public void send() {
		setSO(1);
		outputTarget.save(getWeight());
	}
}