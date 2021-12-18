package commands;

import core.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CmdBobaum implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event){
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event){
        event.getTextChannel().sendMessage("Naum to afim **"+event.getAuthor().getName()+"**...\n" +
                "Olha a cara do Bobaum: ").queue();
        event.getTextChannel().sendMessage(event.getAuthor().getAvatarUrl()).queue();
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
