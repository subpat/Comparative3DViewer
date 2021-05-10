package com.subhadeep.AndroidApp.utils;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * <p> This class defines a number of colors that can be used to set colors to the loaded 3D ThreeDModel. </>
 *
 * <p> Note that these colors are defined and grouped as found on <a href="http://www.tayloredmktg.com/rgb/" target="_blank">tayloredmktg.com</a>. </>

 * @author  Subhadeep Patra
 * @version 1.0
 * @since   2019-01-15
 *
 */
public final class ColorCode implements Serializable {

    /**
     * <p> This variable stores the maximum possible value of the red, green or blue component. </>
     *
     * <p> It is used calculate ratio of actual RGB values to the max possible value. </>
     * <p> This ratio is used by <a href="https://github.com/Kitware/VTK" target="_blank">VTK</a> to display colors. </>
     */
    public static final double RGB_MAX = 255.0;

    /**
     * Default constructor.
     */
    public ColorCode()  {
        //do nothing
    }

    /**
     * <p> This enumerator defines the eight groups, namely whites, grays, blues, greens, yellows, browns, oranges, and pinks.  </>
     * <p> Colors defined in {@link ColorCode.Color} are categorized to one of these eight groups. </>
     *
     */
    public enum ColorGroup {
        /**
         * Colors with dominant white or pastel hues are classified to this group.
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "White" representing the name of this group is returned. </>
         */
        WHITE{
            public String toString() {
                return "White";
            }
        },

        /**
         * Colors with dominant grey hue type are classified to this group.
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Grey" representing the name of this group is returned. </>
         */
        GRAY{
            public String toString() {
                return "Gray";
            }
        },

        /**
         * Colors with dominant blue hue type are classified to this group.
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Blue" representing the name of this group is returned. </>
         */
        BLUE{
            public String toString() {
                return "Blue";
            }
        },

        /**
         * Colors with dominant green hue type are classified to this group.
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Green" representing the name of this group is returned. </>
         */
        GREEN{
            public String toString() {
                return "Green";
            }
        },

        /**
         * Colors with dominant yellow hue type are classified to this group.
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Yellow" representing the name of this group is returned. </>
         */
        YELLOW{
            public String toString() {
                return "Yellow";
            }
        },

        /**
         * Colors with dominant brown hue type are classified to this group.
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Brow" representing the name of this group is returned. </>
         */
        BROWN{
            public String toString() {
                return "Brown";
            }
        },

        /**
         * Colors with dominant orange hue type are classified to this group.
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Orange" representing the name of this group is returned. </>
         */
        ORANGE{
            public String toString() {
                return "Orange";
            }
        },

        /**
         * Colors with dominant pinks or violets hues are classified to this group.
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Pink" representing the name of this group is returned. </>
         */
        PINK{
            public String toString() {
                return "Pink";
            }
        };
    }




    /**
     * This enumerator defines the various well known colors.
     *
     */
    public enum Color {


