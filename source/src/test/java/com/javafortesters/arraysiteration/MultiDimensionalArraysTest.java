package com.javafortesters.arraysiteration;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MultiDimensionalArraysTest {

    @Test
    public void createAMultiDimensionalArray(){

        int[][] multi = new int[4][4];

        print2DIntArray(multi);

        assertEquals(4, multi[0].length);

        assertEquals(0, multi[0][1]);

        Arrays.fill(multi[0], 0);
        Arrays.fill(multi[1], 1);
        Arrays.fill(multi[2], 2);
        Arrays.fill(multi[3], 3);

        print2DIntArray(multi);


    }

    public void print2DIntArray(int [][]multi){
        for(int[] outer : multi){
            if(outer==null){
                System.out.print("null");
            }else{
                for(int inner : outer){
                    System.out.print(inner + ",");
                }
            }
            System.out.println("");
        }
    }

    @Test
    public void createAndDefineAMultiArray(){
        int[][] multi = {{1,2,3,4},
                         {5,6,7,8},
                         {9,0,11,12},
                         {13,14,15,16}};

        assertEquals(1, multi[0][0]);
        assertEquals(7, multi[1][2]);
        assertEquals(12, multi[2][3]);
        assertEquals(14, multi[3][1]);

        print2DIntArray(multi);
    }

    @Test
    public void createA3DArrayArray(){
        int[][][] multi3d = new int[3][4][5];

        assertEquals(3, multi3d.length);
        assertEquals(4, multi3d[0].length);
        assertEquals(4, multi3d[1].length);
        assertEquals(4, multi3d[2].length);
        assertEquals(5, multi3d[0][1].length);
        assertEquals(5, multi3d[0][2].length);
        assertEquals(5, multi3d[1][3].length);

        assertEquals(0, multi3d[0][0][0]);
    }

    @Test
    public void ragged2DArray(){
        int[][] ragged2d = {{1,2,3,4},
                            {5,6},
                            {7,8,9}
                            };

        assertEquals(4, ragged2d[0][3]);
        assertEquals(6, ragged2d[1][1]);
        assertEquals(7, ragged2d[2][0]);

        print2DIntArray(ragged2d);

    }


    @Test
    public void createRagged2dArray(){

        int[][] ragged2d= new int[10][];

        ragged2d[0] = new int[10];
        ragged2d[1] = new int[3];

        print2DIntArray(ragged2d);

    }

    @Test
    public void createRagged3dArray(){
        int[][][] ragged3d= new int[10][][];
    }

    @Test
    public void createTriangle2dArray(){

        int[][]triangle = new int [16][];

        for(int row=0; row<triangle.length; row++){
            triangle[row] = new int[row+1];
            for(int i=0; i< (row+1); i++){
                triangle[row][i] = i;
            }
        }

        print2DIntArray(triangle);
    }
}