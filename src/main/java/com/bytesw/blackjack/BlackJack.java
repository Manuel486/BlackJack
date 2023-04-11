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
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * La clase BlackJack provee la lógica del juego, esta se encarga de determinar los resultados y mostrar
 * las opciones disponibles.
 */
public class BlackJack {
    private Deck deck;
    private Crupier crupier;
    private Player player;
    private ArrayList<ResultGame> gameResults;

    public BlackJack(){
        deck = new Deck();
        crupier = new Crupier();
        this.gameResults = new ArrayList<ResultGame>();
        deck.shuffle();
        showGame();
    }

    /**
     * Controla el acceso de las diferentes opciones del menu principal.
     */
    public void showGame(){
        int option=-1;
        double balance=0;
        double bet=0;
        Scanner entrance = new Scanner(System.in);
        do{
            showOptions();
            System.out.print("\tIngrese la opcion : ");
            try {
                option = entrance.nextInt();
            } catch (InputMismatchException e){
                System.out.println("\nDebe ingresar un opción válida\n");
                entrance.nextLine(); // Para limpiar el buffer de entrada
                continue;
            }
            switch (option){
                case 0 :
                    break;
                case 1 :
                    if (player != null){
                        //evaluatingGameEntry();
                        showGameConsole();
                    } else {
                        System.out.println("\nDebe ingresar su saldo para poder iniciar");
                    }
                    break;
                case 2 :
                    System.out.print("\nIngrese el saldo inicial : ");
                    try{
                        balance = entrance.nextDouble();
                    }catch (InputMismatchException e){
                        System.out.println("\nDebe ingresar un saldo correcto\n");
                        entrance.nextLine(); // Para limpiar el buffer de entrada
                        break;
                    }
                    this.player = new Player(balance);
                    break;
                case  3 :
                    System.out.print("\nSu saldo es : "+player.getBalance()+"\n");
                    break;
                case 4 :
                    System.out.println("\n\t=====RESULTADOS HISTÓRICOS=====");
                    for(ResultGame resultGame: gameResults){
                        System.out.println(resultGame.toString());
                    }
                    break;
                default:
                    System.out.println("\nIngrese una de las opciones disponibles\n");
                    break;
            }
        } while (option!=0);
    }

    /**
     * Muestra los diferentes juegos disponibles para el usuario
     */
    private void showGameConsole(){
        int option=-1;
        double balance=0;
        double bet=0;
        do{
            Scanner entrance = new Scanner(System.in);
            System.out.println("\n\t=== ELIJA UN JUEGO ===");
            System.out.println("\n\t1. -");
            System.out.println("\t2. JackBlack");
            System.out.println("\t3. -");
            System.out.println("\t0. Retroceder");
            System.out.print("\tIngrese la opcion : ");
            try{
                option = entrance.nextInt();
            }catch (InputMismatchException e){
                System.out.println("\nDebe ingresar un opción válida\n");
                entrance.nextLine(); // Para limpiar el buffer de entrada
                continue;
            }
            switch (option){
                case 1 :
                    System.out.println("\nTodavía no se desarrollo el juego, por favor elija otro.");
                    break;
                case 2 :
                    evaluatingGameEntry();
                    return;
                case 3 :
                    System.out.println("Todavía no se desarrollo el juego, por favor elija otro.");
                    break;
            }
        } while (option!=0);
    }

    /**
     * Muestras las opciones disponibles al iniciar la aplicación
     */
    public void showOptions(){
        System.out.println("\n\t1. Seleccionar juego");
        System.out.println("\t2. Ingresar saldo inicial del jugador");
        System.out.println("\t3. Consultar saldo del jugador");
        System.out.println("\t4. Consultar historico de resultados");
        System.out.println("\t0. Salir");
    }

    /**
     * Evalua si el jugador cuenta con saldo para iniciar el juego de BlackJack
     */
    private void evaluatingGameEntry(){
        double bet = 0;
        Scanner entrance= new Scanner(System.in);

        if(player.getBalance()<=0){
            System.out.println("Usted ya no tiene saldo para apostar");
        }

        System.out.print("Ingrese la cantidad que desea apostar : ");

        try{
            bet = entrance.nextDouble();
        }catch (InputMismatchException e){
            System.out.println("\nDebe ingresar una cantidad correcta\n");
            entrance.nextLine(); // Para limpiar el buffer de entrada
            return;
        }

        if(bet<=player.getBalance()){
            startGame(bet);
        } else {
            System.out.println("\nLo sentimos no cuenta con el saldo suficiente");
        }
    }