        /**
         * <p>R: 255 &nbsp; &nbsp; &nbsp; G: 250 &nbsp; &nbsp; &nbsp; B: 250 &nbsp; &nbsp; &nbsp; HEX: fffafa
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#WHITE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#fffafa"><b><center> Snow </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Snow" is returned. </>
         */
        SNOW (255,250,250, "fffafa", ColorGroup.WHITE){
            public String toString() {
                return "Snow";
            }
        },
        /**
         * <p>R: 248 &nbsp; &nbsp; &nbsp; G: 248 &nbsp; &nbsp; &nbsp; B: 255 &nbsp; &nbsp; &nbsp; HEX: f8f8ff
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#WHITE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#f8f8ff"><b><center> GhostWhite </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "GhostWhite" is returned. </>
         */
        GHOSTWHITE (248,248,255, "f8f8ff", ColorGroup.WHITE){
            public String toString() {
                return "GhostWhite";
            }
        },
        /**
         * <p>R: 245 &nbsp; &nbsp; &nbsp; G: 245 &nbsp; &nbsp; &nbsp; B: 245 &nbsp; &nbsp; &nbsp; HEX: f5f5f5
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#WHITE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#f5f5f5"><b><center> SmokeWhite </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "SmokeWhite" is returned. </>
         */
        SMOKEWHITE (245,245,245, "f5f5f5", ColorGroup.WHITE){
            public String toString() {
                return "SmokeWhite";
            }
        },
        /**
         * <p>R: 220 &nbsp; &nbsp; &nbsp; G: 220 &nbsp; &nbsp; &nbsp; B: 220 &nbsp; &nbsp; &nbsp; HEX: dccdc
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#WHITE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#dccdc"><b><center> Gainsboro </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Gainsboro" is returned. </>
         */
        GAINSBORO (220,220,220, "dccdc", ColorGroup.WHITE){
            public String toString() {
                return "Gainsboro";
            }
        },
        /**
         * <p>R: 255 &nbsp; &nbsp; &nbsp; G: 250 &nbsp; &nbsp; &nbsp; B: 240 &nbsp; &nbsp; &nbsp; HEX: fffaf0
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#WHITE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#fffaf0"><b><center> FloralWhite </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "FloralWhite" is returned. </>
         */
        FLORALWHITE (255,250,240, "fffaf0", ColorGroup.WHITE){
            public String toString() {
                return "FloralWhite";
            }
        },
        /**
         * <p>R: 253 &nbsp; &nbsp; &nbsp; G: 245 &nbsp; &nbsp; &nbsp; B: 230 &nbsp; &nbsp; &nbsp; HEX: fdf5e6
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#WHITE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#fdf5e6"><b><center> OldLace </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "OldLace" is returned. </>
         */
        OLDLACE (253,245,230, "fdf5e6", ColorGroup.WHITE){
            public String toString() {
                return "OldLace";
            }
        },
        /**
         * <p>R: 240 &nbsp; &nbsp; &nbsp; G: 240 &nbsp; &nbsp; &nbsp; B: 230 &nbsp; &nbsp; &nbsp; HEX: faf0e6
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#WHITE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#faf0e6"><b><center> Linen </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Linen" is returned. </>
         */
        LINEN (240,240,230, "faf0e6", ColorGroup.WHITE){
            public String toString() {
                return "Linen";
            }
        },
        /**
         * <p>R: 250 &nbsp; &nbsp; &nbsp; G: 235 &nbsp; &nbsp; &nbsp; B: 215 &nbsp; &nbsp; &nbsp; HEX: faebd7
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#WHITE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#faebd7"><b><center> AntiqueWhite </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "AntiqueWhite" is returned. </>
         */
        ANTIQUEWHITE (250,235,215, "faebd7", ColorGroup.WHITE){
            public String toString() {
                return "AntiqueWhite";
            }
        },
        /**
         * <p>R: 255 &nbsp; &nbsp; &nbsp; G: 239 &nbsp; &nbsp; &nbsp; B: 213 &nbsp; &nbsp; &nbsp; HEX: ffefd5
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#WHITE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#ffefd5"><b><center> PapayaWhip </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "PapayaWhip" is returned. </>
         */
        PAPAYAWHIP (255,239,213, "ffefd5", ColorGroup.WHITE){
            public String toString() {
                return "PapayaWhip";
            }
        },
        /**
         * <p>R: 255 &nbsp; &nbsp; &nbsp; G: 235 &nbsp; &nbsp; &nbsp; B: 205 &nbsp; &nbsp; &nbsp; HEX: ffebcd
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#WHITE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#ffebcd"><b><center> BlanchedAlmond </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "BlanchedAlmond" is returned. </>
         */
        BLANCHEDALMOND (255,235,205, "ffebcd", ColorGroup.WHITE){
            public String toString() {
                return "BlanchedAlmond";
            }
        },
        /**
         * <p>R: 255 &nbsp; &nbsp; &nbsp; G: 228 &nbsp; &nbsp; &nbsp; B: 196 &nbsp; &nbsp; &nbsp; HEX: ffe4c4
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#WHITE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#ffe4c4"><b><center> Bisque </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Bisque" is returned. </>
         */
        BISQUE (255,228,196, "ffe4c4", ColorGroup.WHITE){
            public String toString() {
                return "Bisque";
            }
        },
        /**
         * <p>R: 255 &nbsp; &nbsp; &nbsp; G: 218 &nbsp; &nbsp; &nbsp; B: 185 &nbsp; &nbsp; &nbsp; HEX: ffdab9
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#WHITE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#ffdab9"><b><center> PeachPuff </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "PeachPuff" is returned. </>
         */
        PEACHPUFF (255,218,185, "ffdab9", ColorGroup.WHITE){
            public String toString() {
                return "PeachPuff";
            }
        },
        /**
         * <p>R: 255 &nbsp; &nbsp; &nbsp; G: 222 &nbsp; &nbsp; &nbsp; B: 173 &nbsp; &nbsp; &nbsp; HEX: ffdead
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#WHITE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#ffdead"><b><center> NavajoWhite </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "NavajoWhite" is returned. </>
         */
        NAVAJOWHITE (255,222,173, "ffdead", ColorGroup.WHITE){
            public String toString() {
                return "NavajoWhite";
            }
        },
        /**
         * <p>R: 255 &nbsp; &nbsp; &nbsp; G: 228 &nbsp; &nbsp; &nbsp; B: 181 &nbsp; &nbsp; &nbsp; HEX: ffe4b5
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#WHITE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#ffe4b5"><b><center> Moccasin </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Moccasin" is returned. </>
         */
        MOCCASIN (255,228,181, "ffe4b5", ColorGroup.WHITE){
            public String toString() {
                return "Moccasin";
            }
        },
        /**
         * <p>R: 255 &nbsp; &nbsp; &nbsp; G: 248 &nbsp; &nbsp; &nbsp; B: 220 &nbsp; &nbsp; &nbsp; HEX: fff8dc
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#WHITE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#fff8dc"><b><center> Cornsilk </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Cornsilk" is returned. </>
         */
        CORNSILK (255,248,220, "fff8dc", ColorGroup.WHITE){
            public String toString() {
                return "Cornsilk";
            }
        },
        /**
         * <p>R: 255 &nbsp; &nbsp; &nbsp; G: 255 &nbsp; &nbsp; &nbsp; B: 240 &nbsp; &nbsp; &nbsp; HEX: fffff0
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#WHITE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#fffff0"><b><center> Ivory </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Ivory" is returned. </>
         */
        IVORY (255,255,240, "fffff0", ColorGroup.WHITE){
            public String toString() {
                return "Ivory";
            }
        },
        /**
         * <p>R: 255 &nbsp; &nbsp; &nbsp; G: 250 &nbsp; &nbsp; &nbsp; B: 205 &nbsp; &nbsp; &nbsp; HEX: fffacd
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#WHITE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#fffacd"><b><center> LemonChiffon </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "LemonChiffon" is returned. </>
         */
        LEMONCHIFFON (255,250,205, "fffacd", ColorGroup.WHITE){
            public String toString() {
                return "LemonChiffon";
            }
        },
        /**
         * <p>R: 255 &nbsp; &nbsp; &nbsp; G: 245 &nbsp; &nbsp; &nbsp; B: 238 &nbsp; &nbsp; &nbsp; HEX: fff5ee
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#WHITE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#fff5ee"><b><center> Seashell </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Seashell" is returned. </>
         */
        SEASHELL (255,245,238, "fff5ee", ColorGroup.WHITE){
            public String toString() {
                return "Seashell";
            }
        },
        /**
         * <p>R: 240 &nbsp; &nbsp; &nbsp; G: 255 &nbsp; &nbsp; &nbsp; B: 240 &nbsp; &nbsp; &nbsp; HEX: f0fff0
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#WHITE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#f0fff0"><b><center> Honeydew </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Honeydew" is returned. </>
         */
        HONEYDEW (240,255,240, "f0fff0", ColorGroup.WHITE){
            public String toString() {
                return "Honeydew";
            }
        },
        /**
         * <p>R: 245 &nbsp; &nbsp; &nbsp; G: 255 &nbsp; &nbsp; &nbsp; B: 250 &nbsp; &nbsp; &nbsp; HEX: f5fffa
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#WHITE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#f5fffa"><b><center> MintCream </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "MintCream" is returned. </>
         */
        MINTCREAM (245,255,250, "f5fffa", ColorGroup.WHITE){
            public String toString() {
                return "MintCream";
            }
        },
        /**
         * <p>R: 240 &nbsp; &nbsp; &nbsp; G: 255 &nbsp; &nbsp; &nbsp; B: 255 &nbsp; &nbsp; &nbsp; HEX: f0ffff
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#WHITE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#f0ffff"><b><center> Azure </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Azure" is returned. </>
         */
        AZURE (240,255,255, "f0ffff", ColorGroup.WHITE){
            public String toString() {
                return "Azure";
            }
        },
        /**
         * <p>R: 240 &nbsp; &nbsp; &nbsp; G: 248 &nbsp; &nbsp; &nbsp; B: 255 &nbsp; &nbsp; &nbsp; HEX: f0f8ff
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#WHITE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#f0f8ff"><b><center> AliceBlue </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "AliceBlue" is returned. </>
         */
        ALICEBLUE (240,248,255, "f0f8ff", ColorGroup.WHITE){
            public String toString() {
                return "AliceBlue";
            }
        },
        /**
         * <p>R: 230 &nbsp; &nbsp; &nbsp; G: 230 &nbsp; &nbsp; &nbsp; B: 250 &nbsp; &nbsp; &nbsp; HEX: e6e6fa
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#WHITE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#e6e6fa"><b><center> Lavender </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Lavender" is returned. </>
         */
        LAVENDER (230,230,250, "e6e6fa", ColorGroup.WHITE){
            public String toString() {
                return "Lavender";
            }
        },
        /**
         * <p>R: 255 &nbsp; &nbsp; &nbsp; G: 240 &nbsp; &nbsp; &nbsp; B: 245 &nbsp; &nbsp; &nbsp; HEX: fff0f5
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#WHITE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#fff0f5"><b><center> LavenderBlush </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "LavenderBlush" is returned. </>
         */
        LAVENDERBLUSH (255,240,245, "fff0f5", ColorGroup.WHITE){
            public String toString() {
                return "LavenderBlush";
            }
        },
        /**
         * <p>R: 255 &nbsp; &nbsp; &nbsp; G: 228 &nbsp; &nbsp; &nbsp; B: 225 &nbsp; &nbsp; &nbsp; HEX: ffe4e1
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#WHITE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#ffe4e1"><b><center> MistyRose </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "MistyRose" is returned. </>
         */
        MISTYROSE (255,228,225, "ffe4e1", ColorGroup.WHITE){
            public String toString() {
                return "MistyRose";
            }
        },
        /**
         * <p>R: 255 &nbsp; &nbsp; &nbsp; G: 255 &nbsp; &nbsp; &nbsp; B: 255 &nbsp; &nbsp; &nbsp; HEX: ffffff
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#WHITE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#ffffff"><b><center> White </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "White" is returned. </>
         */
        WHITE (255,255,255, "ffffff", ColorGroup.WHITE){
            public String toString() {
                return "White";
            }
        },




        /**
         * <p>R: 0 &nbsp; &nbsp; &nbsp; G: 0 &nbsp; &nbsp; &nbsp; B: 0 &nbsp; &nbsp; &nbsp; HEX: 000000
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#GRAY}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#000000"><font color="white"><b><center> Black </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Black" is returned. </>
         */
        BLACK (0,0,0, "000000", ColorGroup.GRAY){
            public String toString() {
                return "Black";
            }
        },
        /**
         * <p>R: 49 &nbsp; &nbsp; &nbsp; G: 79 &nbsp; &nbsp; &nbsp; B: 79 &nbsp; &nbsp; &nbsp; HEX: 2f4f4f
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#GRAY}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#2f4f4f"><font color="white"><b><center> DarkSlateGray </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "DarkSlateGray" is returned. </>
         */
        DARKSLATEGRAY (49,79,79, "2f4f4f", ColorGroup.GRAY){
            public String toString() {
                return "DarkSlateGray";
            }
        },
        /**
         * <p>R: 105 &nbsp; &nbsp; &nbsp; G: 105 &nbsp; &nbsp; &nbsp; B: 105 &nbsp; &nbsp; &nbsp; HEX: 696969
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#GRAY}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#696969"><font color="white"><b><center> DimGray </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "DimGray" is returned. </>
         */
        DIMGRAY (105,105,105, "696969", ColorGroup.GRAY){
            public String toString() {
                return "DimGray";
            }
        },
        /**
         * <p>R: 112 &nbsp; &nbsp; &nbsp; G: 138 &nbsp; &nbsp; &nbsp; B: 144 &nbsp; &nbsp; &nbsp; HEX: 708090
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#GRAY}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#708090"><font color="white"><b><center> SlateGray </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "SlateGray" is returned. </>
         */
        SLATEGRAY (112,138,144, "708090", ColorGroup.GRAY){
            public String toString() {
                return "SlateGray";
            }
        },
        /**
         * <p>R: 119 &nbsp; &nbsp; &nbsp; G: 136 &nbsp; &nbsp; &nbsp; B: 153 &nbsp; &nbsp; &nbsp; HEX: 778899
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#GRAY}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#778899"><font color="white"><b><center> LightSlateGray </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "LightSlateGray" is returned. </>
         */
        LIGHTSLATEGRAY (119,136,153, "778899", ColorGroup.GRAY){
            public String toString() {
                return "LightSlateGray";
            }
        },
        /**
         * <p>R: 190 &nbsp; &nbsp; &nbsp; G: 190 &nbsp; &nbsp; &nbsp; B: 190 &nbsp; &nbsp; &nbsp; HEX: bebebe
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#GRAY}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#bebebe"><b><center> Gray </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Gray" is returned. </>
         */
        GRAY (190,190,190, "bebebe", ColorGroup.GRAY){
            public String toString() {
                return "Gray";
            }
        },
        /**
         * <p>R: 211 &nbsp; &nbsp; &nbsp; G: 211 &nbsp; &nbsp; &nbsp; B: 211 &nbsp; &nbsp; &nbsp; HEX: d3d3d3
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#GRAY}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#d3d3d3"><b><center> LightGray </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "LightGray" is returned. </>
         */
        LIGHTGRAY (211,211,211, "d3d3d3", ColorGroup.GRAY){
            public String toString() {
                return "LightGray";
            }
        },





