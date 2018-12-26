package org.nix.zhangpei.account;


public class AccountApplicationTest {

    public static void main(String[] args) {
        double[] doubles = {1200,1600,2000,2400,2800,3200,3600};
        for (int i = 0; i < doubles.length; i++) {
            System.out.println(String.format("%d : %f : %f",i,doubles[i],run(doubles[i])));
        }
    }

    public static double run(double n){
        return 160.39 - 0.110913*n + 1.36485 * Math.pow(10,-4)*Math.pow(n,2)
                - 6.191286*Math.pow(10,-8)*Math.pow(n,3) + 1.20898 * Math.pow(10,-11) * Math.pow(n,4)
                - 8.85607 * Math.pow(10,-16) * Math.pow(n,5);
    }


}