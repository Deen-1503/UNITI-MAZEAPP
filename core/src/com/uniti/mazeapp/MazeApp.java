package com.uniti.mazeapp;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.input.GestureDetector;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.uniti.mazeapp.camera.Camera;
import com.uniti.mazeapp.renderer.OverlayRenderer;
import com.uniti.mazeapp.backend.AssetHandler;

public class MazeApp extends ApplicationAdapter {

	private AssetHandler assetHandler;
	private Camera cCam;
	private OverlayRenderer mOverlayRenderer;
	private Viewport viewPort;

	public ModelBatch modelBatch;
	public Environment environment;
	
	@Override
	public void create () {

		modelBatch = new ModelBatch();
		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight,0.45f,0.45f,0.45f,1f));
		environment.add(new DirectionalLight().set(0.8f,0.8f,0.8f,0f,-0.8f,-0.2f));
		cCam = new Camera();
		assetHandler =  AssetHandler.getInstance();

		mOverlayRenderer = new OverlayRenderer();
		GestureDetector control = new GestureDetector(cCam.GetControlCam());
		InputMultiplexer inputMultiplexer = new InputMultiplexer(mOverlayRenderer,control);
		Gdx.input.setInputProcessor(inputMultiplexer);

	}

	@Override
	public void render () {

//		Gdx.gl.glEnable(Gdx.gl20.GL_DEPTH_TEST);
//		Gdx.gl20.glDepthFunc(GL20.GL_EQUAL);

		if (assetHandler.loading && assetHandler.getModelLoader().update())
			assetHandler.doneLoading();

//		Gdx.gl.glEnable(Gdx.gl20.GL_POLYGON_OFFSET_FILL);
//		Gdx.gl20.glPolygonOffset(0f, 0f);

		Gdx.gl.glClearColor(0.954f,0.954f,0.954f,1);
		Gdx.gl.glViewport(1,1,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);


		modelBatch.begin(cCam);
		modelBatch.render(assetHandler.instances,environment);
		modelBatch.end();
		mOverlayRenderer.render();

	}
	
	@Override
	public void dispose () {
		modelBatch.dispose();
		assetHandler.dispose();
		mOverlayRenderer.dispose();
	}

	@Override
	public void resume() {

	}

	@Override
	public void resize(int width, int height) {
//		viewPort.update(width, height);
	}

	@Override
	public void pause() {

	}
}