        /**
         * <p>R: 25 &nbsp; &nbsp; &nbsp; G: 25 &nbsp; &nbsp; &nbsp; B: 112 &nbsp; &nbsp; &nbsp; HEX: 191970
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BLUE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#191970"><font color="white"><b><center> MidnightBlue </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "MidnightBlue" is returned. </>
         */
        MIDNIGHTBLUE (25,25,112, "191970", ColorGroup.BLUE){
            public String toString() {
                return "MidnightBlue";
            }
        },
        /**
         * <p>R: 0 &nbsp; &nbsp; &nbsp; G: 0 &nbsp; &nbsp; &nbsp; B: 128 &nbsp; &nbsp; &nbsp; HEX: 000080
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BLUE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#000080"><font color="white"><b><center> Navy </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Navy" is returned. </>
         */
        NAVY (0,0,128, "000080", ColorGroup.BLUE){
            public String toString() {
                return "Navy";
            }
        },
        /**
         * <p>R: 100 &nbsp; &nbsp; &nbsp; G: 149 &nbsp; &nbsp; &nbsp; B: 237 &nbsp; &nbsp; &nbsp; HEX: 6495ed
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BLUE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#6495ed"><font color="white"><b><center> CornflowerBlue </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "CornflowerBlue" is returned. </>
         */
        CORNFLOWERBLUE (100,149,237, "6495ed", ColorGroup.BLUE){
            public String toString() {
                return "CornflowerBlue";
            }
        },
        /**
         * <p>R: 72 &nbsp; &nbsp; &nbsp; G: 61 &nbsp; &nbsp; &nbsp; B: 139 &nbsp; &nbsp; &nbsp; HEX: 483d8b
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BLUE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#483d8b"><font color="white"><b><center> DarkSlateBlue </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "DarkSlateBlue" is returned. </>
         */
        DARKSLATEBLUE (72,61,139, "483d8b", ColorGroup.BLUE){
            public String toString() {
                return "DarkSlateBlue";
            }
        },
        /**
         * <p>R: 106 &nbsp; &nbsp; &nbsp; G: 90 &nbsp; &nbsp; &nbsp; B: 205 &nbsp; &nbsp; &nbsp; HEX: 6a5acd
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BLUE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#6a5acd"><font color="white"><b><center> SlateBlue </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "SlateBlue" is returned. </>
         */
        SLATEBLUE (106,90,205, "6a5acd", ColorGroup.BLUE){
            public String toString() {
                return "SlateBlue";
            }
        },
        /**
         * <p>R: 123 &nbsp; &nbsp; &nbsp; G: 104 &nbsp; &nbsp; &nbsp; B: 238 &nbsp; &nbsp; &nbsp; HEX: 7b68ee
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BLUE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#7b68ee"><font color="white"><b><center> MediumSlateBlue </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "MediumSlateBlue" is returned. </>
         */
        MEDIUMSLATEBLUE (123,104,238, "7b68ee", ColorGroup.BLUE){
            public String toString() {
                return "MediumSlateBlue";
            }
        },
        /**
         * <p>R: 132 &nbsp; &nbsp; &nbsp; G: 112 &nbsp; &nbsp; &nbsp; B: 255 &nbsp; &nbsp; &nbsp; HEX: 8470ff
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BLUE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#8470ff"><font color="white"><b><center> LightSlateBlue </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "LightSlateBlue" is returned. </>
         */
        LIGHTSLATEBLUE (132,112,255, "8470ff", ColorGroup.BLUE){
            public String toString() {
                return "LightSlateBlue";
            }
        },
        /**
         * <p>R: 0 &nbsp; &nbsp; &nbsp; G: 0 &nbsp; &nbsp; &nbsp; B: 205 &nbsp; &nbsp; &nbsp; HEX: 0000cd
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BLUE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#0000cd"><font color="white"><b><center> MediumBlue </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "MediumBlue" is returned. </>
         */
        MEDIUMBLUE (0,0,205, "0000cd", ColorGroup.BLUE){
            public String toString() {
                return "MediumBlue";
            }
        },
        /**
         * <p>R: 65 &nbsp; &nbsp; &nbsp; G: 105 &nbsp; &nbsp; &nbsp; B: 225 &nbsp; &nbsp; &nbsp; HEX: 4169e1
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BLUE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#4169e1"><font color="white"><b><center> RoyalBlue </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "RoyalBlue" is returned. </>
         */
        ROYALBLUE (65,105,225, "4169e1", ColorGroup.BLUE){
            public String toString() {
                return "RoyalBlue";
            }
        },
        /**
         * <p>R: 0 &nbsp; &nbsp; &nbsp; G: 0 &nbsp; &nbsp; &nbsp; B: 255 &nbsp; &nbsp; &nbsp; HEX: 0000ff
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BLUE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#0000ff"><font color="white"><b><center> Blue </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Blue" is returned. </>
         */
        BLUE (0,0,255, "0000ff", ColorGroup.BLUE){
            public String toString() {
                return "Blue";
            }
        },
        /**
         * <p>R: 30 &nbsp; &nbsp; &nbsp; G: 144 &nbsp; &nbsp; &nbsp; B: 255 &nbsp; &nbsp; &nbsp; HEX: 1e90ff
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BLUE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#1e90ff"><font color="white"><b><center> DodgerBlue </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "DodgerBlue" is returned. </>
         */
        DODGERBLUE (30,144,255, "1e90ff", ColorGroup.BLUE){
            public String toString() {
                return "DodgerBlue";
            }
        },
        /**
         * <p>R: 0 &nbsp; &nbsp; &nbsp; G: 191 &nbsp; &nbsp; &nbsp; B: 255 &nbsp; &nbsp; &nbsp; HEX: 00bfff
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BLUE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#00bfff"><font color="white"><b><center> DeepSkyBlue </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "DeepSkyBlue" is returned. </>
         */
        DEEPSKYBLUE (0,191,255, "00bfff", ColorGroup.BLUE){
            public String toString() {
                return "DeepSkyBlue";
            }
        },
        /**
         * <p>R: 135 &nbsp; &nbsp; &nbsp; G: 206 &nbsp; &nbsp; &nbsp; B: 235 &nbsp; &nbsp; &nbsp; HEX: 87ceeb
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BLUE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#87ceeb"><b><center> SkyBlue </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "SkyBlue" is returned. </>
         */
        SKYBLUE (135,206,235, "87ceeb", ColorGroup.BLUE){
            public String toString() {
                return "SkyBlue";
            }
        },
        /**
         * <p>R: 135 &nbsp; &nbsp; &nbsp; G: 206 &nbsp; &nbsp; &nbsp; B: 250 &nbsp; &nbsp; &nbsp; HEX: 87cefa
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BLUE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#87cefa"><b><center> LightSkyBlue </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "LightSkyBlue" is returned. </>
         */
        LIGHTSKYBLUE (135,206,250, "87cefa", ColorGroup.BLUE){
            public String toString() {
                return "LightSkyBlue";
            }
        },
        /**
         * <p>R: 70 &nbsp; &nbsp; &nbsp; G: 130 &nbsp; &nbsp; &nbsp; B: 180 &nbsp; &nbsp; &nbsp; HEX: 4682b4
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BLUE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#4682b4"><font color="white"><b><center> SteelBlue </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "SteelBlue" is returned. </>
         */
        STEELBLUE (70,130,180, "4682b4", ColorGroup.BLUE){
            public String toString() {
                return "SteelBlue";
            }
        },
        /**
         * <p>R: 176 &nbsp; &nbsp; &nbsp; G: 196 &nbsp; &nbsp; &nbsp; B: 222 &nbsp; &nbsp; &nbsp; HEX: b0c4de
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BLUE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#b0c4de"><b><center> LightSteelBlue </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "LightSteelBlue" is returned. </>
         */
        LIGHTSTEELBLUE (176,196,222, "b0c4de", ColorGroup.BLUE){
            public String toString() {
                return "LightSteelBlue";
            }
        },
        /**
         * <p>R: 173 &nbsp; &nbsp; &nbsp; G: 216 &nbsp; &nbsp; &nbsp; B: 230 &nbsp; &nbsp; &nbsp; HEX: add8e6
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BLUE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#add8e6"><b><center> LightBlue </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "LightBlue" is returned. </>
         */
        LIGHTBLUE (173,216,230, "add8e6", ColorGroup.BLUE){
            public String toString() {
                return "LightBlue";
            }
        },
        /**
         * <p>R: 176 &nbsp; &nbsp; &nbsp; G: 224 &nbsp; &nbsp; &nbsp; B: 230 &nbsp; &nbsp; &nbsp; HEX: b0e0e6
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BLUE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#b0e0e6"><b><center> PowderBlue </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "PowderBlue" is returned. </>
         */
        POWDERBLUE (176,224,230, "b0e0e6", ColorGroup.BLUE){
            public String toString() {
                return "PowderBlue";
            }
        },
        /**
         * <p>R: 175 &nbsp; &nbsp; &nbsp; G: 238 &nbsp; &nbsp; &nbsp; B: 238 &nbsp; &nbsp; &nbsp; HEX: afeeee
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BLUE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#afeeee"><b><center> PaleTurquoise </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "PaleTurquoise" is returned. </>
         */
        PALETURQUOISE (175,238,238, "afeeee", ColorGroup.BLUE){
            public String toString() {
                return "PaleTurquoise";
            }
        },
        /**
         * <p>R: 0 &nbsp; &nbsp; &nbsp; G: 206 &nbsp; &nbsp; &nbsp; B: 209 &nbsp; &nbsp; &nbsp; HEX: 00ced1
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BLUE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#00ced1"><b><center> DarkTurquoise </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "DarkTurquoise" is returned. </>
         */
        DARKTURQUOISE (0,206,209, "00ced1", ColorGroup.BLUE){
            public String toString() {
                return "DarkTurquoise";
            }
        },
        /**
         * <p>R: 72 &nbsp; &nbsp; &nbsp; G: 209 &nbsp; &nbsp; &nbsp; B: 204 &nbsp; &nbsp; &nbsp; HEX: 48d1cc
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BLUE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#48d1cc"><b><center> MediumTurquoise </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "MediumTurquoise" is returned. </>
         */
        MEDIUMTURQUOISE (72,209,204, "48d1cc", ColorGroup.BLUE){
            public String toString() {
                return "MediumTurquoise";
            }
        },
        /**
         * <p>R: 64 &nbsp; &nbsp; &nbsp; G: 224 &nbsp; &nbsp; &nbsp; B: 208 &nbsp; &nbsp; &nbsp; HEX: 40e0d0
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BLUE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#40e0d0"><b><center> Turquoise </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Turquoise" is returned. </>
         */
        TURQUOISE (64,224,208, "40e0d0", ColorGroup.BLUE){
            public String toString() {
                return "Turquoise";
            }
        },
        /**
         * <p>R: 0 &nbsp; &nbsp; &nbsp; G: 255 &nbsp; &nbsp; &nbsp; B: 255 &nbsp; &nbsp; &nbsp; HEX: 00ffff
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BLUE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#00ffff"><b><center> Cyan </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Cyan" is returned. </>
         */
        CYAN (0,255,255, "00ffff", ColorGroup.BLUE){
            public String toString() {
                return "Cyan";
            }
        },
        /**
         * <p>R: 224 &nbsp; &nbsp; &nbsp; G: 255 &nbsp; &nbsp; &nbsp; B: 255 &nbsp; &nbsp; &nbsp; HEX: e0ffff
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BLUE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#e0ffff"><b><center> LightCyan </center></b></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "LightCyan" is returned. </>
         */
        LIGHTCYAN (224,255,255, "e0ffff", ColorGroup.BLUE){
            public String toString() {
                return "LightCyan";
            }
        },
        /**
         * <p>R: 95 &nbsp; &nbsp; &nbsp; G: 158 &nbsp; &nbsp; &nbsp; B: 160 &nbsp; &nbsp; &nbsp; HEX: 5f9ea0
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BLUE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#5f9ea0"><font color="white"></><b><center> CadetBlue </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "CadetBlue" is returned. </>
         */
        CADETBLUE (95,158,160, "5f9ea0", ColorGroup.BLUE){
            public String toString() {
                return "CadetBlue";
            }
        },






