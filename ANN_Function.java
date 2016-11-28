public class ANN_Function {
	public static void main(String[] args) {
		double[] weights = new double[3]; //saves the weights into an array, every index is another node
		double[] inputs = new double[3];  //saves the inputs into an array
		double output = 0; 				 //output of the output node
		double learningRate = 0.01;		//learning rate of the learning algorithm
		double goal = 0;				//goal is telling the supervised learning algorithm which output is correct
		double currentState = 0; 		//state of the output
		
		inputs[0] = 1; 
		for (int i = 0; i < weights.length; i++){
			weights[i] = Math.random()-1; //sets the weights to a random negative value
		}
		
		for (int iteration = 1; iteration <= 500; iteration++) {			
			inputs[1] = (Math.random()*1000)-(Math.random()*1000); //generates a random number between -1000 and +1000
			inputs[2] = (Math.random()*1000)-(Math.random()*1000); //inputs[2] is Y-Value, [1] is X-Value
			
			goal = calculateGoal(inputs); //calls the method which calculates the goal
				
			currentState = 0; 
			for (int i = 0; i < inputs.length; i++) {
				currentState += inputs[i]*weights[i]; //calculates the current state of the output neuron
			}
			
			output = 0; 
			if (currentState >= 0) //if threshold is reached, output will be set to 1
				output = 1;
			
			System.out.println("Input Node 1: " +inputs[1] +"\nInput Node 2: " +inputs[2]);
			System.out.println("Output: " +output);
			System.out.println("Weight Node 1: " +weights[1] +"\nWeight Node 2: " +weights[2] +"\nWeight Bias: " +weights[0] +"\n");
			System.out.println("Iterations: " +iteration);

			//the feed forward algorithm
			for (int i = 0; i < weights.length; i++) {
					weights[i] += learningRate*(goal-output)*inputs[i];
			}
		}	
	}
	
	//if the Y-value is above the line 2x+1, then the goal will be one, else it will be zero
	public static double calculateGoal(double[] inputs) {
		if (inputs[2] >= ((2*inputs[1])+1))
			return 1;
		else
			return 0;
	}
}