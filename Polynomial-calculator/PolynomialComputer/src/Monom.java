
public class Monom implements Comparable {

	private int coefficient;
	private int power;

	public Monom() {
		this.coefficient = 0;
		this.power = 0;
	}

	public Monom(int coefficient, int power) {
		this.coefficient = coefficient;
		this.power = power;
	}

	public int getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	@Override
	public String toString() {

		String mono = "";
		if (this.coefficient == 0) {
			mono += "";
		} else if (this.coefficient == 1) {
			if (this.power == 0) {
				mono += this.coefficient;
			} else {
				if (this.power == 1)
					mono += "x";
				else
					mono += "x^" + power;
			}
		} else {
			if (this.coefficient == -1) {
				if (this.power == 0) {
					mono += this.coefficient;
				} else {
					if (this.power == 1)
						mono += "-x";
					else
						mono += "x^" + power;
				}
			} else if (this.power == 0) {
				mono += this.coefficient;
			} else { 
				//this.power==0?
				if (this.power == 1)
					mono += this.coefficient + "x";
				else
					mono += this.coefficient + "x^" + power;
			}
		}

		return mono;
	}

	//// fa le te tip Monnom ca sa nu modific polinomul initial !!!!
	public void sum(Monom secondMonom) {
		this.coefficient = this.coefficient + secondMonom.coefficient;
	}

	public void sub(Monom secondMonom) {
		this.coefficient = this.coefficient - secondMonom.coefficient;
	}

	public void reverse() {
		this.coefficient = -this.coefficient;
	}

	public Monom multiply(Monom m) {
		return new Monom(this.coefficient * m.coefficient, this.power + m.power);
	}

	public void deriv() {
		this.coefficient = this.coefficient * this.power;
		this.power = this.power - 1;
	}

	public void integr() {
		if (this.power + 1 != 0)
			this.coefficient = this.coefficient / (this.power + 1); // aici daca coef intregi si vine fractie nu mere
		this.power += 1;
	}

	public Monom divide(Monom divider) {
		Monom m = new Monom(0, 0);
		if (divider.coefficient != 0) ///////// else exceptie
			m.coefficient = this.coefficient / divider.coefficient;
		m.power = this.power - divider.power;
		return m;

	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		if (this.power < ((Monom) arg0).power)
			return 1;
		else if (this.power > ((Monom) arg0).power)
			return -1;
		return 0;
	}

}