        /**
         * <p>R: 102 &nbsp; &nbsp; &nbsp; G: 205 &nbsp; &nbsp; &nbsp; B: 170 &nbsp; &nbsp; &nbsp; HEX: 66cdaa
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#GREEN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#66cdaa"><font color="black"></><b><center> MediumAquamarine </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "MediumAquamarine" is returned. </>
         */
        MEDIUMAQUAMARINE (102,205,170, "66cdaa", ColorGroup.GREEN){
            public String toString() {
                return "MediumAquamarine";
            }
        },
        /**
         * <p>R: 127 &nbsp; &nbsp; &nbsp; G: 255 &nbsp; &nbsp; &nbsp; B: 212 &nbsp; &nbsp; &nbsp; HEX: 7fffd4
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#GREEN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#7fffd4"><font color="black"></><b><center> Aquamarine </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Aquamarine" is returned. </>
         */
        AQUAMARINE (127,255,212, "7fffd4", ColorGroup.GREEN){
            public String toString() {
                return "Aquamarine";
            }
        },
        /**
         * <p>R: 0 &nbsp; &nbsp; &nbsp; G: 100 &nbsp; &nbsp; &nbsp; B: 0 &nbsp; &nbsp; &nbsp; HEX: 006400
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#GREEN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#006400"><font color="white"></><b><center> DarkGreen </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "DarkGreen" is returned. </>
         */
        DARKGREEN (0,100,0, "006400", ColorGroup.GREEN){
            public String toString() {
                return "DarkGreen";
            }
        },
        /**
         * <p>R: 85 &nbsp; &nbsp; &nbsp; G: 107 &nbsp; &nbsp; &nbsp; B: 47 &nbsp; &nbsp; &nbsp; HEX: 556b2f
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#GREEN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#556b2f"><font color="white"></><b><center> DarkOliveGreen </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "DarkOliveGreen" is returned. </>
         */
        DARKOLIVEGREEN (85,107,47, "556b2f", ColorGroup.GREEN){
            public String toString() {
                return "DarkOliveGreen";
            }
        },
        /**
         * <p>R: 143 &nbsp; &nbsp; &nbsp; G: 188 &nbsp; &nbsp; &nbsp; B: 143 &nbsp; &nbsp; &nbsp; HEX: 8fbc8f
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#GREEN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#8fbc8f"><font color="black"></><b><center> DarkSeaGreen </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "DarkSeaGreen" is returned. </>
         */
        DARKSEAGREEN (143,188,143, "8fbc8f", ColorGroup.GREEN){
            public String toString() {
                return "DarkSeaGreen";
            }
        },
        /**
         * <p>R: 46 &nbsp; &nbsp; &nbsp; G: 139 &nbsp; &nbsp; &nbsp; B: 87 &nbsp; &nbsp; &nbsp; HEX: 2e8b57
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#GREEN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#2e8b57"><font color="black"></><b><center> SeaGreen </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "SeaGreen" is returned. </>
         */
        SEAGREEN (46,139,87, "2e8b57", ColorGroup.GREEN){
            public String toString() {
                return "SeaGreen";
            }
        },
        /**
         * <p>R: 60 &nbsp; &nbsp; &nbsp; G: 179 &nbsp; &nbsp; &nbsp; B: 113 &nbsp; &nbsp; &nbsp; HEX: 3cb371
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#GREEN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#3cb371"><font color="black"></><b><center> MediumSeaGreen </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "MediumSeaGreen" is returned. </>
         */
        MEDIUMSEAGREEN (60,179,113, "3cb371", ColorGroup.GREEN){
            public String toString() {
                return "MediumSeaGreen";
            }
        },
        /**
         * <p>R: 32 &nbsp; &nbsp; &nbsp; G: 178 &nbsp; &nbsp; &nbsp; B: 170 &nbsp; &nbsp; &nbsp; HEX: 20b2aa
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#GREEN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#20b2aa"><font color="black"></><b><center> LightSeaGreen </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "LightSeaGreen" is returned. </>
         */
        LIGHTSEAGREEN (32,178,170, "20b2aa", ColorGroup.GREEN){
            public String toString() {
                return "LightSeaGreen";
            }
        },
        /**
         * <p>R: 152 &nbsp; &nbsp; &nbsp; G: 251 &nbsp; &nbsp; &nbsp; B: 152 &nbsp; &nbsp; &nbsp; HEX: 98fb98
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#GREEN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#98fb98"><font color="black"></><b><center> PaleGreen </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "PaleGreen" is returned. </>
         */
        PALEGREEN (152,251,152, "98fb98", ColorGroup.GREEN){
            public String toString() {
                return "PaleGreen";
            }
        },
        /**
         * <p>R: 0 &nbsp; &nbsp; &nbsp; G: 255 &nbsp; &nbsp; &nbsp; B: 127 &nbsp; &nbsp; &nbsp; HEX: 00ff7f
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#GREEN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#00ff7f"><font color="black"></><b><center> SpringGreen </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "SpringGreen" is returned. </>
         */
        SPRINGGREEN (0,255,127, "00ff7f", ColorGroup.GREEN){
            public String toString() {
                return "SpringGreen";
            }
        },
        /**
         * <p>R: 124 &nbsp; &nbsp; &nbsp; G: 252 &nbsp; &nbsp; &nbsp; B: 0 &nbsp; &nbsp; &nbsp; HEX: 7cfc00
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#GREEN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#7cfc00"><font color="black"></><b><center> LawnGreen </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "LawnGreen" is returned. </>
         */
        LAWNGREEN (124,252,0, "7cfc00", ColorGroup.GREEN){
            public String toString() {
                return "LawnGreen";
            }
        },
        /**
         * <p>R: 127 &nbsp; &nbsp; &nbsp; G: 255 &nbsp; &nbsp; &nbsp; B: 0 &nbsp; &nbsp; &nbsp; HEX: 7fff00
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#GREEN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#7fff00"><font color="black"></><b><center> Chartreuse </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Chartreuse" is returned. </>
         */
        CHARTREUSE (127,255,0, "7fff00", ColorGroup.GREEN){
            public String toString() {
                return "Chartreuse";
            }
        },
        /**
         * <p>R: 0 &nbsp; &nbsp; &nbsp; G: 250 &nbsp; &nbsp; &nbsp; B: 154 &nbsp; &nbsp; &nbsp; HEX: 00fa9a
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#GREEN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#00fa9a"><font color="black"></><b><center> MediumSpringGreen </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "MediumSpringGreen" is returned. </>
         */
        MEDIUMSPRINGGREEN (0,250,154, "00fa9a", ColorGroup.GREEN){
            public String toString() {
                return "MediumSpringGreen";
            }
        },
        /**
         * <p>R: 173 &nbsp; &nbsp; &nbsp; G: 255 &nbsp; &nbsp; &nbsp; B: 47 &nbsp; &nbsp; &nbsp; HEX: adff2f
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#GREEN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#adff2f"><font color="black"></><b><center> GreenYellow </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "GreenYellow" is returned. </>
         */
        GREENYELLOW (173,255,47, "adff2f", ColorGroup.GREEN){
            public String toString() {
                return "GreenYellow";
            }
        },
        /**
         * <p>R: 50 &nbsp; &nbsp; &nbsp; G: 205 &nbsp; &nbsp; &nbsp; B: 50 &nbsp; &nbsp; &nbsp; HEX: 32cd32
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#GREEN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#32cd32"><font color="black"></><b><center> LimeGreen </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "LimeGreen" is returned. </>
         */
        LIMEGREEN (50,205,50, "32cd32", ColorGroup.GREEN){
            public String toString() {
                return "LimeGreen";
            }
        },
        /**
         * <p>R: 154 &nbsp; &nbsp; &nbsp; G: 205 &nbsp; &nbsp; &nbsp; B: 50 &nbsp; &nbsp; &nbsp; HEX: 9acd32
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#GREEN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#9acd32"><font color="black"></><b><center> YellowGreen </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "YellowGreen" is returned. </>
         */
        YELLOWGREEN (154,205,50, "9acd32", ColorGroup.GREEN){
            public String toString() {
                return "YellowGreen";
            }
        },
        /**
         * <p>R: 34 &nbsp; &nbsp; &nbsp; G: 139 &nbsp; &nbsp; &nbsp; B: 34 &nbsp; &nbsp; &nbsp; HEX: 228b22
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#GREEN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#228b22"><font color="white"></><b><center> ForestGreen </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "ForestGreen" is returned. </>
         */
        FORESTGREEN (34,139,34, "228b22", ColorGroup.GREEN){
            public String toString() {
                return "ForestGreen";
            }
        },
        /**
         * <p>R: 107 &nbsp; &nbsp; &nbsp; G: 142 &nbsp; &nbsp; &nbsp; B: 35 &nbsp; &nbsp; &nbsp; HEX: 6b8e23
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#GREEN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#6b8e23"><font color="white"></><b><center> OliveDrab </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "OliveDrab" is returned. </>
         */
        OLIVEDRAB (107,142,35, "6b8e23", ColorGroup.GREEN){
            public String toString() {
                return "OliveDrab";
            }
        },
        /**
         * <p>R: 189 &nbsp; &nbsp; &nbsp; G: 183 &nbsp; &nbsp; &nbsp; B: 107 &nbsp; &nbsp; &nbsp; HEX: bdb76b
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#GREEN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#bdb76b"><font color="black"></><b><center> DarkKhaki </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "DarkKhaki" is returned. </>
         */
        DARKKHAKI (189,183,107, "bdb76b", ColorGroup.GREEN){
            public String toString() {
                return "DarkKhaki";
            }
        },
        /**
         * <p>R: 240 &nbsp; &nbsp; &nbsp; G: 230 &nbsp; &nbsp; &nbsp; B: 140 &nbsp; &nbsp; &nbsp; HEX: f0e68c
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#GREEN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#f0e68c"><font color="black"></><b><center> Khaki </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Khaki" is returned. </>
         */
        KHAKI (240,230,140, "f0e68c", ColorGroup.GREEN){
            public String toString() {
                return "Khaki";
            }
        },





