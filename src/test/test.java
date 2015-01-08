package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import Bowling.Bowling;

public class test {

	/*@Test
	public void testStrike() {
		assertEquals(10,new Bowling().score("X"));
	}
	
	@Test
	public void testNumber() {
		assertEquals(4,new Bowling().score("4"));
	}
	
	@Test
	public void testMiss() {
		assertEquals(0,new Bowling().score("-"));
	}
	
	@Test
	public void test2numbers() {
		assertEquals(8,new Bowling().score("53"));
	}

	@Test
	public void testSpare() {
		assertEquals(10,new Bowling().score("1/"));
	}
	@Test
	public void testNumberAndMiss() {
		assertEquals(1,new Bowling().score("1-"));
	}*/
	
	@Test
	public void testStrike() {
		assertEquals(85,new Bowling().calculateScore("X4-53442-33443/4312"));
	}
	

}
