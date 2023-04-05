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
 * La clase Crupier contiene las operaciones del empleado del casino.
 */
public class Crupier {

    private Hand handCrupier;

    public Crupier(){
        this.handCrupier = new Hand();
    }

    /**
     * Toma una carta de la baraja
     * @param deck es la baraja que contiene todas la cartas disponibles en el juego
     */
    public void grabfFirstHand(Deck deck){
        this.handCrupier.takeCardFromDeck(deck);
    }

    public Hand getHandCrupier() {
        return handCrupier;
    }
}