        /**
         * <p>R: 238 &nbsp; &nbsp; &nbsp; G: 232 &nbsp; &nbsp; &nbsp; B: 170 &nbsp; &nbsp; &nbsp; HEX: eee8aa
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#YELLOW}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#eee8aa"><font color="black"></><b><center> PaleGoldenrod </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "PaleGoldenrod" is returned. </>
         */
        PALEGOLDENROD (238,232,170, "eee8aa", ColorGroup.YELLOW){
            public String toString() {
                return "PaleGoldenrod";
            }
        },
        /**
         * <p>R: 250 &nbsp; &nbsp; &nbsp; G: 250 &nbsp; &nbsp; &nbsp; B: 210 &nbsp; &nbsp; &nbsp; HEX: fafad2
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#YELLOW}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#fafad2"><font color="black"></><b><center> LightGoldenrodYellow </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "LightGoldenrodYellow" is returned. </>
         */
        LIGHTGOLDENRODYELLOW (250,250,210, "fafad2", ColorGroup.YELLOW){
            public String toString() {
                return "LightGoldenrodYellow";
            }
        },
        /**
         * <p>R: 255 &nbsp; &nbsp; &nbsp; G: 255 &nbsp; &nbsp; &nbsp; B: 224 &nbsp; &nbsp; &nbsp; HEX: ffffe0
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#YELLOW}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#ffffe0"><font color="black"></><b><center> LightYellow </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "LightYellow" is returned. </>
         */
        LIGHTYELLOW (255,255,224, "ffffe0", ColorGroup.YELLOW){
            public String toString() {
                return "LightYellow";
            }
        },
        /**
         * <p>R: 255 &nbsp; &nbsp; &nbsp; G: 255 &nbsp; &nbsp; &nbsp; B: 0 &nbsp; &nbsp; &nbsp; HEX: ffff00
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#YELLOW}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#ffff00"><font color="black"></><b><center> Yellow </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Yellow" is returned. </>
         */
        YELLOW (255,255,0, "ffff00", ColorGroup.YELLOW){
            public String toString() {
                return "Yellow";
            }
        },
        /**
         * <p>R: 255 &nbsp; &nbsp; &nbsp; G: 215 &nbsp; &nbsp; &nbsp; B: 0 &nbsp; &nbsp; &nbsp; HEX: ffd700
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#YELLOW}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#ffd700"><font color="black"></><b><center> Gold </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Gold" is returned. </>
         */
        GOLD (255,215,0, "ffd700", ColorGroup.YELLOW){
            public String toString() {
                return "Gold";
            }
        },
        /**
         * <p>R: 238 &nbsp; &nbsp; &nbsp; G: 221 &nbsp; &nbsp; &nbsp; B: 130 &nbsp; &nbsp; &nbsp; HEX: eedd82
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#YELLOW}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#eedd82"><font color="black"></><b><center> LightGoldenrod </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "LightGoldenrod" is returned. </>
         */
        LIGHTGOLDENROD (238,221,130, "eedd82", ColorGroup.YELLOW){
            public String toString() {
                return "LightGoldenrod";
            }
        },
        /**
         * <p>R: 218 &nbsp; &nbsp; &nbsp; G: 165 &nbsp; &nbsp; &nbsp; B: 32 &nbsp; &nbsp; &nbsp; HEX: daa520
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#YELLOW}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#daa520"><font color="black"></><b><center> Goldenrod </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Goldenrod" is returned. </>
         */
        GOLDENROD (218,165,32, "daa520", ColorGroup.YELLOW){
            public String toString() {
                return "Goldenrod";
            }
        },
        /**
         * <p>R: 184 &nbsp; &nbsp; &nbsp; G: 134 &nbsp; &nbsp; &nbsp; B: 11 &nbsp; &nbsp; &nbsp; HEX: b8860b
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#YELLOW}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#b8860b"><font color="black"></><b><center> DarkGoldenrod </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "DarkGoldenrod" is returned. </>
         */
        DARKGOLDENROD (184,134,11, "b8860b", ColorGroup.YELLOW){
            public String toString() {
                return "DarkGoldenrod";
            }
        },






