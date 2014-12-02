package calcFirstMax;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
	Calculator calc = new Calculator();

	
	// 没有分组
	@Test
	public void testCase1() {
		calc.setGroupTotal(0); 
		calc.setTeamTotal(20);
		calc.setPageNum(1);
		calc.setPageSize(10);
		
		calc.printInputs();
		calc.calc();
		calc.printOutputs();
		
		assertEquals(calc.getGroupFirst(), -1);
		assertEquals(calc.getGroupMax(), -1);
		assertEquals(calc.getTeamFirst(), 0);
		assertEquals(calc.getTeamMax(), 10);
	}

	// 没有团队 
	@Test
	public void testCase2() {
		calc.setGroupTotal(20); 
		calc.setTeamTotal(0); 
		calc.setPageNum(1);
		calc.setPageSize(10);
		
		calc.printInputs();
		calc.calc();
		calc.printOutputs();
		
		assertEquals(calc.getGroupFirst(), 0);
		assertEquals(calc.getGroupMax(), 10);
		assertEquals(calc.getTeamFirst(), -1);
		assertEquals(calc.getTeamMax(), -1);
	}

	// 既没有分组、也没有团队 
	@Test
	public void testCase3() {
		calc.setGroupTotal(0); 
		calc.setTeamTotal(0);
		calc.setPageNum(1);
		calc.setPageSize(10);
		
		calc.printInputs();
		calc.calc();
		calc.printOutputs();
		
		assertEquals(calc.getGroupFirst(), -1);
		assertEquals(calc.getGroupMax(), -1);
		assertEquals(calc.getTeamFirst(), -1);
		assertEquals(calc.getTeamMax(), -1);
	}
	
	// 既有团队、也有分组
	// 当前页码只有分组信息
	@Test
	public void testCase4() {
		calc.setGroupTotal(15); 
		calc.setTeamTotal(20);
		calc.setPageNum(1);
		calc.setPageSize(10);
		
		calc.printInputs();
		calc.calc();
		calc.printOutputs();
		
		assertEquals(calc.getGroupFirst(), 0);
		assertEquals(calc.getGroupMax(), 10);
		assertEquals(calc.getTeamFirst(), -1);
		assertEquals(calc.getTeamMax(), -1);
	}
	
	// 既有团队、也有分组
	// 当前页码既有分组信息、也有团队信息
	@Test
	public void testCase5() {
		calc.setGroupTotal(15);
		calc.setTeamTotal(20);
		calc.setPageNum(2);
		calc.setPageSize(10);
		
		calc.printInputs();
		calc.calc();
		calc.printOutputs();
		
		assertEquals(calc.getGroupFirst(), 10);
		assertEquals(calc.getGroupMax(), 5);
		assertEquals(calc.getTeamFirst(), 0);
		assertEquals(calc.getTeamMax(), 5);
	}
	
	// 既有团队、也有分组
	// 当前页码只有团队信息
	@Test
	public void testCase6() {
		calc.setGroupTotal(15);
		calc.setTeamTotal(20);
		calc.setPageNum(3);
		calc.setPageSize(10);
		
		calc.printInputs();
		calc.calc();
		calc.printOutputs();
		
		assertEquals(calc.getGroupFirst(), -1);
		assertEquals(calc.getGroupMax(), -1);
		assertEquals(calc.getTeamFirst(), 6);
		assertEquals(calc.getTeamMax(), 10);
	}

}
