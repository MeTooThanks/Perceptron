public class InputPerceptron extends Perceptron {
	private InputPerceptron[] inputPerceptrons = new InputPerceptron[1];
	
	OutputPerceptron outputTarget = new OutputPerceptron();
	
	public InputPerceptron(OutputPerceptron initOutputTarget, InputPerceptron[] initInputPerceptrons) {
		super(true);
		outputTarget = initOutputTarget;
		inputPerceptrons = initInputPerceptrons;
 		saveInArray(); 
	}
	
	public void saveInArray() {
		if (inputPerceptrons == null) {
			InputPerceptron[] tempInputPerceptrons = new InputPerceptron[1];
			tempInputPerceptrons[0] = this;
			inputPerceptrons = tempInputPerceptrons;
		} else {
			InputPerceptron[] tempInputPerceptrons = new InputPerceptron[inputPerceptrons.length+1];
			for (int i = 0; i < inputPerceptrons.length; i++) {
				tempInputPerceptrons[i] = inputPerceptrons[i];
			}
			tempInputPerceptrons[inputPerceptrons.length] = this;
			inputPerceptrons = tempInputPerceptrons;
		}
	}
	
	public void send(double input) {
		setOutput(input);
		outputTarget.save(getOutput());
	}
	
	public InputPerceptron[] getInputPerceptrons() {
		return inputPerceptrons;
	}
}