        /**
         * <p>R: 188 &nbsp; &nbsp; &nbsp; G: 143 &nbsp; &nbsp; &nbsp; B: 143 &nbsp; &nbsp; &nbsp; HEX: bc8f8f
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BROWN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#bc8f8f"><font color="black"></><b><center> RosyBrown </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "RosyBrown" is returned. </>
         */
        ROSYBROWN (188,143,143, "bc8f8f", ColorGroup.BROWN){
            public String toString() {
                return "RosyBrown";
            }
        },
        /**
         * <p>R: 205 &nbsp; &nbsp; &nbsp; G: 92 &nbsp; &nbsp; &nbsp; B: 92 &nbsp; &nbsp; &nbsp; HEX: cd5c5c
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BROWN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#cd5c5c"><font color="black"></><b><center> IndianRed </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "IndianRed" is returned. </>
         */
        INDIANRED (205,92,92, "cd5c5c", ColorGroup.BROWN){
            public String toString() {
                return "IndianRed";
            }
        },
        /**
         * <p>R: 139 &nbsp; &nbsp; &nbsp; G: 69 &nbsp; &nbsp; &nbsp; B: 19 &nbsp; &nbsp; &nbsp; HEX: 8b4513
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BROWN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#8b4513"><font color="white"></><b><center> SaddleBrown </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "SaddleBrown" is returned. </>
         */
        SADDLEBROWN (139,69,19, "8b4513", ColorGroup.BROWN){
            public String toString() {
                return "SaddleBrown";
            }
        },
        /**
         * <p>R: 160 &nbsp; &nbsp; &nbsp; G: 82 &nbsp; &nbsp; &nbsp; B: 45 &nbsp; &nbsp; &nbsp; HEX: a0522d
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BROWN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#a0522d"><font color="white"></><b><center> Sienna </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Sienna" is returned. </>
         */
        SIENNA (160,82,45, "a0522d", ColorGroup.BROWN){
            public String toString() {
                return "Sienna";
            }
        },
        /**
         * <p>R: 205 &nbsp; &nbsp; &nbsp; G: 133 &nbsp; &nbsp; &nbsp; B: 63 &nbsp; &nbsp; &nbsp; HEX: cd853f
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BROWN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#cd853f"><font color="black"></><b><center> Peru </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Peru" is returned. </>
         */
        PERU (205,133,63, "cd853f", ColorGroup.BROWN){
            public String toString() {
                return "Peru";
            }
        },
        /**
         * <p>R: 222 &nbsp; &nbsp; &nbsp; G: 184 &nbsp; &nbsp; &nbsp; B: 135 &nbsp; &nbsp; &nbsp; HEX: deb887
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BROWN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#deb887"><font color="black"></><b><center> Burlywood </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Burlywood" is returned. </>
         */
        BURLYWOOD (222,184,135, "deb887", ColorGroup.BROWN){
            public String toString() {
                return "Burlywood";
            }
        },
        /**
         * <p>R: 245 &nbsp; &nbsp; &nbsp; G: 245 &nbsp; &nbsp; &nbsp; B: 220 &nbsp; &nbsp; &nbsp; HEX: f5f5dc
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BROWN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#f5f5dc"><font color="black"></><b><center> Beige </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Beige" is returned. </>
         */
        BEIGE (245,245,220, "f5f5dc", ColorGroup.BROWN){
            public String toString() {
                return "Beige";
            }
        },
        /**
         * <p>R: 245 &nbsp; &nbsp; &nbsp; G: 222 &nbsp; &nbsp; &nbsp; B: 179 &nbsp; &nbsp; &nbsp; HEX: f5deb3
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BROWN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#f5deb3"><font color="black"></><b><center> Wheat </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Wheat" is returned. </>
         */
        WHEAT (245,222,179, "f5deb3", ColorGroup.BROWN){
            public String toString() {
                return "Wheat";
            }
        },
        /**
         * <p>R: 244 &nbsp; &nbsp; &nbsp; G: 164 &nbsp; &nbsp; &nbsp; B: 96 &nbsp; &nbsp; &nbsp; HEX: f4a460
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BROWN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#f4a460"><font color="black"></><b><center> SandyBrown </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "SandyBrown" is returned. </>
         */
        SANDYBROWN (244,164,96, "f4a460", ColorGroup.BROWN){
            public String toString() {
                return "SandyBrown";
            }
        },
        /**
         * <p>R: 210 &nbsp; &nbsp; &nbsp; G: 180 &nbsp; &nbsp; &nbsp; B: 140 &nbsp; &nbsp; &nbsp; HEX: d2b48c
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BROWN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#d2b48c"><font color="black"></><b><center> Tan </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Tan" is returned. </>
         */
        TAN (210,180,140, "d2b48c", ColorGroup.BROWN){
            public String toString() {
                return "Tan";
            }
        },
        /**
         * <p>R: 210 &nbsp; &nbsp; &nbsp; G: 105 &nbsp; &nbsp; &nbsp; B: 30 &nbsp; &nbsp; &nbsp; HEX: d2691e
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BROWN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#d2691e"><font color="black"></><b><center> Chocolate </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Chocolate" is returned. </>
         */
        CHOCOLATE (210,105,30, "d2691e", ColorGroup.BROWN){
            public String toString() {
                return "Chocolate";
            }
        },
        /**
         * <p>R: 178 &nbsp; &nbsp; &nbsp; G: 34 &nbsp; &nbsp; &nbsp; B: 34 &nbsp; &nbsp; &nbsp; HEX: b22222
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BROWN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#b22222"><font color="white"></><b><center> Firebrick </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Firebrick" is returned. </>
         */
        FIREBRICK (178,34,34, "b22222", ColorGroup.BROWN){
            public String toString() {
                return "Firebrick";
            }
        },
        /**
         * <p>R: 165 &nbsp; &nbsp; &nbsp; G: 42 &nbsp; &nbsp; &nbsp; B: 42 &nbsp; &nbsp; &nbsp; HEX: a52a2a
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#BROWN}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#a52a2a"><font color="white"></><b><center> Brown </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Brown" is returned. </>
         */
        BROWN (165,42,42, "a52a2a", ColorGroup.BROWN){
            public String toString() {
                return "Brown";
            }
        },






