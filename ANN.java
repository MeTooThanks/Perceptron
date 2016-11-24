public class ANN {
	public static void main(String[] args) {
		double[] weights = new double[3];
		double[] inputs = new double[3];
		double output = 0;
		double learningRate = 0.1;
		double goal = 0;
		
		inputs[0] = 1;
		
		for (int k  = 0; k < weights.length; k++){
			weights[k] = Math.random()-1;
		}
		
		for (int iteration = 1; iteration <= 500; iteration++) {
			if (Math.random() < 0.5)
				inputs[1] = 0;
			else
				inputs[1] = 1;
			
			
			if (Math.random() < 0.5)
				inputs[2] = 0;
			else
				inputs[2] = 1;
			
			if (inputs[1] == 0 && inputs[2] == 0)
				goal = 0;
			else
				goal = 1;
				
			
			double currentState = 0;
			for (int i = 0; i < inputs.length; i++) {
				currentState += inputs[i]*weights[i];
			}
			
			if (currentState >= 0)
				output = 1;
			else
				output = 0;
			
			System.out.println("Input Node 1: " +inputs[1] +"\nInput Node 2: " +inputs[2]);
			System.out.println("Output: " +output);
			System.out.println("Weight Node 1: " +weights[1] +"\nWeight Node 2: " +weights[2] +"\nWeight Bias: " +weights[0] +"\n");
			
			for (int i = 0; i < weights.length; i++)
			weights[i] += 0.1*(goal-output)*inputs[i];
		}
		
	}
}