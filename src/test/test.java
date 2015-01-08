package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Bowling.Bowling;

public class test {
	
	@Test
	public void testMiss() {
		assertEquals(90,new Bowling().calculateScore("9-9-9-9-9-9-9-9-9-9-"));
	}
	
	@Test
	public void testALLStrike() {
		assertEquals(300,new Bowling().calculateScore("XXXXXXXXXXXX"));
	}
	
	@Test
	public void testSpare() {
		assertEquals(150,new Bowling().calculateScore("5/5/5/5/5/5/5/5/5/5/5"));
	}
	
	@Test
	public void testNormalGame() {
		assertEquals(74,new Bowling().calculateScore("X4-53442-33443/4312"));
	}

}