        /**
         * <p>R: 233 &nbsp; &nbsp; &nbsp; G: 150 &nbsp; &nbsp; &nbsp; B: 122 &nbsp; &nbsp; &nbsp; HEX: e9967a
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#ORANGE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#e9967a"><font color="black"></><b><center> DarkSalmon </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "DarkSalmon" is returned. </>
         */
        DARKSALMON (233,150,122, "e9967a", ColorGroup.ORANGE){
            public String toString() {
                return "DarkSalmon";
            }
        },
        /**
         * <p>R: 250 &nbsp; &nbsp; &nbsp; G: 128 &nbsp; &nbsp; &nbsp; B: 114 &nbsp; &nbsp; &nbsp; HEX: fa8072
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#ORANGE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#fa8072"><font color="black"></><b><center> Salmon </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Salmon" is returned. </>
         */
        SALMON (250,128,114, "fa8072", ColorGroup.ORANGE){
            public String toString() {
                return "Salmon";
            }
        },
        /**
         * <p>R: 255 &nbsp; &nbsp; &nbsp; G: 160 &nbsp; &nbsp; &nbsp; B: 122 &nbsp; &nbsp; &nbsp; HEX: ffa07a
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#ORANGE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#ffa07a"><font color="black"></><b><center> LightSalmon </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "LightSalmon" is returned. </>
         */
        LIGHTSALMON (255,160,122, "ffa07a", ColorGroup.ORANGE){
            public String toString() {
                return "LightSalmon";
            }
        },
        /**
         * <p>R: 255 &nbsp; &nbsp; &nbsp; G: 165 &nbsp; &nbsp; &nbsp; B: 0 &nbsp; &nbsp; &nbsp; HEX: ffa500
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#ORANGE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#ffa500"><font color="black"></><b><center> Orange </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Orange" is returned. </>
         */
        ORANGE (255,165,0, "ffa500", ColorGroup.ORANGE){
            public String toString() {
                return "Orange";
            }
        },
        /**
         * <p>R: 255 &nbsp; &nbsp; &nbsp; G: 140 &nbsp; &nbsp; &nbsp; B: 0 &nbsp; &nbsp; &nbsp; HEX: ff8c00
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#ORANGE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#ff8c00"><font color="black"></><b><center> DarkOrange </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "DarkOrange" is returned. </>
         */
        DARKORANGE (255,140,0, "ff8c00", ColorGroup.ORANGE){
            public String toString() {
                return "DarkOrange";
            }
        },
        /**
         * <p>R: 255 &nbsp; &nbsp; &nbsp; G: 127 &nbsp; &nbsp; &nbsp; B: 80 &nbsp; &nbsp; &nbsp; HEX: ff7f50
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#ORANGE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#ff7f50"><font color="black"></><b><center> Coral </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Coral" is returned. </>
         */
        CORAL (255,127,80, "ff7f50", ColorGroup.ORANGE){
            public String toString() {
                return "Coral";
            }
        },
        /**
         * <p>R: 240 &nbsp; &nbsp; &nbsp; G: 128 &nbsp; &nbsp; &nbsp; B: 128 &nbsp; &nbsp; &nbsp; HEX: f08080
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#ORANGE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#f08080"><font color="black"></><b><center> LightCoral </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "LightCoral" is returned. </>
         */
        LIGHTCORAL (240,128,128, "f08080", ColorGroup.ORANGE){
            public String toString() {
                return "LightCoral";
            }
        },
        /**
         * <p>R: 255 &nbsp; &nbsp; &nbsp; G: 99 &nbsp; &nbsp; &nbsp; B: 71 &nbsp; &nbsp; &nbsp; HEX: ff6347
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#ORANGE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#ff6347"><font color="black"></><b><center> Tomato </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Tomato" is returned. </>
         */
        TOMATO (255,99,71, "ff6347", ColorGroup.ORANGE){
            public String toString() {
                return "Tomato";
            }
        },
        /**
         * <p>R: 255 &nbsp; &nbsp; &nbsp; G: 69 &nbsp; &nbsp; &nbsp; B: 0 &nbsp; &nbsp; &nbsp; HEX: ff4500
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#ORANGE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#ff4500"><font color="black"></><b><center> OrangeRed </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "OrangeRed" is returned. </>
         */
        ORANGERED (255,69,0, "ff4500", ColorGroup.ORANGE){
            public String toString() {
                return "OrangeRed";
            }
        },
        /**
         * <p>R: 255 &nbsp; &nbsp; &nbsp; G: 0 &nbsp; &nbsp; &nbsp; B: 0 &nbsp; &nbsp; &nbsp; HEX: ff0000
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#ORANGE}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#ff0000"><font color="black"></><b><center> Red </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Red" is returned. </>
         */
        RED (255,0,0, "ff0000", ColorGroup.ORANGE){
            public String toString() {
                return "Red";
            }
        },






        /**
         * <p>R: 255 &nbsp; &nbsp; &nbsp; G: 105 &nbsp; &nbsp; &nbsp; B: 180 &nbsp; &nbsp; &nbsp; HEX: ff69b4
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#PINK}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#ff69b4"><font color="black"></><b><center> HotPink </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "HotPink" is returned. </>
         */
        HOTPINK (255,105,180, "ff69b4", ColorGroup.PINK){
            public String toString() {
                return "HotPink";
            }
        },
        /**
         * <p>R: 255 &nbsp; &nbsp; &nbsp; G: 20 &nbsp; &nbsp; &nbsp; B: 147 &nbsp; &nbsp; &nbsp; HEX: ff1493
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#PINK}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#ff1493"><font color="black"></><b><center> DeepPink </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "DeepPink" is returned. </>
         */
        DEEPPINK (255,20,147, "ff1493", ColorGroup.PINK){
            public String toString() {
                return "DeepPink";
            }
        },
        /**
         * <p>R: 255 &nbsp; &nbsp; &nbsp; G: 192 &nbsp; &nbsp; &nbsp; B: 203 &nbsp; &nbsp; &nbsp; HEX: ffc0cb
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#PINK}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#ffc0cb"><font color="black"></><b><center> Pink </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Pink" is returned. </>
         */
        PINK (255,192,203, "ffc0cb", ColorGroup.PINK){
            public String toString() {
                return "Pink";
            }
        },
        /**
         * <p>R: 255 &nbsp; &nbsp; &nbsp; G: 182 &nbsp; &nbsp; &nbsp; B: 193 &nbsp; &nbsp; &nbsp; HEX: ffb6c1
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#PINK}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#ffb6c1"><font color="black"></><b><center> LightPink </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "LightPink" is returned. </>
         */
        LIGHTPINK (255,182,193, "ffb6c1", ColorGroup.PINK){
            public String toString() {
                return "LightPink";
            }
        },
        /**
         * <p>R: 219 &nbsp; &nbsp; &nbsp; G: 112 &nbsp; &nbsp; &nbsp; B: 147 &nbsp; &nbsp; &nbsp; HEX: db7093
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#PINK}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#db7093"><font color="black"></><b><center> PaleVioletRed </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "PaleVioletRed" is returned. </>
         */
        PALEVIOLETRED (219,112,147, "db7093", ColorGroup.PINK){
            public String toString() {
                return "PaleVioletRed";
            }
        },
        /**
         * <p>R: 176 &nbsp; &nbsp; &nbsp; G: 48 &nbsp; &nbsp; &nbsp; B: 96 &nbsp; &nbsp; &nbsp; HEX: b03060
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#PINK}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#b03060"><font color="black"></><b><center> Maroon </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Maroon" is returned. </>
         */
        MAROON (176,48,96, "b03060", ColorGroup.PINK){
            public String toString() {
                return "Maroon";
            }
        },
        /**
         * <p>R: 199 &nbsp; &nbsp; &nbsp; G: 21 &nbsp; &nbsp; &nbsp; B: 133 &nbsp; &nbsp; &nbsp; HEX: c71585
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#PINK}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#c71585"><font color="black"></><b><center> MediumVioletRed </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "MediumVioletRed" is returned. </>
         */
        MEDIUMVIOLETRED (199,21,133, "c71585", ColorGroup.PINK){
            public String toString() {
                return "MediumVioletRed";
            }
        },
        /**
         * <p>R: 208 &nbsp; &nbsp; &nbsp; G: 32 &nbsp; &nbsp; &nbsp; B: 144 &nbsp; &nbsp; &nbsp; HEX: d02090
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#PINK}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#d02090"><font color="black"></><b><center> VioletRed </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "VioletRed" is returned. </>
         */
        VIOLETRED (208,32,144, "d02090", ColorGroup.PINK){
            public String toString() {
                return "VioletRed";
            }
        },
        /**
         * <p>R: 238 &nbsp; &nbsp; &nbsp; G: 130 &nbsp; &nbsp; &nbsp; B: 238 &nbsp; &nbsp; &nbsp; HEX: ee82ee
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#PINK}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#ee82ee"><font color="black"></><b><center> Violet </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Violet" is returned. </>
         */
        VIOLET (238,130,238, "ee82ee", ColorGroup.PINK){
            public String toString() {
                return "Violet";
            }
        },
        /**
         * <p>R: 221 &nbsp; &nbsp; &nbsp; G: 160 &nbsp; &nbsp; &nbsp; B: 221 &nbsp; &nbsp; &nbsp; HEX: dda0dd
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#PINK}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#dda0dd"><font color="black"></><b><center> Plum </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Plum" is returned. </>
         */
        PLUM (221,160,221, "dda0dd", ColorGroup.PINK){
            public String toString() {
                return "Plum";
            }
        },
        /**
         * <p>R: 218 &nbsp; &nbsp; &nbsp; G: 112 &nbsp; &nbsp; &nbsp; B: 214 &nbsp; &nbsp; &nbsp; HEX: da70d6
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#PINK}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#da70d6"><font color="black"></><b><center> Orchid </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Orchid" is returned. </>
         */
        ORCHID (218,112,214, "da70d6", ColorGroup.PINK){
            public String toString() {
                return "Orchid";
            }
        },
        /**
         * <p>R: 186 &nbsp; &nbsp; &nbsp; G: 85 &nbsp; &nbsp; &nbsp; B: 211 &nbsp; &nbsp; &nbsp; HEX: ba55d3
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#PINK}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#ba55d3"><font color="black"></><b><center> MediumOrchid </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "MediumOrchid" is returned. </>
         */
        MEDIUMORCHID (186,85,211, "ba55d3", ColorGroup.PINK){
            public String toString() {
                return "MediumOrchid";
            }
        },
        /**
         * <p>R: 153 &nbsp; &nbsp; &nbsp; G: 50 &nbsp; &nbsp; &nbsp; B: 204 &nbsp; &nbsp; &nbsp; HEX: 9932cc
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#PINK}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#9932cc"><font color="white"></><b><center> DarkOrchid </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "DarkOrchid" is returned. </>
         */
        DARKORCHID (153,50,204, "9932cc", ColorGroup.PINK){
            public String toString() {
                return "DarkOrchid";
            }
        },
        /**
         * <p>R: 148 &nbsp; &nbsp; &nbsp; G: 0 &nbsp; &nbsp; &nbsp; B: 211 &nbsp; &nbsp; &nbsp; HEX: 9400d3
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#PINK}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#9400d3"><font color="white"></><b><center> DarkViolet </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "DarkViolet" is returned. </>
         */
        DARKVIOLET (148,0,211, "9400d3", ColorGroup.PINK){
            public String toString() {
                return "DarkViolet";
            }
        },
        /**
         * <p>R: 138 &nbsp; &nbsp; &nbsp; G: 43 &nbsp; &nbsp; &nbsp; B: 226 &nbsp; &nbsp; &nbsp; HEX: 8a2be2
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#PINK}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#8a2be2"><font color="white"></><b><center> BlueViolet </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "BlueViolet" is returned. </>
         */
        BLUEVIOLET (138,43,226, "8a2be2", ColorGroup.PINK){
            public String toString() {
                return "BlueViolet";
            }
        },
        /**
         * <p>R: 160 &nbsp; &nbsp; &nbsp; G: 32 &nbsp; &nbsp; &nbsp; B: 240 &nbsp; &nbsp; &nbsp; HEX: a020f0
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#PINK}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#a020f0"><font color="white"></><b><center> Purple </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Purple" is returned. </>
         */
        PURPLE (160,32,240, "a020f0", ColorGroup.PINK){
            public String toString() {
                return "Purple";
            }
        },
        /**
         * <p>R: 147 &nbsp; &nbsp; &nbsp; G: 112 &nbsp; &nbsp; &nbsp; B: 219 &nbsp; &nbsp; &nbsp; HEX: 9370db
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#PINK}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#9370db"><font color="black"></><b><center> MediumPurple </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "MediumPurple" is returned. </>
         */
        MEDIUMPURPLE (147,112,219, "9370db", ColorGroup.PINK){
            public String toString() {
                return "MediumPurple";
            }
        },
        /**
         * <p>R: 216 &nbsp; &nbsp; &nbsp; G: 191 &nbsp; &nbsp; &nbsp; B: 216 &nbsp; &nbsp; &nbsp; HEX: d8bfd8
         * &nbsp; &nbsp; &nbsp; Grouped under: {@link ColorCode.ColorGroup#PINK}</p>
         *
         * <p><table border="1" width="60%"><tr><th bgcolor="#d8bfd8"><font color="black"></><b><center> Thistle </center></b></font></th></tr></table></p>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "Thistle" is returned. </>
         */
        THISTLE (216,191,216, "d8bfd8", ColorGroup.PINK){
            public String toString() {
                return "Thistle";
            }
        };




