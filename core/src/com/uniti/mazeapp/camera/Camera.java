package com.uniti.mazeapp.camera;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.PerspectiveCamera;

public class Camera extends PerspectiveCamera {

private final ControllableCamera cCam;

    public Camera() {
        super(60, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.cCam = new ControllableCamera(this);
        near = 45f;
        far = 200f;
        update();
    }
    
    public ControllableCamera GetControlCam() {
        return cCam;
    }
}
