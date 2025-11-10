package model;

public class RefurbishedStore {
	//Global variables
	private Entry[] entries;
	private int noe;
	private final int MAX_CAPACITY = 5;

	//Constructor
	public RefurbishedStore() {
		this.entries = new Entry[MAX_CAPACITY];
		this.noe = 0;	
	}

	public int getNumberOfEntries() {
		return noe;
	}

	public Entry[] getPrivateEntriesArray() {
		return this.entries;
	}

	public Entry[] getEntries() {
		Entry[] es =  new Entry[this.noe];

		for(int i = 0; i < es.length; i++) {
			es[i] = this.entries[i];
		}

		return es;
	}

	public void addEntry(Entry e) {
		entries[noe] = e;
		noe++;
	}

	public void addEntry(String sn, Product p) {
		addEntry(new Entry(sn, p));
	}

	public void addEntry(String sn, String model, double origionalPrice) {
		addEntry(new Entry(sn, new Product(model, origionalPrice)));
	}

	public Product getProduct(String sn) {
		int index = -1;
		for(int i = 0; i < noe; i++) {
			Entry e = entries[i];
			if (e.getSerialNumber().equals(sn)) {
				index = i;
			}
		}

		if (index < 0) {
			return null;
		}
		else {
			return entries[index].getProduct();	
		}
	}
	
	public String[] getSpaceGreyOrPro() {
		int count = 0;
		int[] indicies = new int[noe];
		
		for(int i = 0; i < noe; i++) {
			Product p = entries[i].getProduct();
			
			if(p.getModel().contains("Pro") || (p.getFinish() != null && p.getFinish().equals("Space Grey"))) {
				indicies[count] = i;
				count++;
			}
		}
		
		String[] sns = new String[count];
		
		for(int i = 0; i<count; i++) {
			sns[i] = entries[indicies[i]].getSerialNumber();
		}
		
		return sns;
	}
	
	public String[] getSpaceGreyPro() {
		int count = 0;
		int[] indicies = new int[noe];
		
		for(int i = 0; i < noe; i++) {
			Product p = entries[i].getProduct();
			
			if(p.getModel().contains("Pro") && p.getFinish() != null && p.getFinish().equals("Space Grey")) {
				indicies[count] = i;
				count++;
			}
		}
		
		String[] sns = new String[count];
		
		for(int i = 0; i<count; i++) {
			sns[i] = entries[indicies[i]].getSerialNumber();
		}
		
		return sns;
	}
}
