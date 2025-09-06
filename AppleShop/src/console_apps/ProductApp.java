package console_apps;

import java.util.Scanner;
import model.Product;

public class ProductApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		Product p = new Product();
		System.out.println(p);
		
		Product p2 = new Product("Ipad Pro 12.9", 1289.00);
		System.out.println(p2);
		
//		System.out.println("Enter a model:");
//		String model = scan.nextLine();
//		System.out.println("Enter origonal price:");
//		double op = scan.nextDouble();
//		
//		Product p3 = new Product(model, op);
//		
//		System.out.println(p3);
		
		scan.close();
	}

}
