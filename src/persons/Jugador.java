package persons;

import equips.Equip;
import utils.Utils;

import java.util.Random;

public class Jugador extends Person implements Transferible{
    public enum Posicio {
        POR,
        DEF,
        MIG,
        DAY
    }

    private boolean transferible;
    private int dorsal;
    private Posicio posicio;

    public Jugador(String nom,
                   String cognom,
                   String dataNaix,
                   float sou,
                   boolean transferible,
                   int dorsal,
                   Posicio posicio
    ) {
        super(nom, cognom, dataNaix, sou);
        this.transferible = transferible;
        this.dorsal = dorsal;
        this.posicio = posicio;
    }

    public Posicio getPosicio() {
        return posicio;
    }

    public void setPosicio(Posicio posicio) {
        this.posicio = posicio;
    }


    public boolean isTransferible() {
        return transferible;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public void setTransferible(boolean transferible) {
        this.transferible = transferible;
    }

    @Override
    public void entrenar(){
        super.entrenar();
        double multiplier = getMultiplier();
        double puntuacio = super.getPuntuacio() + multiplier;
        super.setPuntuacio(puntuacio);
        this.canviarPosicio();
    }

    private double getMultiplier(){
        Random random = new Random();
        double probability = random.nextDouble();

        if (probability < 0.7) {
            return 0.1;
        } else if (probability < 0.9) {
            return 0.2;
        } else {
            return 0.3;
        }
    }

    public void canviarPosicio(){
        double randomNumber = Utils.randomNumberBetween(0,100);
        if(randomNumber <= 5){
            Posicio posicio = getRandomPosicio();
            System.out.println("el jugador" + this.getNom() + "ha canviat a la posicio" + posicio);
            this.posicio = posicio;
        }
    }

    private static Posicio getRandomPosicio() {
        int size = Posicio.values().length;

        Random random = new Random();
        int randomIndex = random.nextInt(size);

        return Posicio.values()[randomIndex];
    }

    public boolean esTransferible(){
        return transferible;
    };
    public void transferirAEquip(Equip e){
//        pendent a fer
    };
}