        /**
         * This variable is used to store the value of the red component of the defined color.
         *
         */
        private int r;


        /**
         * This variable is used to store the value of the green component of the defined color.
         *
         */
        private int g;


        /**
         * This variable is used to store the value of the blue component of the defined color.
         *
         */
        private int b;


        /**
         * This variable is used to store the hexadecimal representation of the defined color in RGB color space.
         *
         */
        private String hex;


        /**
         * This variable is used to define the {@link ColorCode.ColorGroup} of this color, according to <a href="http://www.tayloredmktg.com/rgb/" target="_blank">tayloredmktg.com</a>.
         *
         */
        private ColorGroup group;


        /**
         * Constructor used to declare and initialize a color chosen from the predefined enumerators: {@link ColorCode.Color}.
         *
         * @param r is the integer value representing the red component of the defined color in RBG color space.
         * @param g is the integer value representing the green component of the defined color in RBG color space.
         * @param b is the integer value representing the blue component of the defined color in RBG color space.
         * @param hex is the {@link String} representing the hexadecimal value of the defined color in RBG color space.
         * @param group is the {@link ColorCode.ColorGroup} to which the color belongs as found in <a href="http://www.tayloredmktg.com/rgb/" target="_blank">tayloredmktg.com</a>.
         */
        private Color(int r, int g, int b, String hex, ColorGroup group) {
            this.r = r;
            this.g = g;
            this.b = b;
            this.hex = hex;
            this.group = group;
        }



        /**
         * This method is used access the value of the red component of the chosen color.
         *
         * @return An integer denoting the value of the red component of the defined color in RGB color space.
         */
        public int getR() {
            return r;
        }


        /**
         * This method is used access the ratio of the red component of the chosen color, to the maximum possible value of component.
         *
         * @return A double denoting the value of the red component of the color, divided by 255.
         */
        public double getR_By_RMAX() {
            return getR()/ RGB_MAX;
        }


        /**
         * This method is used access the value of the blue component of the chosen color.
         *
         * @return An integer denoting the value of the blue component of the defined color in RGB color space.
         */
        public int getB() {
            return b;
        }


        /**
         * This method is used access the ratio of the blue component of the chosen color, to the maximum possible value of component.
         *
         * @return A double denoting the value of the blue component of the color, divided by 255.
         */
        public double getB_By_BMAX() {
            return getB()/ RGB_MAX;
        }


        /**
         * This method is used access the value of the green component of the chosen color.
         *
         * @return An integer denoting the value of the green component of the defined color in RGB color space.
         */
        public int getG() {
            return g;
        }



        /**
         * This method is used access the ratio of the green component of the chosen color, to the maximum possible value of component.
         *
         * @return A double denoting the value of the green component of the color, divided by 255.
         */
        public double getG_By_GMAX() {
            return getG()/ RGB_MAX;
        }



        /**
         * This method is used access the hexadecimal value of the chosen color in RGB color space.
         *
         * @return A {@link String} object containing the hexadecimal representation of the defined color in RGB color space.
         */
        public String getHex()
        {
            return hex;
        }



        /**
         * This method is used access the {@link ColorCode.ColorGroup} of the chosen color.
         *
         * @return The {@link ColorCode.ColorGroup} of the color, defined as found in <a href="http://www.tayloredmktg.com/rgb/" target="_blank">tayloredmktg.com</a>.
         */
        public ColorGroup getColorGroup() {
            return group;
        }
    }

    public static List<String> getColorGroupList() {
        ColorCode.ColorGroup list[] = ColorCode.ColorGroup.values();
        List<String> temp = new ArrayList<String>();
        for(int i = 0; i < list.length; i++){
            temp.add(list[i].toString());
        }
        return temp;
    }

    public static List<String> getColorList(String group) {
        ColorCode.Color list[] = ColorCode.Color.values();
        List<String> temp = new ArrayList<String>();
        for(int i = 0; i < list.length; i++){
            if(list[i].getColorGroup().toString().equalsIgnoreCase(group)){
                temp.add(list[i].toString());
            }
        }
        return temp;
    }

    public static ColorCode.Color getColorFromString(String color){
        ColorCode.Color list[] = ColorCode.Color.values();
        for(int i = 0; i < list.length; i++){
            if(list[i].toString().equalsIgnoreCase(color)){
                return list[i];
            }
        }
        return null;
    }

}
