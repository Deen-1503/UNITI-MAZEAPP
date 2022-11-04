package com.uniti.mazeapp.gui.main;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.Align;
import com.uniti.mazeapp.gui.MenuSkin;

public class SearchInputTable extends Table {
    private TextField searchField;

    public SearchInputTable(){
        
    }

    public void SearchTable(Skin skin){
        setWidth(getWidth());
        align(Align.top|Align.center);
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        setPosition(screenWidth /2, screenHeight);

        searchField = new TextField("",skin, MenuSkin.SEARCH_TEXTFIELD);
        searchField.setMessageText("Search Here");


        add(searchField).size( (screenWidth * 0.75f) ,(MenuSkin.getScreenRatio()*(screenHeight *0.1f))).pad(MenuSkin.getScreenRatio()*30f);
    }

    public String getTextInput() {
        String userTextInput;
        userTextInput = searchField.getText();

        return userTextInput;
    }

}
