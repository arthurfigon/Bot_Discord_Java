package core;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import utils.Utils;

public class MessageListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getAuthor().isBot()){return ;}
        if(event.getChannelType() == ChannelType.PRIVATE){
            event.getAuthor().openPrivateChannel().complete().sendMessage("**"
                    +event.getAuthor().getName()+"** fala cmg naum, parcero...").queue();
            return;
        }

        String message = event.getMessage().getContentDisplay();
        if(message.startsWith(Utils.getPrefix) && event.getAuthor().getId() !=
                event.getJDA().getSelfUser().getId()){
            CommandHandler.handleCommand(CommandHandler.parser.parse(message, event));
        }
    }
}
