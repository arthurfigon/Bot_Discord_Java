package listeners;

import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReadyListener extends ListenerAdapter {

    public void onReady(ReadyEvent event){
        event.getJDA().getTextChannelById("920834627046879278")
                .sendMessage("Armado e preparado!").queue();
    }

}
