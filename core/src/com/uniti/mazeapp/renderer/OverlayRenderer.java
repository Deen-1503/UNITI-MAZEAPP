package com.uniti.mazeapp.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.uniti.mazeapp.gui.MenuSkin;
import com.uniti.mazeapp.gui.main.MainMenuGroup;

public class OverlayRenderer extends Stage {
    private final Skin mSkin;
    private final MainMenuGroup mainMenuGroup;


    public OverlayRenderer() {
        super(new ScreenViewport());

        mSkin = new MenuSkin();

        mainMenuGroup = new MainMenuGroup(mSkin);
        addActor(mainMenuGroup);

    }

    public void render() {
        act(Gdx.graphics.getDeltaTime());
        draw();
    }

    public void dispose() {
        mSkin.dispose();
        super.dispose();
    }

}
