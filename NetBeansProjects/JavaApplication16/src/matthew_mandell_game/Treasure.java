package matthew_mandell_game;



import java.util.ArrayList;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;



public class Treasure extends BasicGameState {

    public Treasurechest treasure;
    public Enemy skeleton;

    public ArrayList<Treasurechest> stuff = new ArrayList();

    public ArrayList<Enemy> stuff2 = new ArrayList();

    private boolean[][] hostiles;

    private static TiledMap grassMap;

    private static AppGameContainer app;

    private static Camera camera;

    public static int counter = 0;

	// Player stuff
    private Animation sprite, up, down, left, right, wait;

    /**
     *
     * The collision map indicating which tiles block movement - generated based
     *
     * on tile properties
     */
	// changed to match size of sprites & map
    private static final int SIZE = 64;

	// screen width and height won't change
    private static final int SCREEN_WIDTH = 1000;

    private static final int SCREEN_HEIGHT = 750;

    public Treasure(int xSize, int ySize) {

    }

    public void init(GameContainer gc, StateBasedGame sbg)
            throws SlickException {

        gc.setTargetFrameRate(60);

        gc.setShowFPS(false);

		// *******************
		// Scenerey Stuff
		// ****************
        grassMap = new TiledMap("res/m4.tmx");

		// Ongoing checks are useful
        System.out.println("Tile map is this wide: " + grassMap.getWidth());

        camera = new Camera(gc, grassMap);

		// *********************************************************************************
		// Player stuff --- these things should probably be chunked into methods
        // and classes
		// *********************************************************************************
        SpriteSheet runningSS = new SpriteSheet(
                "res/Player_sprite", 64, 64, 0);

		// System.out.println("Horizontal count: "
        // +runningSS.getHorizontalCount());
		// System.out.println("Vertical count: " +runningSS.getVerticalCount());
        up = new Animation();

        up.setAutoUpdate(true);

        up.addFrame(runningSS.getSprite(9, 0), 330);

        up.addFrame(runningSS.getSprite(9, 1), 330);

        up.addFrame(runningSS.getSprite(9, 2), 330);

        up.addFrame(runningSS.getSprite(9, 3), 330);

        up.addFrame(runningSS.getSprite(9, 4), 330);

        up.addFrame(runningSS.getSprite(9, 5), 330);

        up.addFrame(runningSS.getSprite(9, 6), 330);

        up.addFrame(runningSS.getSprite(9, 7), 330);

        up.addFrame(runningSS.getSprite(9, 8), 330);

        down = new Animation();

        down.setAutoUpdate(false);

        down.addFrame(runningSS.getSprite(11, 0), 330);

        down.addFrame(runningSS.getSprite(11, 1), 330);

        down.addFrame(runningSS.getSprite(11, 2), 330);

        down.addFrame(runningSS.getSprite(11, 3), 330);

        down.addFrame(runningSS.getSprite(11, 4), 330);

        down.addFrame(runningSS.getSprite(11, 5), 330);

        down.addFrame(runningSS.getSprite(11, 6), 330);

        down.addFrame(runningSS.getSprite(11, 7), 330);

        down.addFrame(runningSS.getSprite(11, 8), 330);

        left = new Animation();

        left.setAutoUpdate(false);

        left.addFrame(runningSS.getSprite(10, 0), 330);

        left.addFrame(runningSS.getSprite(10, 1), 330);

        left.addFrame(runningSS.getSprite(10, 2), 330);

        left.addFrame(runningSS.getSprite(10, 3), 330);

        left.addFrame(runningSS.getSprite(10, 4), 330);

        left.addFrame(runningSS.getSprite(10, 5), 330);

        left.addFrame(runningSS.getSprite(10, 6), 330);

        left.addFrame(runningSS.getSprite(10, 7), 330);

        left.addFrame(runningSS.getSprite(10, 8), 330);

        right = new Animation();

        right.setAutoUpdate(false);

        right.addFrame(runningSS.getSprite(12, 0), 330);

        right.addFrame(runningSS.getSprite(12, 1), 330);

        right.addFrame(runningSS.getSprite(12, 2), 330);

        right.addFrame(runningSS.getSprite(12, 3), 330);

        right.addFrame(runningSS.getSprite(12, 4), 330);

        right.addFrame(runningSS.getSprite(12, 5), 330);

        right.addFrame(runningSS.getSprite(12, 6), 330);

        right.addFrame(runningSS.getSprite(12, 7), 330);

        right.addFrame(runningSS.getSprite(12, 8), 330);

        wait = new Animation();

        wait.setAutoUpdate(true);

        wait.addFrame(runningSS.getSprite(3, 0), 733);

        wait.addFrame(runningSS.getSprite(3, 1), 733);

        wait.addFrame(runningSS.getSprite(3, 2), 733);

        wait.addFrame(runningSS.getSprite(3, 3), 733);

		// wait.addFrame(runningSS.getSprite(2, 14), 733);
		// wait.addFrame(runningSS.getSprite(5, 14), 333);
        sprite = wait;

		// *****************************************************************
		// Obstacles etc.
		// build a collision map based on tile properties in the TileD map
        Blocked.blocked = new boolean[grassMap.getWidth()][grassMap.getHeight()];

		// System.out.println("Map height:" + grassMap.getHeight());
		// System.out.println("Map width:" + grassMap.getWidth());
		// There can be more than 1 layer. You'll check whatever layer has the
        // obstacles.
		// You could also use this for planning traps, etc.
		// System.out.println("Number of tile layers: "
        // +grassMap.getLayerCount());
        System.out.println("The grassmap is " + grassMap.getWidth() + "by "
                + grassMap.getHeight());

        for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {

            for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {

				// int tileID = grassMap.getTileId(xAxis, yAxis, 0);
				// Why was this changed?
				// It's a Different Layer.
				// You should read the TMX file. It's xml, i.e.,human-readable
                // for a reason
                int tileID = grassMap.getTileId(xAxis, yAxis, 1);

                String value = grassMap.getTileProperty(tileID,
                        "blocked", "false");

                if ("true".equals(value)) {

                    System.out.println("The tile at x " + xAxis + " andy axis "
                            + yAxis + " is blocked.");

                    Blocked.blocked[xAxis][yAxis] = true;

                }

            }

        }

        System.out.println("Array length" + Blocked.blocked[0].length);

		// A remarkably similar process for finding hostiles
        hostiles = new boolean[grassMap.getWidth()][grassMap.getHeight()];

        for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
            for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
                int xBlock = (int) xAxis;
                int yBlock = (int) yAxis;
                if (!Blocked.blocked[xBlock][yBlock]) {
                    if (yBlock % 7 == 0 && xBlock % 15 == 0) {
			//			Item i = new Item(xAxis * SIZE, yAxis * SIZE);
                        //			stuff.add(i);
                        //stuff1.add(h);
                        hostiles[xAxis][yAxis] = true;
                    }
                }
            }
        }

	//	for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
        //		for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
        //			int xBlock = (int) xAxis;
        //			int yBlock = (int) yAxis;
        //			if (!blocked.blocked[xBlock][yBlock]) {
        //				if (xBlock % 9 == 0	&& yBlock % 25 == 0) {
        //					Item1 h = new Item1(xAxis * SIZE, yAxis * SIZE);
        //	stuff.add(i);
        //					stuff1.add(h);
        //					hostiles[xAxis][yAxis] = true;
        //				}
        //			}
        //		}
        //	}
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
            throws SlickException {

        camera.centerOn((int) Player.x, (int) Player.y);

        camera.drawMap();

        camera.translateGraphics();

		// it helps to add status reports to see what's going on
		// but it gets old quickly
		// System.out.println("Current X: " +player.x + " \n Current Y: "+ y);
        sprite.draw((int) Player.x, (int) Player.y);

		//g.drawString("x: " + (int)player.x + "y: " +(int)player.y , player.x, player.y - 10);
        g.drawString("Health: " + Player.health / 1000, camera.cameraX + 10,
                camera.cameraY + 10);

        g.drawString("speed: " + (int) (Player.speed * 10), camera.cameraX + 10,
                camera.cameraY + 25);

		//g.draw(player.rect);
        g.drawString("time passed: " + counter / 1000, camera.cameraX + 600, camera.cameraY);
		// moveenemies();

        for (Treasurechest t : stuff) {

            if (Player.rect.intersects(t.hitbox)) {
                //System.out.println("yay");
                if (treasure.isvisible) {

                    Player.health += 10000;
                    t.isvisible = false;
                    /**
                     *
                     * @param gc
                     * @param sbg
                     * @param delta
                     * @throws SlickException
                     */
                    
                    
                }
            }}
    }
    
    public void update(GameContainer gc, StateBasedGame sbg, int delta)
            throws SlickException {

        counter += delta;

        Input input = gc.getInput();

        float fdelta = delta * Player.speed;

        Player.setpdelta(fdelta);

        double rightlimit = (grassMap.getWidth() * SIZE) - (SIZE * 0.75);

		// System.out.println("Right limit: " + rightlimit);
        float projectedright = Player.x + fdelta + SIZE;

        boolean cangoright = projectedright < rightlimit;

		// there are two types of fixes. A kludge and a hack. This is a kludge.
        if (input.isKeyDown(Input.KEY_UP)) {

            sprite = up;

            float fdsc = (float) (fdelta - (SIZE * .15));

            if (!(isBlocked(Player.x, Player.y - fdelta) || isBlocked((float) (Player.x + SIZE + 1.5), Player.y - fdelta))) {

                sprite.update(delta);

				// The lower the delta the slower the sprite will animate.
                Player.y -= fdelta;

            }

        } else if (input.isKeyDown(Input.KEY_DOWN)) {

            sprite = down;

            if (!isBlocked(Player.x, Player.y + SIZE + fdelta)
                    || !isBlocked(Player.x + SIZE - 1, Player.y + SIZE + fdelta)) {

                sprite.update(delta);

                Player.y += fdelta;

            }

        } else if (input.isKeyDown(Input.KEY_LEFT)) {

            sprite = left;

            if (!(isBlocked(Player.x - fdelta, Player.y) || isBlocked(Player.x
                    - fdelta, Player.y + SIZE - 1))) {

                sprite.update(delta);

                Player.x -= fdelta;

            }

        } else if (input.isKeyDown(Input.KEY_RIGHT)) {

            sprite = right;

			// the boolean-kludge-implementation
            if (cangoright
                    && (!(isBlocked(Player.x + SIZE + fdelta,
                            Player.y) || isBlocked(Player.x + SIZE + fdelta, Player.y
                            + SIZE - 1)))) {

                sprite.update(delta);

                Player.x += fdelta;

            } // else { System.out.println("Right limit reached: " +
            // rightlimit);}

        }

        Player.rect.setLocation(Player.getplayershitboxX(),
                Player.getplayershitboxY());

        Player.health -= counter / 1000;
        if (Player.health <= 0) {
            makevisible();
            sbg.enterState(2, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
        }

    }

	public int getID() {
		return 1;
                
        }

    private boolean isBlocked(float tx, float ty) {
        int xBlock = (int) tx / SIZE;

        int yBlock = (int) ty / SIZE;

        return Blocked.blocked[xBlock][yBlock];
    }

    private void makevisible() {

    }

        

}