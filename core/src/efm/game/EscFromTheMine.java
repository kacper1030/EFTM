package efm.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EscFromTheMine extends ApplicationAdapter {
	
	private Texture texPlayer,texLongWall;
	private GameObject objPlayer, objLongWall;
	private SpriteBatch sb;
	public OrthographicCamera cam;
	
	@Override
	public void create () {
		
		sb = new SpriteBatch();
		
		texPlayer = new Texture("playertex.png");
		
		objPlayer = new GameObject(texPlayer);
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		sb.begin();
		
		sb.draw(objPlayer.getTexture(), 0, 0);
		
		sb.end();
		
	}
}
