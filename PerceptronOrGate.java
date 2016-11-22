import java.io.*;
public class PerceptronOrGate {
	public static void main(String[] args) {
		
		OutputPerceptron output = new OutputPerceptron();
		InputPerceptron input1 = new InputPerceptron(output, null);
		InputPerceptron input2 = new InputPerceptron(output, input1.getInputPerceptrons());
		InputPerceptron[] inputs = input2.getInputPerceptrons();
		BiasPerceptron bias = new BiasPerceptron(output);
		AdjustWeights weightAdjust = new AdjustWeights(0.001);
		
		double[] input1WeightDataSet = new double[20001];
		
		double[] input2WeightDataSet = new double[20001];
		
		double[] biasWeightDataSet = new double[20001];
		
		double result = 0;
		double activation = 0;
		for (int i = 0; i <= 20000; i++) {
			double chance = Math.random();
			if (chance < 0.25) {
				input1WeightDataSet[i] = input1.getWeight();
				input2WeightDataSet[i] = input2.getWeight();
				biasWeightDataSet[i] = bias.getWeight();
				input1.send(0);
				input2.send(0);
				bias.send();
				
				result = output.activate();
				activation = output.getInput();
				System.out.println("Iteration: " +i);
				System.out.println("Input Node 1: 0 \nInput Node 2: 0 \nOutput: " +result);
				System.out.println("Weight Node 1: " +input1.getWeight() +"\nWeight Node 2: " +input2.getWeight() +"\nWeight Bias: " +bias.getWeight() +"\n");
				weightAdjust.learn(inputs, bias, result, 0);
				
				output.reset();
			}
			else if (chance < 0.5 && chance >= 0.25) {
				input1WeightDataSet[i] = input1.getWeight();
				input2WeightDataSet[i] = input2.getWeight();
				biasWeightDataSet[i] = bias.getWeight();
				input1.send(0);
				input2.send(1);
				bias.send();
				
				result = output.activate();
				
				activation = output.getInput();
				System.out.println("Iteration: " +i);
				System.out.println("Input Node 1: 0 \nInput Node 2: 1 \nOutput: " +result);
				System.out.println("Weight Node 1: " +input1.getWeight() +"\nWeight Node 2: " +input2.getWeight() +"\nWeight Bias: " +bias.getWeight() +"\n");
				weightAdjust.learn(inputs, bias, result, 1);
				
				output.reset();
			}
			else if (chance < 0.75 && chance >= 0.5) {
				input1WeightDataSet[i] = input1.getWeight();
				input2WeightDataSet[i] = input2.getWeight();
				biasWeightDataSet[i] = bias.getWeight();
				input1.send(1);
				input2.send(0);
				bias.send();
				
				result = output.activate();
				
				activation = output.getInput();
				System.out.println("Iteration: " +i);
				System.out.println("Input Node 1: 1 \nInput Node 2: 0 \nOutput: " +result);
				System.out.println("Weight Node 1: " +input1.getWeight() +"\nWeight Node 2: " +input2.getWeight() +"\nWeight Bias: " +bias.getWeight() +"\n");
				weightAdjust.learn(inputs, bias, result, 1);
				
				output.reset();
			}
			else if (chance >= 0.75) {
				input1WeightDataSet[i] = input1.getWeight();
				input2WeightDataSet[i] = input2.getWeight();
				biasWeightDataSet[i] = bias.getWeight();
				input1.send(1);
				input2.send(1);
				bias.send();
				
				result = output.activate();
				
				activation = output.getInput();
				System.out.println("Iteration: " +i);
				System.out.println("Input Node 1: 1 \nInput Node 2: 1 \nOutput: " +result);
				System.out.println("Weight Node 1: " +input1.getWeight() +"\nWeight Node 2: " +input2.getWeight() +"\nWeight Bias: " +bias.getWeight() +"\n");
				weightAdjust.learn(inputs, bias, result, 1);
				
				output.reset();
			}
		}
		write("input1_weights.dat", input1WeightDataSet);
		write("input2_weights.dat", input2WeightDataSet);
		write("bias_weights.dat", biasWeightDataSet);
	}
	
	public static void write (String fileName, double[] x){
		try {
 		File file = new File(fileName);
	// if file doesnt exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		for (int i = 0; i < x.length; i++) {
			bw.write(String.valueOf(x[i]));
			bw.write(" ");
		}
		bw.flush();
		bw.close();

		System.out.println("Done writing " +fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}