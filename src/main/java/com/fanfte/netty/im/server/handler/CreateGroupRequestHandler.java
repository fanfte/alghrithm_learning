package com.fanfte.netty.im.server.handler;

import com.fanfte.netty.im.packet.request.CreateGroupRequestPacket;
import com.fanfte.netty.im.packet.response.CreateGroupResponsePacket;
import com.fanfte.netty.im.util.IDUtil;
import com.fanfte.netty.im.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianen on 2018/10/8
 *
 * @author fanfte
 * @date 2018/10/8
 **/
public class CreateGroupRequestHandler extends SimpleChannelInboundHandler<CreateGroupRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupRequestPacket msg) throws Exception {
        // 1. 创建一个 channel 分组
        ChannelGroup channelGroup = new DefaultChannelGroup(ctx.executor());
        List<String> userIdList = msg.getUserIdList();
        List<String> usernameList = new ArrayList<>();

        // 2. 筛选出待加入群聊的用户的 channel 和 username
        for(String userId : userIdList) {
            Channel channel = SessionUtil.getChannel(userId);
            if(channel != null) {
                channelGroup.add(channel);
                usernameList.add(SessionUtil.getSession(channel).getUsername());
            }
        }
        // 3. 创建群聊创建结果的响应
        CreateGroupResponsePacket createGroupResponsePacket = new CreateGroupResponsePacket();
        createGroupResponsePacket.setSuccess(true);
        createGroupResponsePacket.setGroupId(IDUtil.randomId());
        createGroupResponsePacket.setUserNameList(usernameList);

        // 4. 给每个客户端发送拉群通知
        channelGroup.writeAndFlush(createGroupResponsePacket);
        System.out.print("群创建成功,id为[" + createGroupResponsePacket.getGroupId() + "]");
        System.out.println("群成员有: " + createGroupResponsePacket.getUserNameList());

        // 绑定groupId和Group
        SessionUtil.bindChannelGroup(createGroupResponsePacket.getGroupId(), channelGroup);
    }
}
