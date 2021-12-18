package commands;

import core.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.Random;

public class CmdAlternativa implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event){
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event){
        event.getTextChannel().sendMessage(event.getAuthor().getName()+": Deixa eu ver aqui...").queue();
        event.getTextChannel().sendMessage("A resposta certa eh: **"+alternativa()+"**").queue();
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }


    public static String alternativa(){
        String resposta = "";
        Random gerador = new Random();
        int resultado = gerador.nextInt(5);
        switch (resultado){
            case 0 -> resposta="A";
            case 1 -> resposta="B";
            case 2 -> resposta="C";
            case 3 -> resposta="D";
            case 4 -> resposta="E";
        }
        return resposta;
    }
}
