package com.uniti.mazeapp.backend;

import static com.uniti.mazeapp.utils.Keys.*;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;

public class AssetHandler {

    private static AssetHandler assetHandler = new AssetHandler();
    private ModelPlacement modelPlacement;

    private final AssetManager mAssetManager;
    public boolean loading;
    public Array<ModelInstance> instances = new Array<>();
    public ModelInstance plane;

    private final ObjectMap<Short, Model> mBuildingModels;


    public static AssetHandler getInstance() {
        if (assetHandler == null) {
            assetHandler = new AssetHandler();
        }
        return assetHandler;
    }

    private AssetHandler() {
        mAssetManager = load();
        mBuildingModels = createBuildingModels();
    }

    public AssetManager getModelLoader(){
        return mAssetManager;
    }

    public ModelInstance getBuildingModel(Short key) {
        return new ModelInstance(mBuildingModels.get(key));
    }

    public Texture getTexture(String path) {
        return mAssetManager.get(path, Texture.class);
    }


    //Model key/enum short value sorter
    public Array<Short> getPieceModelKey(){
        ObjectMap.Keys<Short> key = mBuildingModels.keys();
        Array<Short> keys = key.toArray();
        keys.sort();

        return keys;
    }

    private AssetManager load(){
        AssetManager assetManager = new AssetManager();

        //ibnusina ground floor
        assetManager.load("model/ibnusinaG/ibnusinaG_floor.g3db", Model.class);
        assetManager.load("model/ibnusinaG/ibnusinaG_office.g3db", Model.class);
        assetManager.load("model/ibnusinaG/ibnusinaG_bk1.g3db", Model.class);
        assetManager.load("model/ibnusinaG/ibnusinaG_bk2.g3db", Model.class);
        assetManager.load("model/ibnusinaG/ibnusinaG_bk12.g3db", Model.class);
        assetManager.load("model/ibnusinaG/ibnusinaG_bk13.g3db", Model.class);
        assetManager.load("model/ibnusinaG/ibnusinaG_library.g3db", Model.class);
        assetManager.load("model/ibnusinaG/ibnusinaG_mHalal.g3db", Model.class);
        assetManager.load("model/ibnusinaG/ibnusinaG_wall1.g3db", Model.class);

        //ibnusina 1st floor
        assetManager.load("model/ibnusina1st/ibnusina1st_floor.g3db", Model.class);
        assetManager.load("model/ibnusina1st/ibnusina1st_bk4.g3db", Model.class);
        assetManager.load("model/ibnusina1st/ibnusina1st_bk5.g3db", Model.class);
        assetManager.load("model/ibnusina1st/ibnusina1st_bk6.g3db", Model.class);
        assetManager.load("model/ibnusina1st/ibnusina1st_bk7.g3db", Model.class);
        assetManager.load("model/ibnusina1st/ibnusina1st_bk8.g3db", Model.class);
        assetManager.load("model/ibnusina1st/ibnusina1st_bk9.g3db", Model.class);
        assetManager.load("model/ibnusina1st/ibnusina1st_bk10.g3db", Model.class);
        assetManager.load("model/ibnusina1st/ibnusina1st_bk11.g3db", Model.class);
        assetManager.load("model/ibnusina1st/ibnusina1st_bKaunseling.g3db", Model.class);
        assetManager.load("model/ibnusina1st/ibnusina1st_mk1.g3db", Model.class);
        assetManager.load("model/ibnusina1st/ibnusina1st_mk2.g3db", Model.class);
        assetManager.load("model/ibnusina1st/ibnusina1st_mk3.g3db", Model.class);
        assetManager.load("model/ibnusina1st/ibnusina1st_mKaunseling.g3db", Model.class);
        assetManager.load("model/ibnusina1st/ibnusina1st_sGraphic.g3db", Model.class);
        assetManager.load("model/ibnusina1st/ibnusina1st_tMen.g3db", Model.class);
        assetManager.load("model/ibnusina1st/ibnusina1st_wall.g3db", Model.class);
        assetManager.load("model/ibnusina1st/ibnusina1st_tWoman.g3db", Model.class);

        //Block A
        assetManager.load("model/blockA/blockA_floor.g3db", Model.class);
        assetManager.load("model/blockA/blockA_bilikMSB.g3db", Model.class);
        assetManager.load("model/blockA/blockA_bilikPam.g3db", Model.class);
        assetManager.load("model/blockA/blockA_bilikSwitchGear.g3db", Model.class);
        assetManager.load("model/blockA/blockA_bilikTangkiSedut.g3db", Model.class);
        assetManager.load("model/blockA/blockA_bilikTangkiSedut1.g3db", Model.class);
        assetManager.load("model/blockA/blockA_bilikTX1.g3db", Model.class);
        assetManager.load("model/blockA/blockA_bilikTX2.g3db", Model.class);
        assetManager.load("model/blockA/blockA_bilikUtiliti.g3db", Model.class);
        assetManager.load("model/blockA/blockA_bk16.g3db", Model.class);
        assetManager.load("model/blockA/blockA_bk17.g3db", Model.class);
        assetManager.load("model/blockA/blockA_koperasi.g3db", Model.class);
        assetManager.load("model/blockA/blockA_pAsrama.g3db", Model.class);
        assetManager.load("model/blockA/blockA_pKoperasi.g3db", Model.class);
        assetManager.load("model/blockA/blockA_tadikaKemas.g3db", Model.class);
        assetManager.load("model/blockA/blockA_wall.g3db", Model.class);
        assetManager.load("model/blockA/blockA_outerWall.g3db", Model.class);

        //plane/Floor/road asset......
        assetManager.load("model/plane/plane.g3db", Model.class);

        //texture
        assetManager.load("UI/text-cursor.png", Texture.class);
        assetManager.load("UI/rounded-square-down.png", Texture.class);
        assetManager.load("UI/rounded-square-up.png", Texture.class);
        assetManager.load("UI/zoom-in.png", Texture.class);
        assetManager.load("UI/zoom-out.png", Texture.class);

        assetManager.finishLoading();
        loading = true;
        return assetManager;

    }


