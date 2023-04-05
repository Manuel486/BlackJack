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
 * La clase Rank contiene los rangos de cartas, nombres y valores
 */
public enum Rank {
    ACE("AS", 11),
    TWO("Dos", 2),
    THREE("Tres", 3),
    FOUR("Cuatro",4),
    FIVE("Cinco",5),
    SIX("Seis",6),
    SEVEN("Siete",7),
    EIGHT("Ocho",8),
    NINE("Nueve",9),
    TEN("Diez",10),
    JACK("Jota",10),
    QUEEN("Dama",10),
    KING("Rey",10);

    String rankName;
    int rankValue;

    Rank(String rankName, int rankValue){
        this.rankName = rankName;
        this.rankValue = rankValue;
    }

    public String toString(){
        return rankName;
    }
}
