package pkg;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pkg.*;

class WaiterTest {
	
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	
	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@Test
	void testDish1() {
		Builder builder = new BarbecueBuilder();
		Waiter waiter = new Waiter(builder);
		assertEquals("BarbecueTacos [principal=Barbecue, complement=Arroz, salsa=Picante, tortilla=Maiz]", waiter.barbecueWithArrozMaizPicante().toString());
	}

	@Test
	void testDish2() {
		Builder builder = new ChickenBuilder();
		Waiter waiter = new Waiter(builder);
		assertEquals("ChickenTacos [principal=Chicken, salsa=Chipotle, complement=Pure de papa, tortilla=Harina]", waiter.chickenWithPureChipotleHarina().toString());
	}
	
	@Test
	void testDish3() {
		Builder builder = new BarbecueBuilder();
		Waiter waiter = new Waiter(builder);
		assertEquals("BarbecueTacos [principal=Barbecue, complement=Cebolla morada, salsa=Limon, tortilla=Maiz]", waiter.barbecueWithCebollaLimonMaiz().toString());
	}
	
	@Test
	void changeBuilderOnWaiter() {
		Builder b1 = new ChickenBuilder();
		Builder b2 = new BarbecueBuilder();
		Waiter waiter = new Waiter(b1);
		waiter.changeBuilder(b2);
		assertEquals("BarbecueTacos [principal=Barbecue, complement=Cebolla morada, salsa=Limon, tortilla=Maiz]", waiter.barbecueWithCebollaLimonMaiz().toString());
	}
	
	@Test
	void barbecueNotEqualsChicken() {
		Builder b1 = new BarbecueBuilder();
		Builder b2 = new ChickenBuilder();
		assert(!b1.equals(b2));
	}
	
	@Test
	void chickenNotEqualsBarbecue() {
		Builder b1 = new ChickenBuilder();
		Builder b2 = new BarbecueBuilder();
		assert(!b1.equals(b2));
	}
	
	@Test
	void barbecueNotEqualsNull() {
		assert(!new BarbecueBuilder().equals(null));
	}
	
	@Test
	void chickenNotEqualsNull() {
		assert(!new ChickenBuilder().equals(null));
	}
	
	@Test
	void barbecueEquals() {
		assert(new BarbecueBuilder().equals(new BarbecueBuilder()));
	}
	
	@Test
	void chickenEquals() {
		assert(new ChickenBuilder().equals(new ChickenBuilder()));
	}
	
	@Test
	void resetBarbecueBuilder() {
		Builder b = new BarbecueBuilder();
		assertEquals("BarbecueTacos [principal=Barbecue, complement=, salsa=, tortilla=]", b
				.setTortilla("Harina")
				.reset()
				.getResult()
				.toString()
				);
	}
	
	@Test
	void compareBarbecueTacos() {
		Builder b1 = new BarbecueBuilder();
		Builder b2 = new BarbecueBuilder();
		assert(b1.getResult().equals(b2.getResult()));
	}
	
	@Test
	void compareChickenTacos() {
		Builder c1 = new ChickenBuilder();
		Builder c2 = new ChickenBuilder();
		assert(c1.getResult().equals(c2.getResult()));
	}
	
	@Test
	void printChicken() {
		Builder c = new ChickenBuilder();
		c.getResult().print();
		assertEquals("Chicken Tacos", outputStreamCaptor.toString().trim());
	}
	
	@Test
	void printBarbecue() {
		Builder b = new BarbecueBuilder();
		b.getResult().print();
		assertEquals("Barbecue Tacos", outputStreamCaptor.toString().trim());
	}
}
