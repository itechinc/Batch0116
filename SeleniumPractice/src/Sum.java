import org.junit.Test;

import junit.framework.Assert;


public class Sum {

	public int add(int a, int b){
		int c=a+b;
		return c;
	}
	
	@Test
	public void testAdd1(){
		int A=add(10,20);
		int E=30;
		Assert.assertEquals(E, A);
	}
	
	@Test
	public void testAdd2(){
		int A=add(10,0);
		int E=10;
		Assert.assertEquals(E, A);
	
	}
	
}
