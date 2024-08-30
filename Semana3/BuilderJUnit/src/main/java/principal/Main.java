package principal;

import pkg.*;

public class Main {

	public static void main(String[] args) {
		Builder chickenBuilder = new ChickenBuilder();
		Builder barbecueBuilder = new BarbecueBuilder();
		Waiter waiter = new Waiter(barbecueBuilder);
		System.out.println("> Let's checkout the waiter's menu!!");
		System.out.println("> first with the Barbecue dishes");
		Tacos dish1 = waiter.barbecueWithArrozMaizPicante();
		System.out.println(dish1);
		Tacos dish2 = waiter.barbecueWithCebollaLimonMaiz();
		System.out.println(dish2);
		System.out.println("> then with the chicken dishes!!");
		waiter.changeBuilder(chickenBuilder);
		Tacos dish3 = waiter.chickenWithPureChipotleHarina();
		System.out.println(dish3);
		System.out.println("> you can also customize your own dishes!!");
		Tacos personalize1 = barbecueBuilder.reset().setTortilla("Maiz").setSalsa("Botanera")
				.setComplement("Arroz Integral").getResult();
		System.out.println(personalize1);
//		Now try it by yourself!!!!
//		Insert your code here!!!

	}

}
