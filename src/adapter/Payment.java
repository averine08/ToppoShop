package adapter;

public abstract class  Payment {
	private int price;
	private String type;
	private String code;
	public Payment(int price, String type, String code) {
		super();
		this.price = price;
		this.type = type;
		this.code = code;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public abstract void pay();


}
