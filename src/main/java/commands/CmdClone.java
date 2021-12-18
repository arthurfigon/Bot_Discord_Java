package commands;

import core.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CmdClone implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event){
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event){
        event.getTextChannel().deleteMessageById(event.getMessageId()).queue();
        String soTexto = event.getMessage().getContentDisplay();
        soTexto = soTexto.replace("-clone","");
        event.getTextChannel().sendMessage(soTexto).queue();
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}

