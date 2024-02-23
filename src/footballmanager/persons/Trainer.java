package footballmanager.persons;

import java.util.Objects;

public class Trainer extends Person{

    private int numTornejosGuanyats;
    private boolean seleccionadorNacional;

    public Trainer(String nom, String cognom, String dataNaix, double sou, int numTornejosGuanyats, boolean seleccionadorNacional) {
        super(nom, cognom, dataNaix, sou);
        this.numTornejosGuanyats = numTornejosGuanyats;
        this.seleccionadorNacional = seleccionadorNacional;
    }

    public int getNumTornejosGuanyats() {
        return numTornejosGuanyats;
    }

    public void setNumTornejosGuanyats(int numTornejosGuanyats) {
        this.numTornejosGuanyats = numTornejosGuanyats;
    }

    public boolean isSeleccionadorNacional() {
        return seleccionadorNacional;
    }

    public void setSeleccionadorNacional(boolean seleccionadorNacional) {
        this.seleccionadorNacional = seleccionadorNacional;
    }

    @Override
    public void entrenar(){
        double motivacio = super.getNivellMotivacio();
        if(this.seleccionadorNacional){
            motivacio += 0.3;
        }else{
            motivacio += 0.15;
        }

        super.setNivellMotivacio(motivacio);
        this.incrementarSou();
    }


    public void incrementarSou(){
        double souActual = super.getSou();
        double nouSou = souActual + (souActual * 5 / 100);
        super.setSou(nouSou);
    }

    public boolean equals(int hashCode){
        return hashCode == this.hashCode();
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.getPersonaId());
    }
}
