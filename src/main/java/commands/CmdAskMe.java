package commands;

import core.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.Random;

public class CmdAskMe implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event){
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event){
        event.getTextChannel().sendMessage(event.getAuthor().getName()+": Quem pergunta quer uma resposta...").queue();
        event.getTextChannel().sendMessage("E para vc a resposta eh: **"+simOuNao()+"**").queue();
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }


    public static String simOuNao(){
        String resposta = "Sim!";
        Random gerador = new Random();
        int resultado = gerador.nextInt(2);
        if(resultado == 0){
            resposta = "Naum...";
        }
        return resposta;
    }
}
