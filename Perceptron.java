public class Perceptron {
	public static void main(String[] args) {
		
		double[] inputs = new double[3];
		double[] outputs = new double[1];
		double[] weights = new double[inputs.length];
		double[] outputState = new double[outputs.length];
		double learningRate = 0.1;
				
		for (int i = 0; i < weights.length; i++) {
			weights[i] = Math.random()-Math.random();
		}
		inputs[inputs.length-1] = 1;
		
		for (int iterations = 1; iterations < 100; iterations++) {
			for (int inputGenerator = 0; inputGenerator < inputs.length-1; inputGenerator++) {
				inputs[inputGenerator] = (double) Math.floor(Math.random()+0.5);
			}
			
			double expectedOutput = expected(inputs);

			System.out.println("Weights InOne: " +weights[0]);
			System.out.println("Weights InTwo: " +weights[1]);
			System.out.println("Weights Bias: " +weights[2]);
			System.out.println("Input 1: " +inputs[0]);
			System.out.println("Input 2: " +inputs[1]);
			for (int outputIterator = 0; outputIterator < outputState.length; outputIterator++) {
				for (int inputIterator = 0; inputIterator < inputs.length; inputIterator++)
						outputState[outputIterator] += weights[inputIterator] * inputs[inputIterator];
				
				outputs[outputIterator] = activation(outputState[outputIterator]);
				outputState[outputIterator] = 0;
				
				for (int weightIterator = 0; weightIterator < weights.length; weightIterator++) 
					weights[weightIterator] += (double) (learningRate * (expectedOutput - outputs[outputIterator])* inputs[weightIterator]);
			
				
					
			}
			System.out.println("Output: " +outputs[0]);
			
		}
	}
	
	public static double expected(double[] inputs) {
		return (inputs[0] == 1 || inputs[1] == 1) ? 1 : 0;
	}
	
	public static double activation(double state) {
		if (state >= 0)
			return 1;
		else
			return 0;
	}
}
