package info3.game.entity;

import info3.game.content.Item;
import info3.game.graphics.Graphics;
import info3.game.graphics.Graphics.Align;
import info3.game.graphics.Sprite;
import info3.game.position.AutCategory;
import info3.game.position.AutDirection;
import info3.game.scene.Scene;

public class StockTable extends KitchenTile {
	Item item;
	int stock;
	Sprite stockItem, empty = Sprite.STOCK_TABLE, full = Sprite.STOCK_TABLE;

	public StockTable(Scene parent, int gridX, int gridY, AutDirection d, Item item, Sprite stockItem) {
		super(parent, gridX, gridY, null, d);
		this.stockItem = stockItem;
		this.stock = 5;
		this.item = item;
		this.stockItem = stockItem;
	}

	@Override
	public EntityType getType() {
		return EntityType.TILE_STOCK;
	}

	@Override
	public boolean pop(AutDirection direction) { // prendre un aliment
		Entity eInteracting = selectEntityToInteractWith();
		if (eInteracting != null) {
			Item item_entity = eInteracting.item;
			if (item_entity != null) {
				return false;
			} else {
				if (stock == 0) {
					return false;
				} else {
					eInteracting.item = this.item;
					stock--;
					if (gotStuff()) {
						this.defaultSprite = full;
					} else {
						this.defaultSprite = empty;
					}
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean wizz(AutDirection direction) {
		return true;
	}

	public int getStock() {
		return this.stock;
	}

	public void addStock(int x) {
		this.stock += x;
	}

	@Override
	public void render(Graphics g) {
		g.drawSprite(Sprite.STOCK_TABLE, 0, 0);
		g.drawSprite(this.stockItem, 0, 0);
		String tmp = Integer.toString(stock);
		g.drawText(tmp, Align.LEFT, 0, 0);
	}

	@Override
	public boolean gwait() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean egg(AutDirection direction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hit(AutDirection direction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean jump(AutDirection direction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean explode() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pick(AutDirection direction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean power() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean protect(AutDirection direction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean store() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean turn(AutDirection direction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gthrow(AutDirection direction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean myDir(AutDirection direction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean closest(AutCategory category, AutDirection direction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotPower() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotStuff() {
		return stock > 0;
	}

}
