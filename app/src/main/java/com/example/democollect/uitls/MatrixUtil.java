package com.example.democollect.uitls;

import android.graphics.Matrix;
import android.util.Log;

/**
 * @author zhangt
 * @description: Matrix 的相关操作
 * @date :2020/8/14 16:23
 */
public class MatrixUtil {
    private static final String TAG = "MatrixUtil";

    /**
     * 打印Matrix矩阵
     * @param matrix
     */
    public static void printMatrix(Matrix matrix){
        float[] values = new float[9];
        matrix.getValues(values);
        String lineOne = String.format("[[%.1f, %.1f, %.1f],", values[0],values[1],values[2]);
        String lineTwo = String.format(" [%.1f, %.1f, %.1f],", values[3],values[4],values[5]);
        String lineThree = String.format(" [%.1f, %.1f, %.1f]]", values[6],values[7],values[8]);
        Log.d(TAG, "printMatrix: " + lineOne);
        Log.d(TAG, "printMatrix: " + lineTwo);
        Log.d(TAG, "printMatrix: " + lineThree);
    }
}
