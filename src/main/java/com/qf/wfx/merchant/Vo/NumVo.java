package com.qf.wfx.merchant.Vo;

public class NumVo {

        /**
         * 生成随机数方法
         * @param size	要生成随机数的位数
         * @return	随机数
         */
        public static long getRandomCode(int size){
            double n = Math.pow(10, (size-1));
            int num;

            if(size>1){
                num = (int) (Math.random()*(9*n)+n);
            }else{
                num = (int) (Math.random()*10);
            }
            return num;
        }
}
