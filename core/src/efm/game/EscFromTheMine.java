package efm.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EscFromTheMine extends ApplicationAdapter {

	private Texture texPlayer, tex300x200, tex140x800, tex320x200,
			tex300x200_1, tex320x200_1;
	private GameObject objPlayer, obj300x200, obj140x800, obj320x200,
			obj300x200_1, obj320x200_1;
	private SpriteBatch sb;
	public OrthographicCamera cam;
	private Music music;

	protected static final int HEIGHT = 800;
	protected static final int WIDTH = 480;

	@Override
	public void create() {

		sb = new SpriteBatch();
		music = Gdx.audio.newMusic(Gdx.files.internal("background_music.mp3"));
		music.setVolume((float) 0.2); // TODO i have to change volume to 0.2 or
										// 0.1
		music.play();

		loadTextures();
		initObjects();
		setupPlayer();
		setupWalls();

	}

	private void setupWalls() {

		obj140x800.x = 0;
		obj140x800.y = 0;
		obj140x800.width = obj140x800.getTexture().getWidth();
		obj140x800.height = obj140x800.getTexture().getHeight();

		obj300x200.x = 320;
		obj300x200.y = 0;
		obj300x200.width = obj300x200.getTexture().getWidth();
		obj300x200.height = obj300x200.getTexture().getHeight();

		obj320x200.x = 320;
		obj320x200.y = 480;
		obj320x200.width = obj320x200.getTexture().getWidth();
		obj320x200.height = obj320x200.getTexture().getHeight();

		obj320x200_1.x = 330;
		obj320x200_1.y = 470;
		obj320x200_1.width = obj320x200_1.getTexture().getWidth();
		obj320x200_1.height = obj320x200_1.getTexture().getHeight();

		obj300x200_1.x = 330;
		obj300x200_1.y = 10;
		obj300x200_1.width = obj300x200_1.getTexture().getWidth();
		obj300x200_1.height = obj300x200_1.getTexture().getHeight();
	}

	private void setupPlayer() {
		objPlayer.x = 200;
		objPlayer.y = 35;
		objPlayer.width = objPlayer.getTexture().getWidth();
		objPlayer.height = objPlayer.getTexture().getHeight();
	}

	private void initObjects() {
		objPlayer = new GameObject(texPlayer);
		obj300x200 = new GameObject(tex300x200);
		obj140x800 = new GameObject(tex140x800);
		obj320x200 = new GameObject(tex320x200);
		obj300x200_1 = new GameObject(tex300x200);
		obj320x200_1 = new GameObject(tex320x200);
	}

	private void loadTextures() {
		texPlayer = new Texture("playertex.png");
		tex140x800 = new Texture("140x800.png");
		tex300x200 = new Texture("300x200.png");
		tex320x200 = new Texture("320x200.png");
		tex320x200_1 = new Texture("320x200.png");
		tex300x200_1 = new Texture("300x200.png");
	}

	@Override
	public void render() {
		update();

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		drawingOnScreen();
	}

	private void drawingOnScreen() {
		sb.begin();

		sb.draw(objPlayer.getTexture(), objPlayer.x, objPlayer.y);
		sb.draw(obj140x800.getTexture(), obj140x800.x, obj140x800.y);
		sb.draw(obj300x200.getTexture(), obj300x200.x, obj300x200.y);
		sb.draw(obj300x200_1.getTexture(), obj300x200_1.x, obj300x200_1.y);
		sb.draw(obj320x200.getTexture(), obj320x200.x, obj320x200.y);
		sb.draw(obj320x200_1.getTexture(), obj320x200_1.x, obj320x200_1.y);

		sb.end();
	}

	private void update() {

		movePlayerInput();
		colisionsOnWalls();

	}

	private void colisionsOnWalls() {
		if (objPlayer.overlaps(obj140x800)) { // colision with left texture
			objPlayer.x = 140;
		}
		if (objPlayer.overlaps(obj300x200)) { // colision with lower texture
			objPlayer.x = 261;
		}

		if (objPlayer.overlaps(obj320x200)) { // colision with upper texture
			objPlayer.x = 261;
		}

		if (objPlayer.overlaps(obj300x200_1)) {
			objPlayer.y = 209;
		}

		if (objPlayer.overlaps(obj320x200_1)) {
			objPlayer.y = 411;
		}

		if (objPlayer.x >= 420) {
			objPlayer.x = 420;
		}

		if (objPlayer.y >= 720) {
			objPlayer.y = 720;
		}

		if (objPlayer.y <= 15) {
			objPlayer.y = 15;
		}
	}

	private void movePlayerInput() {
		if (Gdx.input.isKeyPressed(Keys.A)) {
			objPlayer.x -= 100 * Gdx.graphics.getDeltaTime();
			float posX = objPlayer.x;
			// System.out.println("Coorinate X " + posX);
		}
		if (Gdx.input.isKeyPressed(Keys.D)) {
			objPlayer.x += 100 * Gdx.graphics.getDeltaTime();
			float posX_1 = objPlayer.x;
			// System.out.println("Coorinate X " + posX_1);
		}
		if (Gdx.input.isKeyPressed(Keys.W)) {
			objPlayer.y += 100 * Gdx.graphics.getDeltaTime();
			float posY = objPlayer.y;
			// System.out.println("Coorinate Y " + posY);
		}
		if (Gdx.input.isKeyPressed(Keys.S)) {
			objPlayer.y -= 100 * Gdx.graphics.getDeltaTime();
			float posY_1 = objPlayer.y;
			// System.out.println("Coorinate Y " + posY_1);
		}
	}

	@Override
	public void dispose() {

		tex140x800.dispose();
		tex300x200.dispose();
		tex300x200_1.dispose();
		tex320x200.dispose();
		tex320x200_1.dispose();
		texPlayer.dispose();
		sb.dispose();
		music.dispose();

	}
}
