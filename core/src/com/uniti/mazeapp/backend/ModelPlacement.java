package com.uniti.mazeapp.backend;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.uniti.mazeapp.utils.Keys;

import java.util.Arrays;


public class ModelPlacement {
    private static ModelPlacement modelPlacement = new ModelPlacement();
    private final Array<ModelInstance> instances = new Array<ModelInstance>();

    private final Array<ModelInstance>  ibnusinaG = new Array<ModelInstance>();
    private final Array<ModelInstance> ibnusina1st = new Array<ModelInstance>();
    private final Array<ModelInstance> blockA = new Array<ModelInstance>();

    public static ModelPlacement getModelRenderer() {
        if (modelPlacement == null) {
            modelPlacement = new ModelPlacement();
        }
        return modelPlacement;
    }


    private ModelPlacement() {

    }


    private void setModelPosition() {
        //ibnusina
        Vector3 IBNUSINA_COORDINATE = new Vector3(3.6f, 0f, -37f);
        float IBNUSINA_ROTATION = -33.5f;

        //block A
        Vector3 BLOCKA_COORDINATE = new Vector3(35f, 1f, -15f);
        float BLOCKA_ROTATION = 57.0f;


        //call sorted key
        Array<Short> aKeys = AssetHandler.getInstance().getPieceModelKey();

        //loops through sorted Array of keys
        for (Short building : aKeys) {
            int i;
            if ((building >= 0) && (building <= 6 || building == 1001 || building == 1002)) {
                ibnusinaG.add(AssetHandler.getInstance().getBuildingModel(building));
                for (i = 0; i < ibnusinaG.size; i++) {
                    //instancesArray.get(m).transform.setToRotation(Vector3.Y, -34.3f).trn(4f, 0f, -36.7f);
                    ibnusinaG.get(i).transform.setToRotation(Vector3.Y, IBNUSINA_ROTATION).trn(IBNUSINA_COORDINATE);
                }
            }
            if (building >= 7 && building <= 20 || building == 1005 || building == 1006) {
                blockA.add(AssetHandler.getInstance().getBuildingModel(building));
                for (i = 0; i < blockA.size; i++) {
//                    blockA.get(i).transform.setToRotation(Vector3.Y, 57).trn(35f, 1f, -15f);
                    blockA.get(i).transform.setToRotation(Vector3.Y, BLOCKA_ROTATION).trn(BLOCKA_COORDINATE);

                }
            }

//            if (building >= 7 && building <= 22) {
//                ibnusina1st.add(AssetHandler.getInstance().getBuildingModel(building));
//                for (int m = 0; m < ibnusina1st.size; m++) {
//                    ibnusina1st.get(m).transform.setToRotation(Vector3.Y, -33.5f).trn(3.6f, 0f, -37f);
//                }
//            }
        }
    }

    public void getModelPosition(Array<ModelInstance> modelInstanceArray) {
        setModelPosition();
        modelInstanceArray.addAll(ibnusinaG);
        modelInstanceArray.addAll(ibnusina1st);
        modelInstanceArray.addAll(blockA);
    }

}






