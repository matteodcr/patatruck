package info3.game.scene;

import java.io.IOException;

import info3.game.Game;
import info3.game.entity.BasicTableTile;
import info3.game.entity.CookEntity;
import info3.game.entity.CutTile;
import info3.game.entity.DeliveryTile;
import info3.game.entity.FrieTile;
import info3.game.entity.PanTile;
import info3.game.entity.SauceTableTile;
import info3.game.entity.StockTable;
import info3.game.entity.Tile;
import info3.game.entity.TrashTile;
import info3.game.graphics.Graphics;
import info3.game.graphics.Sprite;
import info3.game.position.Direction;
import info3.game.position.PositionF;

public class KitchenScene extends Scene {

	private static final PositionF KITCHEN_ORIGIN = new PositionF(41, 10);

	private CookEntity cook;

	Tile[][] KitchenGrid = new Tile[][] {
			new Tile[] { null, new StockTable(this, 1, 0, Direction.SUD), new BasicTableTile(this, 2, 0, Direction.SUD),
					new BasicTableTile(this, 3, 0, Direction.SUD), new FrieTile(this, 4, 0, Direction.SUD),
					new FrieTile(this, 5, 0, Direction.SUD), new CutTile(this, 6, 0, Direction.SUD),
					new StockTable(this, 7, 0, Direction.SUD), new StockTable(this, 8, 0, Direction.SUD), null },
			new Tile[] { new DeliveryTile(this, 0, 1, Direction.EST), null, null, null, null, null, null, null, null,
					new SauceTableTile(this, 9, 1, Direction.OUEST) },
			new Tile[] { new DeliveryTile(this, 0, 2, Direction.EST), null, null, null, null, null, null, null, null,
					new SauceTableTile(this, 9, 2, Direction.OUEST) },
			new Tile[] { null, new TrashTile(this, 1, 3, Direction.NORD), new StockTable(this, 2, 3, Direction.NORD),
					new PanTile(this, 3, 3, Direction.NORD), new PanTile(this, 4, 3, Direction.NORD),
					new CutTile(this, 5, 3, Direction.NORD), new StockTable(this, 6, 3, Direction.NORD),
					new StockTable(this, 7, 3, Direction.NORD), new StockTable(this, 8, 3, Direction.NORD), null } };

	public KitchenScene(int pixelWidth, int pixelHeight, Game g) {
		super(pixelWidth, pixelHeight, g);
		try {
			cook = new CookEntity(this, KITCHEN_ORIGIN);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getTileWidth() {
		return 13;
	}

	@Override
	public PositionF getOriginOffset() {
		return KITCHEN_ORIGIN.neg();
	}

	@Override
	public Tile getTileAt(int gridX, int gridY) {
		if (gridX < 0 || gridY < 0 || gridX >= 10 || gridY >= 4)
			return null;
		return KitchenGrid[gridY][gridX];
	}

	@Override
	protected int getBackgroundColor() {
		return 0x511e43;
	}

	public CookEntity getCook() {
		return cook;
	}

	@Override
	public void render(Graphics g) {
		super.render(g);
		g.drawSprite(Sprite.KITCHENTRUCK, (g.getWidth() / 2) - 100, -2); // Valeur calculées
		super.render(g);
		this.cook.render(g);
	}

}
