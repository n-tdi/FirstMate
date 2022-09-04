package world.ntdi.firstmate.events;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JoinEvent extends ListenerAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(JoinEvent.class);

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent e) {
        Role crewmate =e.getJDA().getRoleById(1015368320905642015L);

        if (crewmate != null) {
            e.getGuild().addRoleToMember(e.getMember(), crewmate).queue();
        } else {
            LOGGER.error("Unable to find CREWMATE role!");
        }

        e.getGuild().getDefaultChannel().asTextChannel().sendMessage(e.getUser().getAsMention() + " has boarded **Row's Boat**").queue();
    }
}
