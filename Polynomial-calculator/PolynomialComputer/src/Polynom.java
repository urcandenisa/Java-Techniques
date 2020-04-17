import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Polynom {
	private ArrayList <Monom> polynom;

	public Polynom()
	{
		polynom = new ArrayList<Monom>();
		
	}
	
	public ArrayList<Monom> getPolynom() {
		return polynom;
	}

	public void setPolynom(ArrayList<Monom> polynom) {
		this.polynom = polynom;
	}
	

	@Override
	public String toString() {
		String poly = "";
		int count = 0;
		/*Iterator<Monom>it= polynom.iterator();
		while(it.hasNext())
		{
			Monom m = it.next();
			count ++;
			if(m.getCoefficient() < 0)
				poly += m;
			else
				if(count == 1)
					poly += m;
				else
				    poly += "+" + m;
		}*/
		for(Monom m: polynom)
		{
			count ++;
			if(m.getCoefficient() <= 0)
			{
				poly += m;
			}
			else
				if(count == 1)
				{
					poly += m;
				}
				else
				{

					poly += "+" + m;
				}
		}
		return poly;
	}
	
	public void addMonom(Monom monom)
	{
		polynom.add(monom);
		Collections.sort(polynom);
	}
	
	public Polynom sum(Polynom secondPolynom)
	{ 
		Polynom result = new Polynom();
		boolean found = false;
		
		for(Monom m : polynom)
			result.addMonom(m);
		
		for(Monom m : secondPolynom.polynom)
		{
			found = false;
			for(Monom n : result.polynom)
			{
				if(n.getPower() == m.getPower())
				{
					n.sum(m);
					found = true;
				}
			}
			if(found == false)
			{
				result.addMonom(m);
			}	
		}
		return result;
	}
	
	public Polynom sub(Polynom secondPolynom)
	{
		Polynom result = new Polynom();
		boolean found = false;
		
		for(Monom m : polynom)
			result.addMonom(m);
		
		for(Monom m : secondPolynom.polynom)
		{
			found = false;
			for(Monom n : polynom)
			{
				if(m.getPower() == n.getPower())
				{
					n.sub(m);
					//n.reverse();
					found = true;
				}
			}
			if(found == false)
			{
				//m.reverse();
				result.addMonom(m);
			}
		}
		return result;
	}
	
	public Polynom multiply(Polynom secondPolynom)
	{
		Polynom result = new Polynom();
		
		for(Monom m : polynom)
		{
			for(Monom n : secondPolynom.polynom)
			{
				Monom aux = m.multiply(n);
				result.addMonom(aux);
			}
		}
		
		result = result.trim();
		return result;
	}
	
	public Polynom trim()
	{
		Polynom result = new Polynom();
		
		for( int i = 0; i < polynom.size() - 1 ; i++)
		{
			if(polynom.get(i).getPower() != polynom.get(i+1).getPower())
			{
				result.addMonom(polynom.get(i));
			}
			else
			{
				Monom m = polynom.get(i);
				Monom n = polynom.get(i+1);
				m.sum(n);
				i++;
				if(m.getCoefficient() != 0)
				result.addMonom(m);
			
			}
		}
		result.addMonom(polynom.get(polynom.size() - 1));
		return result;
	}
	
	public void deriv()
	{
		for(Monom m : polynom)
		{
			m.deriv();		
		}
	}
	
	public void remove()
	{
		if(polynom.size() == 1)
		{
			if(polynom.get(0).getCoefficient() == 0)
				polynom.remove(0);
		}
		else {
		if(polynom.isEmpty() == false )
			for(Monom m : polynom)
		if(m.getCoefficient() == 0)
			polynom.remove(m);
		}
	}
	
	public void integr()
	{
		for(Monom m: polynom)
		{
			m.integr();
		}
	}
	
	public int getGrad()
	{
		if(polynom.isEmpty() == false)
		{
			int i = 0;
			while(this.polynom.get(i).getCoefficient() == 0 && i < polynom.size() - 1)
				i++;
			return polynom.get(i).getPower();
		}
		else 
			return 0;
	}
	
	public void reverse()
	{
		for(Monom m : polynom)
			m.reverse();
	}
	
	public ArrayList<Polynom> divide(Polynom divider)
	{
		ArrayList<Polynom> finalResult = new ArrayList<Polynom>();
		
		Polynom mul;
		Polynom q = new Polynom();
		Polynom inte;
		Polynom dif = this;
		
		int j = 0;
		while(dif.getGrad() != 0 && dif.getGrad() >= q.getGrad() && j <= this.getGrad()) {
				inte = new Polynom();
				dif = this;
				Monom aux = dif.polynom.get(j).divide(divider.polynom.get(0));
				q.addMonom(aux);
				inte.addMonom(aux);
				mul = divider.multiply(inte);
				dif = this.sub(mul);
				dif.remove();
				j++;	
		}
		
		finalResult.add(q);
		finalResult.add(dif);

		return finalResult;
		
		
	}
	
	
	public static void main(String[] args)
	{
		Polynom p1 = new Polynom();
		p1.addMonom(new Monom(2,1));
		p1.addMonom(new Monom(2,2));
		p1.addMonom(new Monom(1,0));
		System.out.println(p1.toString());
		
		Polynom p2 = new Polynom();
		//p2.addMonom(new Monom(2,3));
		//p2.addMonom(new Monom(-2,2));
		p2.addMonom(new Monom(1,1));
		System.out.println(p2.toString());
		
		Polynom result = new Polynom();
		result = p2.sum(p1);
		System.out.println("SUMA : " + result.toString());
		
		Polynom subResult = new Polynom();
		subResult = p2.sub(p1);
		System.out.println("DIF : " + subResult.toString());
		
		System.out.println(p1);
		System.out.println(p2);
		Polynom mulResult = new Polynom();
		mulResult = p1.multiply(p2);
		System.out.println("MUL : " + mulResult);
		
		Polynom derivResult = new Polynom();
		System.out.println(p1);
		p1.deriv();
		System.out.println("DERIV : " + p1);
		System.out.println(p2);
		p2.integr();
		System.out.println("INTEGR : " + p2 + "+c");
		
		Polynom p3 = new Polynom();
		//p3.addMonom(new Monom(12,4));
		
		p3.addMonom(new Monom(-6,3));
		//p3.addMonom(new Monom(0,2));
		p3.addMonom(new Monom(2,1));
		//p3.addMonom(new Monom(7,0));
		
		Polynom p4 = new Polynom();
	//	p4.addMonom(new Monom(3,2));
		p4.addMonom(new Monom(2,1));
		////////////daca p4 are grad mai mare decat p3 nu
		ArrayList<Polynom>divideResult = p3.divide(p4);
		System.out.println("DIVIDE : " + divideResult.toString());
		
	}

}
