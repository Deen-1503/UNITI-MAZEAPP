package com.uniti.mazeapp.gui.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;

import com.uniti.mazeapp.gui.MenuSkin;

public class FloorSelectionGroup extends Table {
    private static ButtonGroup floorSelector;
    private static final float screenWidth = Gdx.graphics.getWidth();
    private static final float screenHeight = Gdx.graphics.getHeight();

    final TextButton FLOOR_GROUND;
    final TextButton FLOOR_1;
    final TextButton FLOOR_2;
    final TextButton FLOOR_3;
    final TextButton FLOOR_4;

    public FloorSelectionGroup(Skin skin) {
        super(skin);

        setWidth(getWidth());
        align(Align.right|Align.bottom);
        setPosition(screenWidth,0);


        FLOOR_GROUND = new TextButton("G", skin, MenuSkin.FLOOR_LEVEL_BUTTON);
        FLOOR_GROUND.setChecked(true);
//        setUISize(FLOOR_GROUND);
        FLOOR_1 = new TextButton("1", skin, MenuSkin.FLOOR_LEVEL_BUTTON);
        FLOOR_2 = new TextButton("2", skin, MenuSkin.FLOOR_LEVEL_BUTTON);
        FLOOR_3 = new TextButton("3", skin, MenuSkin.FLOOR_LEVEL_BUTTON);
        FLOOR_4 = new TextButton("4", skin, MenuSkin.FLOOR_LEVEL_BUTTON);

//        FLOOR_GROUND,FLOOR_1,FLOOR_2,FLOOR_3,FLOOR_4
        floorSelector = new ButtonGroup(FLOOR_GROUND,FLOOR_1,FLOOR_2,FLOOR_3,FLOOR_4);
        floorSelector.setMaxCheckCount(1);
        floorSelector.setMinCheckCount(0);
        ;

        add(FLOOR_GROUND).size(setUISize());
        row();
        add(FLOOR_1).size(setUISize());
        row();
        add(FLOOR_2).size(setUISize());
        row();
        add(FLOOR_3).size(setUISize());
        row();
        add(FLOOR_4).padBottom(screenHeight*0.03f).size(setUISize());
    }

    private static float setUISize(){
        float size;
        size = MenuSkin.getScreenRatio()*(screenHeight*0.12f);
        return size;
    }


}
