package commands;

import core.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.Random;

public class CmdDice implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event){
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event){
        String soTexto = event.getMessage().getContentDisplay();
        soTexto = soTexto.replace("-dice ","");
        event.getTextChannel().sendMessage(event.getAuthor().getName()+": "+soTexto).queue();
        soTexto = rolarDado(args[0]);
        event.getTextChannel().sendMessage(soTexto).queue();
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }

    public static String rolarDado(String dado){
        int posicaoLetraD = dado.indexOf("d");
        int numeroDados = 0;
        String numeroString = "";
        int valorDados = 0;
        String valorString = "";
        int valorFinal = 0;
        String resultadoFinal = "Resultado: ";
        for(int i = 0; i < posicaoLetraD; i++) {
            numeroString += dado.charAt(i);
        }
        for(int i = posicaoLetraD+1; i < dado.length();i++){
            valorString += dado.charAt(i);
        }
        numeroDados = Integer.parseInt(numeroString);
        valorDados = Integer.parseInt(valorString);
        int[] dados = new int[numeroDados];

        Random gerador = new Random();
        for (int i = 0; i < numeroDados; i++) {
            int numeroDaVez = gerador.nextInt(valorDados)+1;
            valorFinal += numeroDaVez;
            dados[i] = numeroDaVez;
        }
        OrdenaCrescenteInt(dados);
        for(int i = 0; i < dados.length; i++){
            resultadoFinal += String.valueOf(dados[i]);
            if (i == dados.length - 1){
                resultadoFinal += " ";
            } else{
                resultadoFinal += ", ";
            }
        }
        resultadoFinal += "( "+ valorFinal +" )";

        System.out.printf("Numero Dado: %d\n" +
                "Valor Dado: %d\n", numeroDados,valorDados);

        return String.valueOf(resultadoFinal);
    }

    private static void OrdenaCrescenteInt(int[] vetor){
        int variavelTroca;
        for(int a=0;a<vetor.length-1;a++) {
            for (int i = 0; i < vetor.length - 1; i++) {
                if (vetor[i] > vetor[i+1]) {
                    variavelTroca = vetor[i + 1];
                    vetor[i + 1] = vetor[i];
                    vetor[i] = variavelTroca;
                }
            }
            if(verificaOrdenaCrescenteInt(vetor))
                a = vetor.length;
        }
    }

    private static boolean verificaOrdenaCrescenteInt(int[] vetor){
        for (int i = 0; i < vetor.length-1; i++) {
            if (vetor[i] > vetor[i+1]){
                return false;
            }
        }
        return true;
    }
}

