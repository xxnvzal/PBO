package Inherit;

public class Person {
	protected String name;
	protected String address;
	protected String hobi;
	
	
	public void identity()
	{
		System.out.println("Nama: "+name);
		System.out.println("Alamat: "+address);
		System.out.println("Hobi: "+hobi);
	}

	public String getHobi() {
		return this.hobi;
	}

}