package com;

import com.pkg.*;
import com.pkg.Character;

public class Main {

	public static void main(String[] args) {
		System.out.println("> Creating a new character with a really good armor");
		Component c1 = new SkinKeys(new SkinKeys(new SkinBrackets(new Character())));
		System.out.println(c1);
		System.out.println("> You can assign any kind of armor on any order!!");
		System.out.println("The base character is --> " + new Character());
		System.out.println("> A character with a key armor with 3 bracket armors");
		Component c2 = new SkinBrackets(new SkinBrackets(new SkinBrackets(new SkinKeys(new Character()))));
		System.out.println(c2);
	}

}
