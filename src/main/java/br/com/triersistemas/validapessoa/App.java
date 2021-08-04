package br.com.triersistemas.validapessoa;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        
        PessoaFisica fisica = new PessoaFisica("28001238938");
        fisica.verificar();
        
        PessoaJuridica juridica = new PessoaJuridica("18781203000128");
        juridica.verificar();
    }
}
