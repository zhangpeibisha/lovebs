package org.nix.lovedomain.service.enums;

import org.junit.Test;

import static org.junit.Assert.*;

public class RequestEnumTest {

    @Test
    public void test(){
        RequestEnum get = RequestEnum.valueOf("GET");
        System.out.println(get);
    }

}