package pkg;

import java.util.Objects;

public class ChickenTacos implements Tacos {
	private final String principal;
	private String salsa;
	private String complement;
	private String tortilla;

	public ChickenTacos(String salsa, String complement, String tortilla) {
		this.principal = "Chicken";
		this.salsa = salsa;
		this.complement = complement;
		this.tortilla = tortilla;
	}

	@Override
	public String toString() {
		return "ChickenTacos [principal=" + principal + ", salsa=" + salsa + ", complement=" + complement
				+ ", tortilla=" + tortilla + "]";
	}

	@Override
	public void print() {
		System.out.println("Chicken Tacos");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChickenTacos other = (ChickenTacos) obj;
		return Objects.equals(complement, other.complement) && Objects.equals(principal, other.principal)
				&& Objects.equals(salsa, other.salsa) && Objects.equals(tortilla, other.tortilla);
	}

}
