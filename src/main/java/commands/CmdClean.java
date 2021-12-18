package commands;



import core.Command;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

public class CmdClean implements Command {

    String termoExtra;

    @Override
    public boolean called(String[] args, MessageReceivedEvent event){
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event){
        MessageHistory history = new MessageHistory(event.getTextChannel());
        List<Message> messsages;

        messsages = history.retrievePast(50).complete();
        event.getTextChannel().deleteMessages(messsages).queue();
        event.getTextChannel().sendMessage(event.getAuthor().getName()+" " +
                "Obliterei-as como vossa majestade pediu...").queue();
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
