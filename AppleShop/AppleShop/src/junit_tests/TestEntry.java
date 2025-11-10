package junit_tests;

import static org.junit.Assert.*;
import org.junit.Test;
import model.*;

public class TestEntry {

	@Test
	public void test_entry_1() {
		//Initialize product test case
		Product p = new Product("iPad Pro12.9", 1709.00);
		p.setFinish("Space Grey");
		p.setStorage(1000);
		p.setHasCellularConnectivity(true);
		p.setDiscountValue(220.0);

		Entry e = new Entry("F9DN4NKQ1GC", p);

		assertTrue(e.getSerialNumber() == "F9DN4NKQ1GC");

		assertTrue(e.getProduct() == p);
		//assertSame(e.getProduct(), p);

		assertTrue("iPad Pro12.9" == p.getModel());

		assertEquals("Space Grey", e.getProduct().getFinish());

		assertTrue(1000 == e.getProduct().getStorage());

		assertTrue(e.getProduct().hasCellularConnectivity());

		assertEquals(1709.00, e.getProduct().getOrigonalPrice(), 0.1);
		assertEquals(220.00, e.getProduct().getDiscountValue(), 0.1);
		assertEquals(1489.00, e.getProduct().getPrice(), 0.1);

		assertEquals("[F9DN4NKQ1GC] iPad Pro12.9 Space Grey 1000GB "
				+ "(cellular connectivity: true):  "
				+ "$(1709.00 - 220.00)", e.toString());
	}

	@Test
	public void test_entry_2() {
		//Initalize default product nd test cases for default Entry class
		Product p = new Product("iPad Pro12.9", 1709.00);
		p.setFinish("Space Grey");
		p.setStorage(1000);
		p.setHasCellularConnectivity(true);
		p.setDiscountValue(220.0);

		Entry e = new Entry("F9DN4NKQ1GC", p);

		assertTrue(e.getSerialNumber() == "F9DN4NKQ1GC");

		assertTrue(e.getProduct() == p);

		assertEquals("[F9DN4NKQ1GC] iPad Pro12.9 Space Grey 1000GB "
				+ "(cellular connectivity: true):  "
				+ "$(1709.00 - 220.00)", e.toString());

		//Initialize a different product nd test cases for new entry
		Product p2 = new Product("iPad Air", 649.00);
		p2.setFinish("Gold");
		p2.setStorage(64);
		p2.setHasCellularConnectivity(false);
		p2.setDiscountValue(100.0);

		e.setProduct(p2);

		assertTrue(e.getSerialNumber() == "F9DN4NKQ1GC");

		assertTrue(e.getProduct() == p2);

		assertEquals("[F9DN4NKQ1GC] iPad Air Gold 64GB "
				+ "(cellular connectivity: false):  "
				+ "$(649.00 - 100.00)", e.toString());
	}
}
