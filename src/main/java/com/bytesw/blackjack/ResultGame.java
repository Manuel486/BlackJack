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
 * La clase ResultGame contiene el formato con el que se van a guardar los
 * resultados de cada juego.
 */
public class ResultGame {
    private Player player;
    private boolean result;
    private double bet;

    private double totalProfitOrLoss;

    /**
     * Crea un resultado de juego
     * @param player representa al jugador que esta apostando
     * @param bet es la apuesta
     * @param result indica si el jugador perdio o gano la partida (false->perdio,true->gano)
     * @param totalProfitOrLoss cantidad que perdio el jugador
     */
    public ResultGame(Player player, double bet, boolean result,double totalProfitOrLoss) {
        this.player = player;
        this.bet = bet;
        this.result = result;
        this.totalProfitOrLoss = totalProfitOrLoss;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public double getBet() {
        return bet;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public void setBet(double bet) {
        this.bet = bet;
    }

    /**
     *
     * @return formato de resultado de cada partida de BlackJack
     */
    @Override
    public String toString() {
        String resultText = "";
        if(result){
            resultText = "Ganó";
        } else {
            resultText = "Perdió";
        }
        return "[ Resultado:"+resultText+"   Aposto:"+bet+"   "+resultText+":"+totalProfitOrLoss+"]";
    }
}
