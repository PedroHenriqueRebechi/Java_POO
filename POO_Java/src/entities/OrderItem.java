package entities;

public class OrderItem {
	private Integer quantity;
	
	private Product product;

	public OrderItem(Integer quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return product.getPrice();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Double subTotal() {
		return product.getPrice() * quantity;
	}
	
	public String toString() {
		return product.getName()
				+ ", $"
				+ product.getPrice()
				+ ", Quantity: "
				+ quantity
				+ ", Subtotal: $"
				+ subTotal();
	}

}
