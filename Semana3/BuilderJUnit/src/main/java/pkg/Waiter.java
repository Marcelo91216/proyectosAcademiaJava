package pkg;

public class Waiter {
	private Builder builder;

	public Waiter(Builder builder) {
		super();
		this.builder = builder;
	}
	
	public void changeBuilder(Builder builder) {
		this.builder=builder;
	}
	
	public Tacos barbecueWithArrozMaizPicante() {
		return builder
				.setComplement("Arroz")
				.setSalsa("Picante")
				.setTortilla("Maiz")
				.getResult();
	}
	
	public Tacos chickenWithPureChipotleHarina() {
		return builder
				.setComplement("Pure de papa")
				.setSalsa("Chipotle")
				.setTortilla("Harina")
				.getResult();
	}
	
	public Tacos barbecueWithCebollaLimonMaiz() {
		return builder
				.setTortilla("Maiz")
				.setComplement("Cebolla morada")
				.setSalsa("Limon")
				.getResult();
	}
}
