package notegenerator;

public class BeachRock {

    // GUITAR
    static String gs1 = "T332 A4-E4 F#5-C6 E5-A5 T166 G5 A5 F#5 A5 F5 A5 E5-A5 E3 G3 G#3 ";
    static String gs2 = "A3 A3 A3 G3 E3 E3 G3 G#3 ";
    static String gs3 = "A3 A3 A3 G3 E3 A3 C4 C#4 ";
    static String gs4 = gs2 + gs2 + gs2 + gs3;
    static String gs5 = "D4 D4 D4 C4 A3 A3 C4 D#4 ";
    static String gs6 = "D4 D4 D4 C4 A3 E3 G3 G#3 ";
    static String gs7 = gs4 + gs5 + gs6 + gs2 + "A3 A3 A3 G3 E3 B3 D3 D#3 ";
    static String gs8 = "E4 E4 E4 D4 B3 B3 E4 B3 " + gs6 + gs2;
    static String gs9 = "x E3-B3 E3-B3 E3-B3 E3-B3 E3 G3 G#3 ";
    static String gs10 = gs7 + gs8 + gs9;
    static String gs11 = "A3-D4 X*7 X*16 X*5 E3 G3 G#3 ";
    static String guitar = gs1 + gs10 + gs11 + gs10 + gs11 + "A3 A3 A3";

    // DRUMS
    static String ds1 = "D2 X D3 D3 X*2 D3 X ";
    static String ds2 = "D2 X D3 D3 X D3 D3 D3 ";
    static String ds3 = "D2 D3 D3 D3 D3 T83 D3 D3 T166 D3 ";
    static String ds4 = ds1 + ds1 + ds1 + ds2;
    static String ds5 = ds1 + ds1 + ds1 + ds3;
    static String ds6 = "D2*2 D3 D3 X*2 D3*2 ";
    static String ds7 = "D2*2 D3 D3 X D3 D3 D3 ";
    static String ds8 = ds6 + ds6 + ds6 + ds7;

    static String drums = "V25 T166 X*16 " + ds4 + ds4 + ds5 + ds8 + ds4 + ds4
            + ds5 + ds8;

    public static String getTack1(){
        return guitar;
    }

    public static String getTack2(){
        return drums;
    }


}