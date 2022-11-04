package com.uniti.mazeapp.backend;
import com.badlogic.gdx.Input.TextInputListener;
import com.uniti.mazeapp.gui.main.SearchInputTable;
import com.uniti.mazeapp.utils.SearchKeyWord;

import java.util.Arrays;
import java.util.Objects;

public class SearchEngine implements TextInputListener {
    SearchInputTable searchInputTable = new SearchInputTable();
    String inputText = searchInputTable.getTextInput();
    Short outputKey;
    Boolean searchState = false;
    SearchKeyWord mKeyWord;

    public SearchEngine(){

    }

    @Override
    public void input(String text) {

    }

    @Override
    public void canceled() {

    }
}
