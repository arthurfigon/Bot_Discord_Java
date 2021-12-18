package core;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import utils.Utils;

import java.util.ArrayList;

public class CommandParser {

    //help 0 argumentos
    //help 1 argumento   arg[1] = "1"
    public CommandContainer parse (String raw, MessageReceivedEvent event){
        String beheaded = raw.replaceFirst(Utils.getPrefix, "");
        String[] splitBeheaded = beheaded.split(" ");
        String invoke = splitBeheaded[0];
        ArrayList<String> split = new ArrayList<>();
        for(String value: splitBeheaded){
            split.add(value);
        }
        String[] args = new String[split.size() - 1];
        split.subList(1, split.size()).toArray(args);

        return new CommandContainer(raw, beheaded, splitBeheaded, invoke, args, event);
    }

    public class CommandContainer{
        public final String raw;
        public final String beheaded;
        public final String[] splitBeheaded;
        public final String invoke;
        public final String[] args;
        public final MessageReceivedEvent event;

        public CommandContainer(String raw, String beheaded, String[] splitBeheaded,
                                String invoke, String[] args, MessageReceivedEvent event){
            this.raw = raw;
            this.beheaded = beheaded;
            this.splitBeheaded = splitBeheaded;
            this.invoke = invoke;
            this.args = args;
            this.event = event;
        }

    }
}
