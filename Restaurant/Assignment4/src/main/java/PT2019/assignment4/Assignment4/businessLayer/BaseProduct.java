package PT2019.assignment4.Assignment4.businessLayer;

public class BaseProduct extends MenuItem{
	
	public BaseProduct(String name, int price, int weight) {
		super(name, price, weight);
	}
	@Override
	public int computePrice() {
		// TODO Auto-generated method stub
		return this.getPrice()*this.getWeight();
	}
	@Override
	public String getComposite() {
		// TODO Auto-generated method stub
		return "-";
	}
	@Override
	public void setComposite(String composite) {
		// TODO Auto-generated method stub
		
	}
	
}
