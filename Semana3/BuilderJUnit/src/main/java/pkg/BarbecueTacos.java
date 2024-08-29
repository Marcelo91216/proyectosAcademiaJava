package pkg;

import java.util.Objects;

public class BarbecueTacos implements Tacos {
	private final String principal;
	private String complement;
	private String salsa;
	private String tortilla;

	public BarbecueTacos(String complement, String salsa, String tortilla) {
		this.principal = "Barbecue";
		this.complement = complement;
		this.salsa = salsa;
		this.tortilla = tortilla;
	}

	@Override
	public String toString() {
		return "BarbecueTacos [principal=" + principal + ", complement=" + complement + ", salsa=" + salsa
				+ ", tortilla=" + tortilla + "]";
	}

	@Override
	public void print() {
		System.out.println("Barbecue Tacos");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BarbecueTacos other = (BarbecueTacos) obj;
		return Objects.equals(complement, other.complement) && Objects.equals(principal, other.principal)
				&& Objects.equals(salsa, other.salsa) && Objects.equals(tortilla, other.tortilla);
	}

}
