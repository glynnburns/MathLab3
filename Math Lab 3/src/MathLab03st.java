// MathLab03st.java
// The Rational Class Program II
// This is the student, starting version of the MathLab03 assignment.
// There are 5 return methods in the Rational class that have temporary return statements
// which allow the program to compile.  Students will need to change these statements.


import javax.swing.JOptionPane;


public class MathLab03st 
{
	public static void main (String args[])
	{   
		String strNum1 = JOptionPane.showInputDialog("Enter Numerator 1"); 
		String strDen1 = JOptionPane.showInputDialog("Enter Denominator 1");
		String strNum2 = JOptionPane.showInputDialog("Enter Numerator 2"); 
		String strDen2 = JOptionPane.showInputDialog("Enter Denominator 2");
		
		int onum1 = Integer.parseInt(strNum1);
		int oden1 = Integer.parseInt(strDen1);
		int onum2 = Integer.parseInt(strNum2);
		int oden2 = Integer.parseInt(strDen2);

		Rational r1 = new Rational(onum1,oden1);
		Rational r2 = new Rational(onum2,oden2);
		Rational r3 = new Rational(onum1, oden1, onum2, oden2);
		
		r3.multiply(r1,r2);
		String mul = r1.getOriginal() + " * " + r2.getOriginal() + "  =  " + r3.getRational();
		r3.divide(r1,r2);
		String div = r1.getOriginal() + " / " + r2.getOriginal() + "  =  " + r3.getRational();		
		r3.add(r1,r2);
		String add = r1.getOriginal() + " + " + r2.getOriginal() + "  =  " + r3.getRational();
		r3.subtract(r1,r2);
		String sub = r1.getOriginal() + " - " + r2.getOriginal() + "  =  " + r3.getRational();
		
		String output = mul + "\n" + div + "\n" + add + "\n" + sub;
		
		JOptionPane.showMessageDialog(null,output);
          
		System.exit(0);
	}
}

		

class Rational
{
	
	private int firstNum;	// entered numerator
	private int firstDen;	// entered denominator
	private int num;		// reduced numerator
	private int den;		// reduceddenominator
	private int onum1;
	private int onum2;
	private int oden1;
	private int oden2;
	
	public Rational(int fn, int fd, int n, int d)
	{
		firstNum = onum1 = fn;
		firstDen = oden1 = fd;
		num = n;
		den = d;

	}

	public Rational(int n, int d)
	{
		firstNum = num = n;
		firstDen = den = d;
		reduce();

	}
	
	private int getGCF(int n1,int n2)
	{
		int rem = 0;
		int gcf = 0;
		do
		{
			rem = n1 % n2;
			if (rem == 0)
				gcf = n2;
			else
			{
				n1 = n2;
				n2 = rem;
			}
		}
		while (rem != 0);
		return gcf;
	}

	private void reduce()
	{
		num = firstNum/getGCF(firstNum, firstDen);
		den = firstDen/getGCF(firstNum, firstDen);
	}
	
	
	public double getDecimal()
	{
		return (double)num/den;
	}

	public String getRational() 
	{ 
		return firstNum+"/"+firstDen;
	}
	
	public String getOriginal()
	{
		return firstNum+"/"+firstDen+" reduces to ";
	}
	
	public int getNum()
	{
		return num;
		
	}

	public int getDen()
	{
		return den;
	
	}
	
	public void multiply(Rational r1, Rational r2)
	{
		firstNum = r1.getNum() * r2.getNum();
		firstDen = r1.getDen() * r2.getDen();
		reduce();
	}

	public void divide(Rational r1, Rational r2)
	{
		firstNum = r1.getNum() * r2.getDen();
		firstDen = r1.getDen() * r2.getNum();
		reduce();


	}
	
	public void add(Rational r1, Rational r2)
	{

		firstDen = r1.getDen() * r2.getDen();
		firstNum = r1.getNum() * r2.getDen() + r1.getDen() * r2.getNum();
		reduce();

	}
	
	public void subtract(Rational r1, Rational r2)
	{

		firstDen = r1.getDen() * r2.getDen();
		firstNum = r1.getNum() - r2.getNum();

	}
 
}



	







	

 


