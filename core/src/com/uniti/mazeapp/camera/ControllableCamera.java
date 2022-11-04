package com.uniti.mazeapp.camera;


import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

public class ControllableCamera implements GestureDetector.GestureListener {

    Camera cam;
    public float CoordX ;
    public float CoordZ ;
    public float CoordY;
    // aspect ratio
    public final float multipliyer;

ControllableCamera(Camera camera) {
    this.cam = camera;
    CoordX = 0f;
    CoordZ = 60f;
    CoordY = 1f;
    multipliyer = (cam.viewportWidth/cam.viewportHeight) * 0.12f;
    camera.position.set(CoordX, 60f, CoordZ);

    camera.lookAt(0,0,0);
}
    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        CoordX = deltaX * multipliyer;
        CoordZ = deltaY * multipliyer;
        cam.translate(-CoordX,0f,-CoordZ);
        cam.update();
        return true;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    @Override
    public void pinchStop() {

    }
}
