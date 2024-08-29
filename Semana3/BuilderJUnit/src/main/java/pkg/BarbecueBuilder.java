package pkg;

import java.util.Objects;

public class BarbecueBuilder implements Builder {
	private String complement;
	private String salsa;
	private String tortilla;

	public BarbecueBuilder() {
		this.complement = "";
		this.salsa = "";
		this.tortilla = "";
	}

	@Override
	public Builder reset() {
		this.complement = "";
		this.salsa = "";
		this.tortilla = "";
		return this;
	}

	@Override
	public Builder setComplement(String complement) {
		this.complement = complement;
		return this;
	}

	@Override
	public Builder setSalsa(String salsa) {
		this.salsa = salsa;
		return this;
	}

	@Override
	public Builder setTortilla(String tortilla) {
		this.tortilla = tortilla;
		return this;
	}

	@Override
	public BarbecueTacos getResult() {
		return new BarbecueTacos(complement, salsa, tortilla);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BarbecueBuilder other = (BarbecueBuilder) obj;
		return Objects.equals(complement, other.complement) && Objects.equals(salsa, other.salsa)
				&& Objects.equals(tortilla, other.tortilla);
	}
}
