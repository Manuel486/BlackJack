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
 * La clase Carta nos permite crear cartas con un Palo y un Rango.
 * Contiene los métodos necesarios para obtener el valor de la carta.
 */
public class Card {
    private Stick stick;
    private Rank rank;

    public Card(Card card){
        this.stick = card.getStick();
        this.rank = card.getRank();
    }

    public Card(Stick stick, Rank rank) {
        this.stick = stick;
        this.rank = rank;
    }

    public Stick getStick() {
        return stick;
    }

    public void setStick(Stick stick) {
        this.stick = stick;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "["+stick+" "+rank+"] ";
    }
}
