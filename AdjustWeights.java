public class AdjustWeights {
	private double adjustFactor;
	
	public AdjustWeights(double initFactor) {
		adjustFactor = initFactor;
	}
	
	public void learn(InputPerceptron[] inputPerceptrons, BiasPerceptron bias, double output, double desiredOutput) {
		for (InputPerceptron iP : inputPerceptrons) {
			iP.setWeight(adjustFactor*((desiredOutput-output)*iP.getSO()));
		}
		
			//System.out.println("DEBUG: WEIGHT ADJUST:" +(adjustFactor*(desiredOutput-output)*bias.getOutput()));
		bias.setWeight(adjustFactor*(desiredOutput-output)*bias.getSO());
	}
}