package com.bytesw.blackjack;


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

/**
 * La clase Player maneja todas las operaciones específicos del jugador.
 * Posee el atributo balance para diferenciarlo del Crupier.
 */
public class Player {
    private double balance;
    private Hand handPlayer;

    public Player(double balance) {
        this.balance = balance;
        this.handPlayer = new Hand();
    }

    public Hand getHandPlayer() {
        return handPlayer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Disminuye el saldo del jugador en base a su apuesta
     * @param discount cantidad a descontar
     */
    public void deductBalance(double discount){
        this.balance -= discount;
    }

    /**
     * Aumenta el saldo del jugador en base a su apuesta
     * @param income cantidad a aumentar
     */
    public void increaseBalance(double income){
        this.balance += income;
    }

}
