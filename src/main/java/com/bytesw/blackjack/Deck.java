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
import java.util.Collections;
import java.util.Random;

/**
 * La clase Deck representa una baraja de cartas.
 */
public class Deck {
    private ArrayList<Card> deck;

    /**
     * Crear una baraja de cartas estándar
     */
    public Deck(){
        this.deck = new ArrayList<Card>();
        for(Stick stick : Stick.values()){
            for(Rank rank: Rank.values()){
                deck.add(new Card(stick,rank));
            }
        }
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    /**
     * Baraja el mazo de cartas al azar
     */
    public void shuffle(){
        Collections.shuffle(deck,new Random());
    }

    /**
     * Toma el valor de la primera carta de la baraja y luego la elimina.
     * @return La carta de la baraja
     */
    public Card takeCard(){
        Card card = new Card(deck.get(0));
        deck.remove(0);
        return card;
    }
}
