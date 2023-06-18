package com.cerberobeta.StoreWize.entities.carts;

public class ProductCartEntity {
	private int quantity;
	private int productId;

	public int getQuantity(){
		return quantity;
	}

	public int getProductId(){
		return productId;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
}
