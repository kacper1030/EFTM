package efm.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EscFromTheMine extends ApplicationAdapter {

	private Texture texPlayer, texLongWall;
	private GameObject objPlayer, objLongWall;
	private SpriteBatch sb;
	public OrthographicCamera cam;

	protected static final int HEIGHT = 800;
	protected static final int WIDTH = 480;

	@Override
	public void create() {

		sb = new SpriteBatch();

		texPlayer = new Texture("playertex.png");

		objPlayer = new GameObject(texPlayer);

		/*
		 * 
		 * 
		 * Below, they are properties of Game Objects
		 */

		objPlayer.x = 50;
		objPlayer.y = 50;
		objPlayer.width = objPlayer.getTexture().getWidth();
		objPlayer.height = objPlayer.getTexture().getHeight();


		
	}

	@Override
	public void render() {
		update();
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		sb.begin();

		sb.draw(objPlayer.getTexture(), objPlayer.x, objPlayer.y);

		sb.end();

	}

	private void update() {
		
		if (Gdx.input.isKeyPressed(Keys.A)) {
			objPlayer.x -= 100 * Gdx.graphics.getDeltaTime();
		}
		if (Gdx.input.isKeyPressed(Keys.D)) {
			objPlayer.x += 100 * Gdx.graphics.getDeltaTime();
		}
		if (Gdx.input.isKeyPressed(Keys.W)) {
			objPlayer.y += 100 * Gdx.graphics.getDeltaTime();
		}
		if (Gdx.input.isKeyPressed(Keys.S)) {
			objPlayer.y -= 100 * Gdx.graphics.getDeltaTime();
		}

	}
}
