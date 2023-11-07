import java.util.stream.DoubleStream;

public class BMI{
	private double weight;
	private double height;
	private double BMI;
	private int length;
	private double average;
	DoubleStream string1=DoubleStream.of(18.5,18.6,18.7, 18.9, 19.0, 19.1, 19.2, 19.3, 19.4, 19.5, 19.6, 19.7, 19.8, 19.9, 20.0, 20.1, 20.2, 20.3, 20.4, 20.5, 20.6, 20.7, 20.8, 20.9, 21.0, 21.1, 21.2, 21.3, 21.4, 21.5, 21.6, 21.7, 21.8, 21.9, 22.0, 22.1, 22.2, 22.3, 22.4, 22.5, 22.6, 22.7, 22.8, 22.9, 23.0, 23.1, 23.2, 23,3, 23.4, 23.5, 23.6, 23.7, 23.8, 23.9, 24.0, 24.1, 24.2, 24.3, 24.4, 24.5, 24.6, 24.7, 24.8, 24.9);
	
	public BMI() {
		weight=0;
		height=0;
		BMI=0;
		length=0;
		average=0;
		
		
	}
		
	public void getWeight(double amount) {
		weight=amount;
	}
	public void getHeight(double amount) {
		height=amount;
	}
	public void computeBMI() {
		BMI=((weight)/(Math.pow(height, 2))*703);
	}
	public void loadArray() {//group BMI
		
	}
	public void ArrayLength(int amount) {
		length=length+amount;
	}
	public void average(double amount) {
		average=amount/length;
		
	}
	public double printaverage() {
		return average;
	}
	public double printBMI() {
		return BMI;
	}
	public int printLength() {
	return length;	
	}
	public void healthStatus() {
		if (BMI <= 18.4){
			System.out.println("Underweight");
		}
		else if(BMI>=18.5 && BMI<=24.9) {
			System.out.println("Normal");
			}
		else if(BMI>=30.0) {
			System.out.println("Obese");
		}
		else if(BMI>=25.0 && BMI<=29.9) {
			System.out.println("Overweight");
		}
	}
	public void healthStatus2() {
		if (average <= 18.4){
			System.out.println("Underweight");
		}
		else if(average>=18.5 && average<=24.9) {
			System.out.println("Normal");
			}
		else if(average>=30.0) {
			System.out.println("Obese");
		}
		else if(average>=25.0 && average<=29.9) {
			System.out.println("Overweight");
		}
	}
	public void menu() {
		System.out.println("1.) Find individual BMI");
		System.out.println("2.) Find group BMI");
		System.out.println("3.) Exit");
	}
	public void menu2() {
		System.out.println("1.) 18.4 and under: underweight");
		System.out.println("2.) 18.5-24.9: normal");
		System.out.println("3.) 25.0-29.9: overweight");
		System.out.println("4.) 30.0+: obese");
	}
}
