import commands.*;
import core.CommandHandler;
import core.MessageListener;
import listeners.ReadyListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;



public class Main {
    public static void main(String[] args) {
        JDABuilder builder = JDABuilder
                .createDefault("")
                .setAutoReconnect(true);

        builder.addEventListeners(new MessageListener());
        builder.addEventListeners(new ReadyListener());

        CommandHandler.commands.put("help", new CmdHelp());
        CommandHandler.commands.put("ping", new CmdPing());
        CommandHandler.commands.put("bobaum", new CmdBobaum());
        CommandHandler.commands.put("clean", new CmdClean());
        CommandHandler.commands.put("join", new CmdEnterChannel());
        CommandHandler.commands.put("leave", new CmdLeaveChannel());
        CommandHandler.commands.put("clone", new CmdClone());
        CommandHandler.commands.put("dice", new CmdDice());
        CommandHandler.commands.put("askme", new CmdAskMe());
        CommandHandler.commands.put("alternativa", new CmdAlternativa());
        CommandHandler.commands.put("acorda", new CmdAcorda());
        CommandHandler.commands.put("vote", new CmdVote());

        try{
            jda = builder.build();
        }catch(LoginException e){
            e.printStackTrace();
        }
    }

    static JDA jda;
}
