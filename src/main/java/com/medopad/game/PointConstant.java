package com.medopad.game;

import java.util.*;

public class PointConstant {
    public static final String D_PIECE = "D";
    public static final String D_PIECE_LEFT_TOP = "6";
    public static final String D_PIECE_RIGHT_TOP = "7";
    public static final String D_PIECE_LEFT_BOT = "8";
    public static final String D_PIECE_RIGHT_BOT = "9";
    public static final String SINGLE_PIECE = "C";
    public static final String SINGLE_PIECE_2 = "F";
    public static final String SINGLE_PIECE_3 = "G";
    public static final String SINGLE_PIECE_4 = "J";
    public static final Set<String> SINGLE_PIECE_SET = new HashSet<>(Arrays.asList(SINGLE_PIECE, SINGLE_PIECE_2, SINGLE_PIECE_3, SINGLE_PIECE_4));
    public static final String V_PIECE = "A";
    public static final String V_PIECE_2 = "B";
    public static final String V_PIECE_3 = "I";
    public static final String V_PIECE_4 = "H";
    public static final String V_PIECE_AVATAR_1 = "O";
    public static final String V_PIECE_AVATAR_2 = "K";
    public static final String V_PIECE_AVATAR_3 = "M";
    public static final String V_PIECE_AVATAR_4 = "N";
    public static final String HOR_PIECE_LEFT = "E";
    public static final String HOR_PIECE_RIGHT = "L";
    public static final String EXIT_CHARACTER = "Z";
    public static final String BORDER = "X";
    public static final String SPACE = " ";
    public static final Map<String, String> VERTICAL_PIECE = createMap();
    public static final Map<String, String> VERTICAL_BOTTOM_TO_TOP = createVerticalBottomToTopMap();
    public static Set<String> LEGAL_CHARACTERS = new HashSet<>(Arrays.asList(V_PIECE,V_PIECE_2, SINGLE_PIECE,D_PIECE, HOR_PIECE_LEFT, SINGLE_PIECE_2, SINGLE_PIECE_3, V_PIECE_4, V_PIECE_3, SINGLE_PIECE_4, EXIT_CHARACTER, BORDER, SPACE));

    private static Map<String, String> createVerticalBottomToTopMap() {
        Map<String,String> myMap = new HashMap<>();
        myMap.put(V_PIECE_AVATAR_1, V_PIECE);
        myMap.put(V_PIECE_AVATAR_2, V_PIECE_4);
        myMap.put(V_PIECE_AVATAR_3, V_PIECE_2);
        myMap.put(V_PIECE_AVATAR_4, V_PIECE_3);
        return myMap;
    }

    private static Map<String, String> createMap() {
        Map<String,String> myMap = new HashMap<>();
        myMap.put(V_PIECE, V_PIECE_AVATAR_1);
        myMap.put(V_PIECE_4, V_PIECE_AVATAR_2);
        myMap.put(V_PIECE_2, V_PIECE_AVATAR_3);
        myMap.put(V_PIECE_3, V_PIECE_AVATAR_4);
        return myMap;
    }
}
