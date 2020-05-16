package com.example.notasTeste;

import java.util.Arrays;

public class Aluno {
    private double VermlehaThreshold = 7;
    public double[] Notas = new double[5];
    public boolean Passou(){
        int VermelhaCount = 0;
        for (double nota : Notas) {
            if(nota < VermlehaThreshold ){
                VermelhaCount++;
            }
        }
        return ((Notas.length - VermelhaCount) > VermelhaCount);
    }
    Aluno(){
        Arrays.fill(Notas, 0);
    }
}