    private ObjectMap<Short, Model> createBuildingModels() {
        ObjectMap<Short, Model> buildingModels = new ObjectMap<>();

        //ibnusina ground Floor put model
        buildingModels.put(IBNUSINAG_FLOOR, mAssetManager.get("model/ibnusinaG/ibnusinaG_floor.g3db",Model.class));
        buildingModels.put(MAKMAL_HALAL, mAssetManager.get("model/ibnusinaG/ibnusinaG_mHalal.g3db",Model.class));
        buildingModels.put(PEJABAT_PENTADBIRAN, mAssetManager.get("model/ibnusinaG/ibnusinaG_office.g3db",Model.class));
        buildingModels.put(BK1, mAssetManager.get("model/ibnusinaG/ibnusinaG_bk1.g3db",Model.class));
        buildingModels.put(BK2, mAssetManager.get("model/ibnusinaG/ibnusinaG_bk2.g3db",Model.class));
        buildingModels.put(BK13, mAssetManager.get("model/ibnusinaG/ibnusinaG_bk12.g3db",Model.class));
        buildingModels.put(BK14, mAssetManager.get("model/ibnusinaG/ibnusinaG_bk13.g3db",Model.class));
        buildingModels.put(LIBRARY, mAssetManager.get("model/ibnusinaG/ibnusinaG_library.g3db",Model.class));
        buildingModels.put(IBNUSINAG_WALL, mAssetManager.get("model/ibnusinaG/ibnusinaG_wall1.g3db",Model.class));

        //ibnusina 1st floor put model
        buildingModels.put(IBNUSINA1ST_FLOOR ,mAssetManager.get("model/ibnusina1st/ibnusina1st_floor.g3db", Model.class));
        buildingModels.put(BK4 ,mAssetManager.get("model/ibnusina1st/ibnusina1st_bk4.g3db", Model.class));
        buildingModels.put(BK5 ,mAssetManager.get("model/ibnusina1st/ibnusina1st_bk5.g3db", Model.class));
        buildingModels.put(BK6 ,mAssetManager.get("model/ibnusina1st/ibnusina1st_bk6.g3db", Model.class));
        buildingModels.put(BK7 ,mAssetManager.get("model/ibnusina1st/ibnusina1st_bk7.g3db", Model.class));
        buildingModels.put(BK8 ,mAssetManager.get("model/ibnusina1st/ibnusina1st_bk8.g3db", Model.class));
        buildingModels.put(BK9 ,mAssetManager.get("model/ibnusina1st/ibnusina1st_bk9.g3db", Model.class));
        buildingModels.put(BK10 ,mAssetManager.get("model/ibnusina1st/ibnusina1st_bk10.g3db", Model.class));
        buildingModels.put(BK11 ,mAssetManager.get("model/ibnusina1st/ibnusina1st_bk11.g3db", Model.class));
        buildingModels.put(BILIK_KAUNSELING ,mAssetManager.get("model/ibnusina1st/ibnusina1st_bKaunseling.g3db", Model.class));
        buildingModels.put(MK1 ,mAssetManager.get("model/ibnusina1st/ibnusina1st_mk1.g3db", Model.class));
        buildingModels.put(MK2 ,mAssetManager.get("model/ibnusina1st/ibnusina1st_mk2.g3db", Model.class));
        buildingModels.put(MK3 ,mAssetManager.get("model/ibnusina1st/ibnusina1st_mk3.g3db", Model.class));
        buildingModels.put(MAKMAL_KAUNSELING ,mAssetManager.get("model/ibnusina1st/ibnusina1st_mKaunseling.g3db", Model.class));
        buildingModels.put(STUDIO_GRAPHIC ,mAssetManager.get("model/ibnusina1st/ibnusina1st_sGraphic.g3db", Model.class));
        buildingModels.put(TOILET_MEN ,mAssetManager.get("model/ibnusina1st/ibnusina1st_tMen.g3db", Model.class));
        buildingModels.put(TOILET_WOMAN ,mAssetManager.get("model/ibnusina1st/ibnusina1st_tWoman.g3db", Model.class));
        buildingModels.put(IBNUSINA1ST_WALL ,mAssetManager.get("model/ibnusina1st/ibnusina1st_wall.g3db", Model.class));

        //Block A put model
        buildingModels.put(BLOCKA_FLOOR ,mAssetManager.get("model/blockA/blockA_floor.g3db", Model.class));
        buildingModels.put(BILIK_MSB ,mAssetManager.get("model/blockA/blockA_bilikMSB.g3db", Model.class));
        buildingModels.put(BILIK_PAM ,mAssetManager.get("model/blockA/blockA_bilikPam.g3db", Model.class));
        buildingModels.put(BILIK_SWITCH_GEAR ,mAssetManager.get("model/blockA/blockA_bilikSwitchGear.g3db", Model.class));
        buildingModels.put(BILIK_TANGKI_SEDUT1 ,mAssetManager.get("model/blockA/blockA_bilikTangkiSedut.g3db", Model.class));
        buildingModels.put(BILIK_TANGKI_SEDUT2 ,mAssetManager.get("model/blockA/blockA_bilikTangkiSedut1.g3db", Model.class));
        buildingModels.put(BILIK_TX1 ,mAssetManager.get("model/blockA/blockA_bilikTX1.g3db", Model.class));
        buildingModels.put(BILIK_TX2 ,mAssetManager.get("model/blockA/blockA_bilikTX2.g3db", Model.class));
        buildingModels.put(BILIK_UTILITI ,mAssetManager.get("model/blockA/blockA_bilikUtiliti.g3db", Model.class));
        buildingModels.put(BK16 ,mAssetManager.get("model/blockA/blockA_bk16.g3db", Model.class));
        buildingModels.put(BK17 ,mAssetManager.get("model/blockA/blockA_bk17.g3db", Model.class));
        buildingModels.put(KOPERASI ,mAssetManager.get("model/blockA/blockA_koperasi.g3db", Model.class));
        buildingModels.put(PEJABAT_ASRAMA ,mAssetManager.get("model/blockA/blockA_pAsrama.g3db", Model.class));
        buildingModels.put(PEJABAT_KOPERASI ,mAssetManager.get("model/blockA/blockA_pKoperasi.g3db", Model.class));
        buildingModels.put(TADIKA_KEMAS ,mAssetManager.get("model/blockA/blockA_tadikaKemas.g3db", Model.class));
        buildingModels.put(BLOCKA_WALL ,mAssetManager.get("model/blockA/blockA_wall.g3db", Model.class));
        buildingModels.put(BLOCKA_OUTER_WALL ,mAssetManager.get("model/blockA/blockA_outerWall.g3db", Model.class));

        buildingModels.put(PLANE ,mAssetManager.get("model/plane/plane.g3db", Model.class));

        return buildingModels;
    }

    public void doneLoading() {

        modelPlacement = ModelPlacement.getModelRenderer();
        //set ModelPlacement
        //ModelPlacement.getModelRenderer().getModelPosition(instances);
        //instances.get(2).materials.get(0).set(ColorAttribute.createDiffuse(Color.TEAL));
        modelPlacement.getModelPosition(instances);
        //plane model
        plane = getBuildingModel(PLANE);
        instances.add(plane);

        loading = false;
    }

    public void dispose() {
        mAssetManager.dispose();
        instances.clear();
    }
}
