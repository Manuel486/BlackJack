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

import java.util.ArrayList;

/**
 * La clase Hand es una mano de cartas para jugar.
 */
public class Hand {

    private ArrayList<Card> hand;

    public Hand(){
        this.hand = new ArrayList<Card>();
    }

    /**
     * Toma una carta de la baraja y la agrega a la mano del jugador o crupier
     * @param deck es un arraylist de cartas
     */
    public void takeCardFromDeck(Deck deck){
        hand.add(deck.takeCard());
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public Card getCard(int idx){
        return hand.get(idx);
    }

}
