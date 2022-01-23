package edu.princeton.cs.algs4.util;

import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

//随机颜色
public class RandomColor {
    public static Color randomColor(int rgb){
        if(rgb > 0xFFFFFF){
            throw new RuntimeException("范围超出颜色的表示范围");
        } else {
            Color color = new Color(rgb);
            return color;
        }

    }

    public static int randomColor(){
        return StdRandom.uniform(0xFFFFFF);
    }
}
