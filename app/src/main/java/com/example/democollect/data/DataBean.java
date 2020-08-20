package com.example.democollect.data;

/**
 * @author zhangt
 * @description:
 * @date :2020/8/18 13:07
 */
public class DataBean {

    public int add(int a, int b){
        return  a + b;
    }

    public int multiply(int a, int b){
        int res = 0;
        for(int i=0;i<b;i++){
            res = add(res, a);
        }
        return res;
    }
}
