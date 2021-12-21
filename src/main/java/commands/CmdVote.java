package commands;


import core.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CmdVote implements Command {


    @Override
    public boolean called(String[] args, MessageReceivedEvent event){
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event){
        String pergunta = event.getMessage().getContentDisplay();
        pergunta = pergunta.replace("-vote","");
        event.getMessage().addReaction("U+1F7E2").queue();
        event.getMessage().addReaction("U+1F534").queue();
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}