    /**
     * Contiene la lógica del juego
     * @param bet es el monto que decidio apostar el jugador
     */
    private void startGame(double bet){
        int standUp = 0;
        int totalCrupier = 0;
        int totalPlayer = 0;
        Scanner entrance = new Scanner(System.in);

        crupier.getHandCrupier().takeCardFromDeck(deck);
        totalCrupier+=crupier.getHandCrupier().getHand().get(0).getRank().rankValue;

        do{
            System.out.print("\nCrupier : ");
            System.out.print(crupier.getHandCrupier().getHand().get(0).toString()+" Total : "+totalCrupier);

            player.getHandPlayer().takeCardFromDeck(deck);
            totalPlayer+=player.getHandPlayer().getHand().get(player.getHandPlayer().getHand().size() - 1).getRank()
                    .rankValue;

            System.out.print("\nPlayer : ");
            for(Card card: player.getHandPlayer().getHand()){
                System.out.print(card.toString());
            }
            System.out.println(" Total : "+totalPlayer);

            if(totalPlayer>=21){
                break;
            }

            System.out.print("\nTiene dos opciones: ");
            System.out.println("\n  1) Plantarse");
            System.out.println("  2) Continuar");
            System.out.print("  Elija un opccion : ");
            standUp = entrance.nextInt();

        }while(standUp!=1);

        if(totalPlayer==21){
            System.out.println("\nUsted ganó\n");
            player.increaseBalance(bet*3);
            gameResults.add(new ResultGame(player,bet,true,bet*3));
            decideContinuePlaying();
            return;
        }

        if(totalPlayer>21){
            System.out.println("\nEl jugador sobrepaso los 21\n\n");
            player.deductBalance(bet);
            gameResults.add(new ResultGame(player,bet,false,bet));
            decideContinuePlaying();
            return;
        }

        totalCrupier =  playCuprierHand(totalCrupier,totalPlayer);

        showEndResult(totalCrupier,totalPlayer);

        evaluateGame(totalCrupier,totalPlayer,bet);

        decideContinuePlaying();
    }

    /**
     * Muestra las cartas del crupier y del jugador.
     * @param totalCrupier es el total acumulado en cartas por el crupier
     * @param totalPlayer es el total acumulado en cartas por el jugador
     */
    public void showEndResult(int totalCrupier,int totalPlayer){
        System.out.print("\n\t=====RESULTADO FINAL=====");
        System.out.print("\nCuprier : ");
        for(Card card: crupier.getHandCrupier().getHand()){
            System.out.print(card.toString());
        }
        System.out.println(" Total : "+totalCrupier);

        System.out.print("Player : ");
        for(Card card: player.getHandPlayer().getHand()){
            System.out.print(card.toString());
        }
        System.out.println(" Total : "+totalPlayer);
    }

    /**
     * Evalua si el jugador perdio o gano el juego.
     * @param totalCrupier es el total acumulador en cartas por el crupier
     * @param totalPlayer es el total acumulado en cartas por el jugador
     * @param bet es el monto que decidio apostar el jugador
     */
    public void evaluateGame(int totalCrupier,int totalPlayer,double bet){
        if  ((totalPlayer<21 && totalCrupier<21 && totalCrupier>totalPlayer)
            || (totalCrupier==21)){
                System.out.println("\n\nUsted perdió\n\n");
                player.deductBalance(bet);
                gameResults.add(new ResultGame(player,bet,false,bet));
        } else if(totalCrupier>21){
                System.out.println("\n\nUsted ganó\n\n");
                player.increaseBalance(bet);
                gameResults.add(new ResultGame(player,bet,true,bet));
        }
    }

    /**
     * Elige las cartas del crupier, tomando en cuenta el total acumulado por el jugador.
     * @param totalCrupier es el total acumulador en cartas por el crupier, tomanado en cuenta que por
     *                     el momento solo selecciono una carta.
     * @param totalPlayer es el total acumulado en cartas por el jugador
     * @return el total acumulado por el crupier en cartas
     */
    private int playCuprierHand(int totalCrupier,int totalPlayer){
        do{
            crupier.getHandCrupier().takeCardFromDeck(deck);
            totalCrupier+=crupier.getHandCrupier().getHand().get(crupier.getHandCrupier().getHand().size() - 1).getRank().rankValue;
        }while( (totalCrupier<21) && (totalCrupier<totalPlayer));

        return totalCrupier;
    }

    /**
     * Evalua si el jugador quiere continuar jugando BlackJack o si desea regresar a la ventana principal.
     */
    private void decideContinuePlaying(){
        int option;
        Scanner entrance = new Scanner(System.in);
        System.out.print("¿Desea seguir jugando? (1)Si  (2)No -> ");
        option = entrance.nextInt();
        deck = new Deck();
        crupier.getHandCrupier().setHand(new ArrayList<Card>());
        player.getHandPlayer().setHand(new ArrayList<Card>());
        deck.shuffle();
        if(option==1){
            evaluatingGameEntry();
        }
    }
}
