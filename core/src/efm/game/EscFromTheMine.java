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

	private Texture texPlayer, tex300x200, tex140x800;
	private GameObject objPlayer, obj300x200, obj140x800;
	private SpriteBatch sb;
	public OrthographicCamera cam;

	protected static final int HEIGHT = 800;
	protected static final int WIDTH = 480;

	@Override
	public void create() {

		sb = new SpriteBatch();

		texPlayer = new Texture("playertex.png");
		tex140x800 = new Texture("140x800.png");
		tex300x200 = new Texture("300x200.png");

		objPlayer = new GameObject(texPlayer);
		obj300x200 = new GameObject(tex300x200);
		obj140x800 = new GameObject(tex140x800);

		/*
		 * 
		 * 
		 * Below, they are properties of Game Objects
		 */

		objPlayer.x = 50;
		objPlayer.y = 50;
		objPlayer.width = objPlayer.getTexture().getWidth();
		objPlayer.height = objPlayer.getTexture().getHeight();
		
		obj140x800.x = 0;
		obj140x800.y = 0;
		obj140x800.width = obj140x800.getTexture().getWidth();
		obj140x800.height = obj140x800.getTexture().getHeight();
		
		obj300x200.x = 320;
		obj300x200.y = 0;
		obj300x200.width = obj140x800.getTexture().getWidth();
		obj300x200.height = obj140x800.getTexture().getHeight();

	}

	@Override
	public void render() {
		update();

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		sb.begin();

		sb.draw(objPlayer.getTexture(), objPlayer.x, objPlayer.y);
		sb.draw(obj140x800.getTexture(), obj140x800.x, obj140x800.y);
		sb.draw(obj300x200.getTexture(), obj300x200.x, obj300x200.y);

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
