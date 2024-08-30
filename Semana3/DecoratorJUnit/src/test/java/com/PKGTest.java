package com;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.pkg.Character;
import com.pkg.SkinBrackets;
import com.pkg.SkinKeys;
import com.pkg.Component;
import com.pkg.BaseSkin;

class PKGTest {

	@Test
	void createCharacter() {
		Character c = new Character();
		assertEquals("(°-°)", c.toString());
	}

	@Test
	void characterWithBrackets() {
		Component c = new SkinBrackets(new Character());
		assertEquals("[(°-°)]", c.execute());
	}
	
	@Test
	void characterWithKeys() {
		Component c = new SkinKeys(new Character());
		assertEquals("{(°-°)}", c.execute());
	}
	
	@Test
	void mixedSkins() {
		Component c = new SkinBrackets(new SkinKeys(new Character()));
		assertEquals("[{(°-°)}]", c.toString());
	}
}
