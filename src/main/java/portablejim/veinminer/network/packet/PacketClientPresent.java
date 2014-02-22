package portablejim.veinminer.network.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentTranslation;
import portablejim.veinminer.server.MinerServer;
import portablejim.veinminer.util.PlayerStatus;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: james
 * Date: 19/02/14
 * Time: 4:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class PacketClientPresent implements IPacket {

    public PacketClientPresent() {}

    @Override
    public void writeBytes(ByteBuf buffer) { }

    @Override
    public void readBytes(ByteBuf buffer) { }

    @Override
    public void handleClientSide(EntityClientPlayerMP player) { }

    @Override
    public void handleServerSide(EntityPlayerMP player) {
        UUID playerName = player.getUniqueID();

        MinerServer.instance.addClientPlayer(playerName);
        MinerServer.instance.setPlayerStatus(playerName, PlayerStatus.INACTIVE);
        player.addChatMessage(new ChatComponentTranslation("mod.veinminer.preferredmode.auto"));
    }
}
