/**
 * @author Manuel Alberto Chunga Vargas
 * @version 5/04/2023
 *
 * Copyright (c) yyyy Byte, S.A.
 * Todos los derechos reservados.
 *
 * Este software constituye información confidencial y propietaria de
 * Byte, S.A. ("Información Confidencial"). Usted no
 * debe develar dicha Información Confidencial y debe usarla de acuerdo
 * con los términos de aceptación de licencia de uso que firmó con
 * Byte.
 *
 */

package com.bytesw.blackjack;

/**
 * La clase Stick contiene los palos de una carta
 */
public enum Stick {
    CLUB("Treboles"),
    DIAMOND("Diamantes"),
    HEART("Corazones"),
    SPADE("Picas");

    String stickName;

    Stick(String stickName){
        this.stickName = stickName;
    }

    public String toString(){
        return stickName;
    }
}
