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
                "\n`-ping` - Mostra o ping...\n`-dice` - Rola dados no formato 1d1..." +
                "\n`-join` - Entra no chat de voz...\n`-leave` - Sai da sala de voz..." +
                "\n`-clone` - Copia sua mensagem...\n`-clean` - Limpa algumas mensagens antigas...\n" +
                "`-bobaum` - Descobre ai pow...\n`-askme` - Faz uma pergunta para mim..." +
                "\n`-alternativa` - Quer saber a resposta?").queue();
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
