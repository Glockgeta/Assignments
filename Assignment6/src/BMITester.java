import java.util.*;
public class BMITester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner (System.in);
		Scanner in2=new Scanner (System.in);
		double total=0;
		double average=0;
		BMI myBMI=new BMI();
		myBMI.menu2();
		System.out.println("         ");
		myBMI.menu();
		int selection=0;
		System.out.println("Please select an option:" );
		selection=in.nextInt();
		if (selection==3) {
			System.out.println("Thank you for participating");
			
			}
		else {
			
		
	
		while (selection!=3){
			if (selection==1) {
				System.out.println("Enter height:");
				double height=in.nextDouble();
				myBMI.getHeight(height);
				System.out.println("Enter weight:");
				double weight=in.nextDouble();
				myBMI.getWeight(weight);
				myBMI.computeBMI();
				System.out.println("Your BMI value is:" + myBMI.printBMI());
				myBMI.healthStatus();
				
				
			}
			
			else if(selection==2) {       
				System.out.println("Enter how many people to add to array: ");
				int a=in.nextInt();
				myBMI.ArrayLength(a);
				int max=myBMI.printLength();
				double [] GroupArray=new double[a];
					for (int i=0; i<max; i++) {       
						System.out.println("Enter height");
						double height=in.nextDouble();
						myBMI.getHeight(height);
						System.out.println("Enter weight");
						double weight=in.nextDouble();
						myBMI.getWeight(weight);
						myBMI.computeBMI();
						double x=myBMI.printBMI();
						GroupArray [i]=x;
						total=total+GroupArray[i];
						myBMI.average(total);
					}
					//	for(i=0; i==GroupArray.length; i++) {
				//	 total=total+GroupArray[i];
				//}
			
				
			System.out.println("Total:" + total);
			System.out.println("Average:"+ myBMI.printaverage());
			myBMI.healthStatus2();
			System.out.println(Arrays.toString(GroupArray));
			}
			
				
			myBMI.menu();
			System.out.println();
			myBMI.menu2();
			System.out.println("Please select an option");
			selection=in.nextInt();
		}
		System.out.println("Thank you for participating");
		
		
	}

}
}
