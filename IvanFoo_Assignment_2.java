//Name: Ivan Foo
//Student number: 10228006
//Tutorial group: T07
//Declaration: This is my progamme
//
//filename: IvanFoo_Assignment_2.java

import java.util.ArrayList;
import java.util.Random;

enum ShapeColor
{
	Blue,
	Yellow,
	Red,
	Green,
	White,
	Brown,
	Orange
}

interface OnlyTwoD
{
	public double perimeter ();
	public void recolor (ShapeColor sc);
}

interface Shape
{
	public double area ();
}

interface OnlyThreeD
{
	public double volume ();
	public void resize (double percentage);
}

abstract class TwoD implements OnlyTwoD, Shape
{
	protected ShapeColor sc;
	protected int a, b, c, d;

	public TwoD ()
	{

	}

	// for circle
	public TwoD (ShapeColor sc, int a)
	{
		this.sc = sc;
		this.a = a;
	}

	// for rectangle
	public TwoD (ShapeColor sc, int a, int b)
	{
		this (sc, a);
		this.b = b;
	}

	// for triangle
	public TwoD (ShapeColor sc, int a, int b, int c)
	{
		this (sc, a, b);
		this.c = c;
	}

	// for trapezoid
	public TwoD (ShapeColor sc, int a, int b, int c, int d)
	{
		this (sc, a, b, c);
		this.d = d;
	}

	public TwoD (TwoD td)
	{
		this (td.sc, td.a, td.b, td.c, td.d);
	}

	public int getA ()
	{
		return a;
	}

	public int getB ()
	{
		return b;
	}

	public int getC ()
	{
		return c;
	}

	public int getD ()
	{
		return d;
	}

	public ShapeColor getShapeColor ()
	{
		return sc;
	}

	public void set (ShapeColor sc, int a)
	{
		this.sc = sc;
		this.a = a;
	}

	public void set (ShapeColor sc, int a, int b)
	{
		this.sc = sc;
		this.a = a;
		this.b = b;
	}

