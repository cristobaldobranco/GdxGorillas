package org.whitesoft.games.gorillas;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GdxGorillas extends ApplicationAdapter {
	SpriteBatch batch;
	ShapeRenderer renderer;
	
	TextureAtlas atlas;
	
	City city = new City();
	
	
	@Override
	public void create () {
		atlas = new TextureAtlas(Gdx.files.internal("sprites.atlas"));
		batch = new SpriteBatch();
		renderer = new ShapeRenderer();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
			city.render(renderer);
		batch.end();
	}
}
