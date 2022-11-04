package com.uniti.mazeapp.gui.main;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class MainMenuGroup extends Group {

    public MainMenuGroup(Skin skin) {
        FloorSelectionGroup floorSelectionGroup = new FloorSelectionGroup(skin);
        SearchInputTable searchInputTable = new SearchInputTable();
        searchInputTable.SearchTable(skin);

        addActor(searchInputTable);
        addActor(floorSelectionGroup);
    }
}
