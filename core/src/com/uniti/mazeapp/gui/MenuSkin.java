package com.uniti.mazeapp.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.uniti.mazeapp.backend.AssetHandler;


public class MenuSkin extends Skin {

    public final static String TEX_LOW_ALPHA_GREY = "low_alpha";
    public final static String ZOOM_IN = "zoom_in";
    public final static String ZOOM_OUT = "zoom_out";
    public final static String SEARCH_TEXTFIELD = "search_input";

    public final static String FLOOR_LEVEL_BUTTON = "floor_button";
    public final static String FLOOR_LEVEL_SELECTBOX = "floor_selectbox";


    private final Pixmap mHighAlphaGray;
    private final Pixmap mLowAlphaGray;
    private final Pixmap mFullWhite;
    private final Texture mLowAlphaGreyTexture;
    private final Texture mHighAlphaGreyTexture;
    private final Texture mRoundedCorner;


    public static float getScreenRatio() {
        float screenRatio;
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        if (height >= 1080f) {
            screenRatio = width/height;
            return screenRatio;
        }

        else {
            screenRatio = height/width;
            return screenRatio;
        }
    }

    public static Pixmap getPixmapRoundedRectangle(int width, int height, int radius, Color color) {

        Pixmap pixmap = new Pixmap(width, height, Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fillRectangle(0, radius, pixmap.getWidth(), pixmap.getHeight()-2*radius);
        pixmap.fillRectangle(radius, 0, pixmap.getWidth() - 2*radius, pixmap.getHeight());

        pixmap.fillCircle(radius, radius, radius);
        pixmap.fillCircle(radius, pixmap.getHeight()-radius, radius);
        pixmap.fillCircle(pixmap.getWidth()-radius, radius, radius);
        pixmap.fillCircle(pixmap.getWidth()-radius, pixmap.getHeight()-radius, radius);

        return pixmap;
    }

    public MenuSkin() {
        AssetHandler aH = AssetHandler.getInstance();

        mHighAlphaGray = new Pixmap(4,4,Format.RGBA8888);
        mHighAlphaGray.setColor(0f,0f,0f,0.8f);
        mHighAlphaGray.fill();

        mLowAlphaGray = new Pixmap(4,4, Format.RGBA8888);
        mLowAlphaGray.setColor(0.0f,0.0f,0.0f,0.5f);
        mLowAlphaGray.fill();

        mFullWhite = new Pixmap(4,4,Format.RGBA8888);
        mFullWhite.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        mFullWhite.fill();

        mLowAlphaGreyTexture = new Texture(mLowAlphaGray);
        mHighAlphaGreyTexture = new Texture(mHighAlphaGray);
        mRoundedCorner = new Texture(getPixmapRoundedRectangle(10,10,10, Color.LIGHT_GRAY));

        TextureRegionDrawable lowAlpha = new TextureRegionDrawable(new TextureRegion(mLowAlphaGreyTexture));
        add(TEX_LOW_ALPHA_GREY, lowAlpha);
        TextureRegionDrawable highAlpha = new TextureRegionDrawable(new TextureRegion(mHighAlphaGreyTexture));

        TextureRegionDrawable roundedAlpha = new TextureRegionDrawable(new TextureRegion(mRoundedCorner));

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("UI/font/CenturyGothic.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        parameter.size = 10;
        BitmapFont extraSmallFont = generator.generateFont(parameter);

        parameter.size = 20;
        BitmapFont smallFont = generator.generateFont(parameter);

        parameter.size = 36;
        BitmapFont largeFont = generator.generateFont(parameter);
        largeFont.setUseIntegerPositions(true);

        parameter.padLeft = 20;
        parameter.size = 24;
        BitmapFont mediumFont = generator.generateFont(parameter);


        generator.dispose();
        add("default", largeFont);

        //Search Input GUI Style
        TextFieldStyle searchInput = new TextFieldStyle();
        TextureRegionDrawable cursorRegion = new TextureRegionDrawable(aH.getTexture("UI/text-cursor.png"));
            cursorRegion.setMinWidth(getScreenRatio()*60f);
        searchInput.font = mediumFont;
        searchInput.fontColor = Color.WHITE;
        searchInput.messageFontColor = Color.WHITE;
        searchInput.background = roundedAlpha;
        searchInput.disabledBackground = highAlpha;
        searchInput.cursor = cursorRegion;
        add(SEARCH_TEXTFIELD, searchInput);

        //default button
        TextButtonStyle textButton = new TextButtonStyle();
        textButton.font = smallFont;
        textButton.up = new TextureRegionDrawable(new TextureRegion(aH.getTexture("UI/rounded-square-up.png")));
        textButton.down = new TextureRegionDrawable(new TextureRegion(aH.getTexture("UI/rounded-square-down.png")));
        add("default",textButton);

        //Floor selection Button
        TextButtonStyle btnFloor = new TextButtonStyle();
        btnFloor.font = smallFont;
        btnFloor.fontColor = Color.BLACK;
        btnFloor.up = new TextureRegionDrawable(new TextureRegion(aH.getTexture("UI/rounded-square-up.png")));
        btnFloor.down = new TextureRegionDrawable(new TextureRegion(aH.getTexture("UI/rounded-square-down.png")));
        btnFloor.downFontColor = Color.WHITE;
        btnFloor.checked = new TextureRegionDrawable(new TextureRegion(aH.getTexture("UI/rounded-square-down.png")));
        btnFloor.checkedFontColor = Color.GREEN;
        add(FLOOR_LEVEL_BUTTON,btnFloor);


        //Zoom button
        ImageButtonStyle zoomInbtn = new ImageButtonStyle();
        zoomInbtn.up = new TextureRegionDrawable(new TextureRegion(aH.getTexture("UI/zoom-in.png")));
        add(ZOOM_IN,zoomInbtn);

        ImageButtonStyle zoomOutbtn = new ImageButtonStyle();
        zoomOutbtn.up = new TextureRegionDrawable(new TextureRegion(aH.getTexture("UI/zoom-out.png")));
        add(ZOOM_OUT,zoomOutbtn);
    }

    /**
     * Destroys the Pixmap and Textures created with them, all non-generated
     * textures that are used are destroyed by AssetHandler
     */
    @Override
    public void dispose() {
        mHighAlphaGray.dispose();
        mLowAlphaGray.dispose();
        mFullWhite.dispose();
        mLowAlphaGreyTexture.dispose();
        mHighAlphaGreyTexture.dispose();
        mRoundedCorner.dispose();

        super.dispose();
    }
}
