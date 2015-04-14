
package com.aysidisi.gdxtestgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class GdxTestGame extends ApplicationAdapter
{
	private SpriteBatch batch;

	private OrthographicCamera camera;

	private Sprite sprite;
	
	private Texture texture;
	
	@Override
	public void create()
	{
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		this.batch = new SpriteBatch();
		this.texture = new Texture(Gdx.files.internal("spriteShip.png"));
		this.sprite = new Sprite(this.texture);
		this.sprite.setPosition(w / 2 - this.sprite.getWidth() / 2, h / 2 - this.sprite.getHeight()
				/ 2);
		this.batch = new SpriteBatch();
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	@Override
	public void render()
	{
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Vector3 mousePos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
		this.camera.unproject(mousePos);
		this.sprite
				.setRotation((float) (Math.atan2(
						mousePos.x - (this.sprite.getX() + this.sprite.getWidth() / 2),
						-(mousePos.y - (this.sprite.getY() + this.sprite.getHeight() / 2))) * 180.0d / Math.PI) + 180f);
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A))
		{
			if (Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
			{
				this.sprite.translateX(-1f);
			}
			else
			{
				this.sprite.translateX(-10.0f);
			}
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D))
		{
			if (Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
			{
				this.sprite.translateX(1f);
			}
			else
			{
				this.sprite.translateX(10.0f);
			}
		}
		if (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W))
		{
			this.sprite
			.translateX((float) Math.cos(Math.toRadians(this.sprite.getRotation() + 90f)) * 1);
			this.sprite
			.translateY((float) Math.sin(Math.toRadians(this.sprite.getRotation() + 90f)) * 1);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S))
		{
			if (Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
			{
				this.sprite.translateY(-1f);
			}
			else
			{
				this.sprite.translateY(-10.0f);
			}
		}
		this.batch.begin();
		this.sprite.draw(this.batch);
		this.batch.end();
	}
}
