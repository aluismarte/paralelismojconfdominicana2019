package edu.aluismarte.jconf.utils;

/**
 * Guarda el numero y la frecuencia que se repote el mismo
 * <p>
 * Created by aluis on 10/28/18.
 */
class Freq {

    private String number;
    private int freq;

    Freq(String number) {
        this.number = number;
        this.freq = 0;
    }

    public String getNumber() {
        return number;
    }

    int getFreq() {
        return freq;
    }

    synchronized void sumFreq() {
        freq++;
    }
}
