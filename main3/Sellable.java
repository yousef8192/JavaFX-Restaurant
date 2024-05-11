

abstract class Sellable implements  Pricable {
	
	
	
	protected float price;
	public int quantity =0;
	
	public float getPrice() { return this.price; }
	
	public void changePrice(float newPrice) {
		this.price = newPrice;
	}

	
	public int getQuantity() {
		return this.quantity;
	}

   

	
	//---------------------------------------------------------//
	
        @Override
	public int compareTo(Pricable other) {
		   if( this.getPrice() > other.getPrice() )
			   return 1;
	       else if ( this.getPrice() == other.getPrice())
	    	   return 0;
	       return -1;
	}
	
	
}
