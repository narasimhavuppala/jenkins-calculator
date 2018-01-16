
public class Calculator {

	int a;
	int b;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	int add() {

		return (this.a + this.b);
	}

	int subtract() {

		return (this.a - this.b);
	}

	int division() {

		return (this.a / this.b);
	}

}
