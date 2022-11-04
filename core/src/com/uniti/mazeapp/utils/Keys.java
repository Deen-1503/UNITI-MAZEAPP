package com.uniti.mazeapp.utils;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ArrayMap;

import java.util.HashMap;

public enum Keys {
    ;

    //ibnusina ground floor
    public static final Short BK1 = 0;
    public static final Short BK2 = 1;
    public static final Short BK13 = 2;
    public static final Short BK14 = 3;
    public static final Short LIBRARY = 4;
    public static final Short MAKMAL_HALAL = 5;
    public static final Short PEJABAT_PENTADBIRAN = 6;

    //Block A
    public static final Short BILIK_MSB = 7;
    public static final Short BILIK_PAM = 8;
    public static final Short BILIK_SWITCH_GEAR = 9;
    public static final Short TADIKA_KEMAS = 10;
    public static final Short BILIK_TANGKI_SEDUT1 = 11;
    public static final Short BILIK_TANGKI_SEDUT2 = 12;
    public static final Short BILIK_TX1 = 13;
    public static final Short BILIK_TX2 = 14;
    public static final Short BILIK_UTILITI = 15;
    public static final Short BK16 = 16;
    public static final Short BK17 = 17;
    public static final Short KOPERASI = 18;
    public static final Short PEJABAT_ASRAMA = 19;
    public static final Short PEJABAT_KOPERASI = 20;

    //Ibnusina 1st floor
    public static final Short BK4 = 7;
    public static final Short BK5 = 8;
    public static final Short BK6 = 9;
    public static final Short BK7 = 10;
    public static final Short BK8 = 11;
    public static final Short BK9 = 12;
    public static final Short BK10 = 13;
    public static final Short BK11 = 14;
    public static final Short BILIK_KAUNSELING = 15;
    public static final Short MK1 = 16;
    public static final Short MK2 = 17;
    public static final Short MK3 = 18;
    public static final Short MAKMAL_KAUNSELING = 19;
    public static final Short STUDIO_GRAPHIC = 20;
    public static final Short TOILET_MEN = 21;
    public static final Short TOILET_WOMAN = 22;

    public static final Short PLANE = 1000;
    public static final Short IBNUSINAG_FLOOR = 1001;
    public static final Short IBNUSINAG_WALL = 1002;
    public static final Short IBNUSINA1ST_FLOOR = 1003;
    public static final Short IBNUSINA1ST_WALL = 1004;
    public static final Short BLOCKA_FLOOR = 1005;
    public static final Short BLOCKA_OUTER_WALL = 1006;
    public static final Short BLOCKA_WALL = 1007;

    public ArrayMap<Vector3, String[]> setSearchKey() {
        ArrayMap<Vector3,String[]> searchPosibleValue = new ArrayMap<>(true,1000);
        searchPosibleValue.put(,new String[]{"bk1","bk 1", "bilik kuliah 1"});
        searchPosibleValue.put(BK2,new String[]{"bk2","bk 2", "bilik kuliah 2"});
        searchPosibleValue.put(BK13,new String[]{"bk13","bk 13", "bilik kuliah 13"});
        searchPosibleValue.put(BK14,new String[]{"bk14","bk 14", "bilik kuliah 14"});
        searchPosibleValue.put(LIBRARY,new String[]{"perpustakaan", "library"});
        searchPosibleValue.put(MAKMAL_HALAL,new String[]{"makmal halal", "mkh","makmalhalal"});
        searchPosibleValue.put(PEJABAT_PENTADBIRAN,new String[]{"perpustakaan", "library"});

        searchPosibleValue.put(LIBRARY,new String[]{"perpustakaan", "library"});
        searchPosibleValue.put(LIBRARY,new String[]{"perpustakaan", "library"});

        return searchPosibleValue;
    }

    HashMap<Vector3, String[]> set() {
        HashMap<Vector3, String[]> hm = new HashMap<>(1000,100);
        return hm;

    }

}
