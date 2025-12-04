package exercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

public class ExercicioShapes {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of shapes: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		List<Shape> shapes = new ArrayList<>();
		
		for (int i=0; i<n; i++) {
			System.out.println("Shape #"+ (i+1) + " data:");
			
			System.out.print("Rectangle or Circle (r/c)? ");
			char ch = sc.next().charAt(0);
			
			System.out.print("Color (BLACK/BLUE/RED): ");
			Color color = Color.valueOf(sc.nextLine());
			
			if (ch == 'r') {
				System.out.print("Width: ");
				double width = sc.nextDouble();
				
				System.out.print("Height: ");
				double height = sc.nextDouble();
				
				
				shapes.add(new Rectangle(color, width, height));
			} else {
				
				System.out.print("Radius: ");
				double radius = sc.nextDouble();
				
				shapes.add(new Circle(color, radius));

			}
		}
		
		
		System.out.println();
		System.out.println("Shape areas:");
		
		for (Shape shape : shapes) {
			System.out.println(shape.area());
		}
		
	}

}
