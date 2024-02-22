package footballmanager.persons;

import footballmanager.utils.Utils;

public abstract class Person {
    private static int numPersones;

    private int personaId;
    private String nom;
    private String cognom;
    private String dataNaix;
    private double nivellMotivacio; //1-10
    private double puntuacio; //30-100

    private double sou;

    public void entrenar(){
        this.nivellMotivacio += 2;
        if(this.nivellMotivacio > 10){
            this.nivellMotivacio = 10;
        }
    }

    public Person(String nom, String cognom, String dataNaix, double sou) {
        Person.numPersones += 1;
        this.personaId = Person.numPersones;
        this.nom = nom;
        this.cognom = cognom;
        this.dataNaix = dataNaix;
        this.nivellMotivacio = 5;
        this.sou = sou;
        this.puntuacio = Utils.randomNumberBetween(30,100);
    }

    public double getSou() {
        return sou;
    }

    public void setSou(double sou) {
        this.sou = sou;
    }

    public static int getNumPersones() {
        return numPersones;
    }

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }
    public double getPuntuacio() {
        return puntuacio;
    }

    public void setPuntuacio(double puntuacio) {
        if(puntuacio > 100){
            this.puntuacio = 100;
        }else if (puntuacio < 30){
            this.puntuacio = 30;
        }else{
            this.puntuacio = puntuacio;
        }
    }

    public String getNom() {
        return nom;
    }


    public String getCognom() {
        return cognom;
    }


    public String getDataNaix() {
        return dataNaix;
    }


    public double getNivellMotivacio() {
        return nivellMotivacio;
    }

    public void setNivellMotivacio(double nivellMotivacio) {
        this.nivellMotivacio = nivellMotivacio;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personaId=" + personaId +
                ", nom='" + nom + '\'' +
                '}';
    }
}
