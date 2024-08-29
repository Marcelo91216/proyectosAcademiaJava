package pkg;

public interface Builder {
	Builder reset();

	Builder setComplement(String complement);

	Builder setSalsa(String salsa);

	Builder setTortilla(String tortilla);

	Tacos getResult();
}
