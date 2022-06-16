package info3.game.entity;

import info3.game.content.Item;
import info3.game.graphics.Graphics;
import info3.game.graphics.Sprite;
import info3.game.position.AutCategory;
import info3.game.position.AutDirection;
import info3.game.position.Direction;
import info3.game.scene.KitchenScene;
import info3.game.scene.Scene;

public class StockTable extends KitchenTile {
	Item item;
	int stock;

	public StockTable(Scene parent, int gridX, int gridY, Direction d, Item item) {
		super(parent, gridX, gridY, null, d);
		this.stock = 0;
		this.item = item;
		// TODO sprite de la StockTable
	}

	@Override
	public boolean pop(AutDirection direction) { // prendre un aliment
		Item item_player = ((KitchenScene) this.parentScene).getCook().item;
		if (item_player != null) {
			return false;
		} else {
			if (stock == 0) {
				return false;
			} else {
				item_player = this.item;
				stock--;
				return true;
			}
		}
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
		// BufferedImage img = m_images[m_imageIndex];
		g.drawSprite(Sprite.STOCK_TABLE, 0, 0);
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
		// TODO Auto-generated method stub
		return false;
	}

}
