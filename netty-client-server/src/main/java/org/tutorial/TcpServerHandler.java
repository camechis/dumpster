package org.tutorial;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.*;

/**
 * Created by IntelliJ IDEA.
 * User: edward
 * Date: 5/16/12
 * Time: 4:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class TcpServerHandler extends SimpleChannelHandler {

    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        System.out.println("Client connected!");

        Channel ch = e.getChannel();

        ChannelBuffer charBuffer = ChannelBuffers.buffer(4);
        charBuffer.writeInt(10);
        ChannelFuture f = ch.write(charBuffer);

        f.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                Channel ch = channelFuture.getChannel();
                ch.close();
            }
        });

    }
}
