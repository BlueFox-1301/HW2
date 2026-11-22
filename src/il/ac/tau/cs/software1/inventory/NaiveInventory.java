package il.ac.tau.cs.software1.inventory;

/*
 * A simple array-based Inventory (Question 6).
 */
public class NaiveInventory implements Inventory {

	private static final int INITIAL_CAPACITY = 100;

	private Collectible[] collectibles;
	private int actualyStored;

	public NaiveInventory() {
		this.collectibles = new Collectible[INITIAL_CAPACITY];
		this.actualyStored = 0;
	}

	@Override
	public void collect(Collectible collectible) {
		if (actualyStored == collectibles.length) {
			Collectible[] tmp = new Collectible[collectibles.length * 2];
			for (int i = 0; i < actualyStored; i++) {
				tmp[i] = collectibles[i];
			}
			collectibles = tmp;
		}
		collectibles[actualyStored] = collectible;
		actualyStored++;
	}

	@Override
	public float getTotalWeight() {
		
		float sum = 0;
		for (int i = 0; i < actualyStored; i++) {
			sum += this.collectibles[i].getWeight();
		}

		return sum;
	}

	@Override
	public int getCurrentCount() {
		return actualyStored;
	}

	// Returns the array of Collectibles that is stored in the field of this class
	public Collectible[] getCollArr() {
		return collectibles;
	}
}