	public void set (ShapeColor sc, int a, int b, int c)
	{
		this.sc = sc;
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public void set (ShapeColor sc, int a, int b, int c, int d)
	{
		this.sc = sc;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	public void recolor (ShapeColor sc)
	{
		this.sc = sc;
	}

	public String toString ()
	{
		if (b == 0 && c == 0 && d == 0)
			return String.format("%s (2D (%s, %d))", getClass ().getName (), sc, a);
		else if (c == 0 && d == 0)
			return String.format("%s (2D (%s, %d, %d))", getClass ().getName (), sc, a, b);
		else if (d == 0)
			return String.format("%s (2D (%s, %d, %d, %d))", getClass ().getName (), sc, a, b, c);
		else
			return String.format("%s (2D (%s, %d, %d, %d, %d))", getClass ().getName (), sc, a, b, c, d);
	}
}

abstract class ThreeD implements OnlyThreeD, Shape
{
	protected ShapeColor sc;
	protected double a;

	public ThreeD ()
	{

	}

	public ThreeD (ShapeColor sc, double a)
	{
		this.sc = sc;
		this.a = a;
	}

	public ThreeD (ThreeD td)
	{
		this (td.sc, td.a);
	}

	public double getA ()
	{
		return a;
	}

	public void set (ShapeColor sc, double a)
	{
		this.sc = sc;
		this.a = a;
	}

	@Override
	public void resize (double percentage)
	{
		a = a - (a * (percentage / 100));
	}

	public String toString ()
	{
		return String.format ("%s (3D (%s, %.3f)", getClass ().getName (), sc, a);
	}
}

class Circle extends TwoD
{

	public Circle ()
	{

	}

	public Circle (ShapeColor sc, int radius)
	{
		super (sc, radius);
	}

	public Circle (Circle c)
	{
		this (c.sc, c.a);
	}

	@Override
	public double area ()
	{
		return Math.PI * a * a;
	}

	@Override
	public double perimeter ()
	{
		return Math.PI * (2 * a);
	}

	public int getRadius ()
	{
		return a;
	}

	public void set (ShapeColor sc, int radius)
	{
		this.sc = sc;
		this.a = radius;
	}

	@Override
	public String toString ()
	{
		return super.toString ();
		/*return String.format("Shape 1: %s%n" + "Area = %.2f%n" + "Updated color: %n" +
							 "I am a %s shape with color changed to %n", super.toString (), area (), getClass ().getName ());
		*/
	}
}

class Rectangle extends TwoD
{
	public Rectangle ()
	{

	}

	public Rectangle (ShapeColor sc, int length, int width)
	{
		super (sc, length, width);
	}

	public Rectangle (Rectangle r)
	{
		this (r.sc, r.a, r.b);
	}

	@Override
	public double area ()
	{
		return a * b;
	}

	@Override
	public double perimeter ()
	{
		return 2 * (a + b);
	}

	public int getLength ()
	{
		return a;
	}

	public int getWidth ()
	{
		return b;
	}

	public void set (ShapeColor sc, int length, int width)
	{
		this.sc = sc;
		this.a = length;
		this.b = width;
	}

	@Override
	public String toString ()
	{
		return super.toString ();
	}
}

class Triangle extends TwoD
{
	public Triangle ()
	{

	}

	public Triangle (ShapeColor sc, int a, int b, int c)
	{
		super (sc, a, b, c);
	}

	public Triangle (Triangle t)
	{
		this (t.sc, t.a, t.b, t.c);
	}

	@Override
	public double area ()
	{
		double halfPeri = perimeter () / 2.0;

		return Math.sqrt (halfPeri * (halfPeri - a) * (halfPeri - b) * (halfPeri - c));
	}

	@Override
	public double perimeter ()
	{
		return a + b + c;
	}

	public int getA ()
	{
		return a;
	}

	public int getB ()
	{
		return b;
	}

	public int getC ()
	{
		return c;
	}

	public void set (ShapeColor sc, int a, int b, int c)
	{
		this.sc = sc;
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public String toString ()
	{
		return super.toString ();
	}
}

class Trapezoid extends TwoD
{
	private int height;

	public Trapezoid ()
	{

	}

	public Trapezoid (ShapeColor sc, int a, int b, int c, int d, int height)
	{
		super (sc, a, b, c, d);
		this.height = height;
	}

	public Trapezoid (Trapezoid t)
	{
		this (t.sc, t.a, t.b, t.b, t.c, t.d);
		this.height = t.height;

	}

	@Override
	public double area ()
	{
		return ((a + b) / 2.0) * height;
	}

	@Override
	public double perimeter ()
	{
		return a + b + c + d;
	}

	public int getA ()
	{
		return a;
	}

	public int getB ()
	{
		return b;
	}

	public int getC ()
	{
		return c;
	}

	public int getD ()
	{
		return d;
	}

	public int getHeight ()
	{
		return height;
	}

	public void setShape (ShapeColor sc, int a, int b, int c, int d, int height)
	{
		this.sc = sc;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.height = height;
	}

	@Override
	public String toString ()
	{
		return super.toString ();
	}

}

class Cube extends ThreeD
{
	public Cube ()
	{

	}

	public Cube (ShapeColor sc, double a)
	{
		super (sc, a);
	}

	public Cube (Cube c)
	{
		this (c.sc, c.a);
	}

	@Override
	public double area ()
	{
		return 6 * (Math.pow (a, 2));
	}

	@Override
	public double volume ()
	{
		return Math.pow(a, 3);
	}

	public double getA ()
	{
		return a;
	}

	public void set (ShapeColor sc, double a)
	{
		this.sc = sc;
		this.a = a;
	}

	@Override
	public String toString ()
	{
		return super.toString ();
	}
}

class Tetrahedron extends ThreeD
{
	public Tetrahedron ()
	{

	}

	public Tetrahedron (ShapeColor sc, double a)
	{
		super (sc, a);
	}

	public Tetrahedron (Tetrahedron t)
	{
		this (t.sc, t.a);
	}

	@Override
	public double area ()
	{
		return Math.sqrt(3 * (Math.pow(a, 2)));
	}

	@Override
	public double volume ()
	{
		return (Math.pow(a, 3)) / (6 * (Math.sqrt(2)));
	}

	public double getA ()
	{
		return a;
	}

	public void set (ShapeColor sc, double a)
	{
		this.sc = sc;
		this.a = a;
	}

	@Override
	public String toString ()
	{
		return super.toString ();
	}
}

class Sphere extends ThreeD
{
	public Sphere ()
	{

	}

	public Sphere (ShapeColor sc, double a)
	{
		super (sc, a);
	}

	public Sphere (Sphere s)
	{
		this (s.sc, s.a);
	}

	public double area ()
	{
		return 4 * Math.PI * Math.pow(a, 2);
	}

	public double volume ()
	{
		return (4 / 3) * Math.PI * Math.pow(a, 3);
	}

	@Override
	public double getA ()
	{
		return a;
	}

	public void set (ShapeColor sc, double a)
	{
		this.sc = sc;
		this.a = a;
	}

	@Override
	public String toString ()
	{
		return super.toString ();
	}

}

public class IvanFoo_Assignment_2 {

	static Random rand = new Random ();

	private static int getInt ()
	{
		return rand.nextInt (10);
	}

	private static double getDouble ()
	{
		return rand.nextDouble () * 10;
	}

	private static ShapeColor getColor ()
	{
		Random rand = new Random();

		ShapeColor[] color = ShapeColor.values();
		int randIndex = rand.nextInt(color.length);

		return color[randIndex];
	}

	private static boolean isTriangle (int a, int b, int c)
	{
		return ((a + b > c)  && (a + c > b) && (b + c > a));
	}

	public static TwoD getTwoD ()
	{

		int choice = rand.nextInt (4);

		int t1 = getInt ();
		int t2 = getInt ();
		int t3 = getInt ();

		if (choice == 0)
		{
			Circle c0 = new Circle (getColor (), getInt ());
			return c0;
		}

		else if (choice == 1)
		{
			Rectangle r0 = new Rectangle (getColor (), getInt (), getInt ());
			return r0;
		}

		else if (choice == 2)
		{
			if (isTriangle (t1, t2, t3))
			{
				return new Triangle (getColor (), t1, t2, t3);
			}

			else
			{
				while (!isTriangle (t1, t2, t3))
				{
					t1 = getInt ();
					t2 = getInt ();
					t3 = getInt ();
				}

				Triangle t0 = new Triangle (getColor (), t1, t2, t3);
				return t0;
			}
		}

		else if (choice == 3)
		{
			Trapezoid trap0 = new Trapezoid (getColor (), getInt (), getInt (), getInt (), getInt (), getInt());
			return trap0;
		}

		return null;
	}

	private static ThreeD getThreeD ()
	{
		int choice = rand.nextInt (3);

		switch (choice)
		{
			case 0: Cube c0 = new Cube (getColor (), getDouble ());
					return c0;
			case 1: Tetrahedron t0 = new Tetrahedron (getColor (), getDouble ());
					return t0;
			default: Sphere s0 = new Sphere (getColor (), getDouble ());
					 return s0;
		}

	}

	private static void process2DShape (Shape ss)
	{
		TwoD twoD = (TwoD) ss;

		ShapeColor color = twoD.getShapeColor();
		ShapeColor recolor = getColor();

		while (color == recolor)
		{
			recolor = getColor();

			if (recolor != color)
			{

				twoD.recolor (recolor);
			}

			else
			{
				recolor = getColor ();
			}

		}

		if (color != recolor)
		{
			twoD.recolor (recolor);
		}
	}

	private static void displayList (ArrayList <Shape> alist)
	{
		int counter2d = 1;
		int counter3d = 1;

		for (Shape shape : alist)
		{
			if (shape instanceof TwoD)
			{
				TwoD twoD = (TwoD) shape;
				System.out.println();
				System.out.printf ("Shape %d: %s%n", counter2d, twoD);

				process2DShape (twoD);
				System.out.printf ("Updated color: %s%n", twoD.getShapeColor ());
				System.out.printf ("Area: %.2f%n", twoD.area ());
				System.out.printf ("Perimeter: %.2f%n", twoD.perimeter ());
				System.out.printf ("I am a %s shape with color changed to %s%n", twoD.getClass ().getName (), twoD.getShapeColor ());
				System.out.println (" ");
			}

			counter2d ++;

			if (shape instanceof ThreeD)
			{
				ThreeD threeD = (ThreeD) shape;

				System.out.println ();
				System.out.printf ("Shape %d: %s%n", counter3d, threeD);
				System.out.printf ("Surface area = %.2f%n", threeD.area ());
				System.out.printf ("Volume = %.2f%n", threeD.volume ());

				double reduce = getDouble ();
				threeD.resize (reduce);

				System.out.printf ("Size reduced by: %.2f%%%n%s%n", reduce, threeD);
				System.out.printf ("Updated surface area = %.2f%n", threeD.area ());
				System.out.printf ("Updated volume = %.2f%n", threeD.volume ());
				System.out.printf ("I am a %s shape %n", threeD.getClass ().getName ());
				System.out.println (" ");
			}

			counter3d ++;
			System.out.println ("----------------------------------------------------");
		}
	}


	public static void main (String[] args) 
	{
		ArrayList <Shape> alist = new ArrayList <Shape> ();

		int choice = rand.nextInt (3);

		while (choice != 0)
		{
			if (choice == 1)
			{
				TwoD twoD = getTwoD ();
				alist.add (twoD);
			}

			else if (choice == 2)
			{
				ThreeD threeD = getThreeD ();
				alist.add (threeD);
			}

			choice = rand.nextInt (4);
		}

		displayList (alist);
	}

}
