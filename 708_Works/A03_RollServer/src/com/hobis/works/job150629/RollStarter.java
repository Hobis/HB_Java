package com.hobis.works.job150629;

/**
 * Created by snag on 2015-06-29.
 */
public final class RollStarter {

    public static void main(String[] args) {

        RollServer t_rs = new RollServer("Starter", 9937);
        t_rs.start();

    }

}
