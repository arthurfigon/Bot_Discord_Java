package commands;


import core.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CmdHelp implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event){
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event){
        event.getTextChannel().sendMessage("**COMANDOS: **\n `-help` - Mostra isso aqui..." +
                "\n`-ping` - Mostra o ping...").queue();
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
