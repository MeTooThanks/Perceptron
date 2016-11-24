public class ANN {
	public static void main(String[] args) {
		double[] weights = new double[3]; //saves the weights into an array, every index is another node
		double[] inputs = new double[3];  //saves the inputs into an array
		double output = 0; 				 //output of the output node
		double learningRate = 0.1;		//learning rate of the learning algorithm
		double goal = 0;				//goal is telling the supervised learning algorithm which output is correct
		
		inputs[0] = 1; //index 0 is the bias node, input there is always 1
		for (double weight : weights){
			weight = Math.random()-1; //sets the weights to a random negative value
		}
		
		//Does 500 iterations of the learning (overkill for the OR-Gate since the weights converge quite quickly)
		for (int iteration = 1; iteration <= 500; iteration++) {
			//creates a random number between 0.5 and 1.5, then get's rid of the stuff after the decimal point
			inputs[1] = Math.floor(Math.random()+0.5); 
			inputs[2] = Math.floor(Math.random()+0.5);
			
			goal = 1; //sets the goal to one, changes it if both inputs are 0 to 0 (OR-Gate)
			if (inputs[1] == 0 && inputs[2] == 0)
				goal = 0;
				
			double currentState = 0; //calculates the potential of the output
			for (int i = 0; i < inputs.length; i++) {
				currentState += inputs[i]*weights[i];
			}
			
			output = 0; //sets the output to 0, changes it to 1 if the threshold of 0 is reached
			if (currentState >= 0)
				output = 1;
			
			//Command-line output of the input values, the output value, and the weights
			System.out.println("Input Node 1: " +inputs[1] +"\nInput Node 2: " +inputs[2]);
			System.out.println("Output: " +output);
			System.out.println("Weight Node 1: " +weights[1] +"\nWeight Node 2: " +weights[2] +"\nWeight Bias: " +weights[0] +"\n");
			
			//the learning algorithm
			for (int i = 0; i < weights.length; i++)
			weights[i] += learningRate*(goal-output)*inputs[i];
		}	
	}
}