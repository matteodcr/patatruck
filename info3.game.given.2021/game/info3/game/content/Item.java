package info3.game.content;

import java.util.HashMap;

public class Item {
	final ItemType type;
	Sauce sauce;

	private HashMap<ItemType, ItemType> cookItem = new HashMap<>() {
		private static final long serialVersionUID = 1L;

		{
			put(ItemType.POTATO, ItemType.COOKED_POTATO);
			put(ItemType.HASHED_MEAT, ItemType.COOKED_HASHED_MEAT);
			put(ItemType.MEAT, ItemType.COOKED_MEAT);
		}
	};

	private HashMap<ItemType, ItemType> cutItem = new HashMap<>() {
		private static final long serialVersionUID = 1L;

		{
			put(ItemType.POTATO, ItemType.FRIES);
			put(ItemType.FRIES, ItemType.GALETTE);
			put(ItemType.COOKED_POTATO, ItemType.MASHED_POTATO);
			put(ItemType.SALAD, ItemType.SALAD_LEAF);
			put(ItemType.TOMATO, ItemType.TOMATO_SLICE);
			put(ItemType.MEAT, ItemType.HASHED_MEAT);
			put(ItemType.BREAD, ItemType.BREAD_SLICE);
		}
	};

	private HashMap<ItemType, ItemType> fryItem = new HashMap<>() {
		private static final long serialVersionUID = 1L;

		{
			put(ItemType.FRIES, ItemType.COOKED_FRIES);
			put(ItemType.GALETTE, ItemType.COOKED_GALETTE);
		}
	};

	public Item(ItemType type, Sauce sauce) {
		this.type = type;
		this.sauce = sauce;
	}

	public Item(ItemType type) {
		this(type, null);
	}

	public ItemType getType() {
		return type;
	}

	public Sauce getSauce() {
		return sauce;
	}

	public void setSauce(Sauce sauce) {
		if (this.sauce == Sauce.KETCHUP && sauce == Sauce.MAYO || this.sauce == Sauce.MAYO && sauce == Sauce.KETCHUP) {
			this.sauce = Sauce.KETCHUP_MAYO;
		} else {
			this.sauce = sauce;
		}
	}

	/**
	 * Returns the cooked element if possible, null otherwise
	 * 
	 * @param ingredient
	 * @return
	 */
	public Item cook() {
		ItemType result = cookItem.get(this.type);
		if (result == null)
			return null;
		return new Item(result);
	}

	/**
	 * Returns the cut element if possible, null otherwise
	 * 
	 * @param ingredient
	 * @return
	 */
	public Item cut() {
		ItemType result = cutItem.get(this.type);
		if (result == null)
			return null;
		return new Item(result);
	}

	/**
	 * Returns the fried element if possible, null otherwise
	 * 
	 * @param ingredient
	 * @return
	 */
	public Item fry() {
		ItemType result = fryItem.get(this.type);
		if (result == null)
			return null;
		return new Item(result);
	}

	@Override
	public String toString() {
		String result = new String();
		result = result + this.type.toString();
		if (sauce != null) {
			result = result + "+ " + this.sauce;
		}
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sauce == null) ? 0 : sauce.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (sauce != other.sauce)
			return false;
		if (type != other.type)
			return false;
		return true;
	}
}
