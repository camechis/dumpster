package org.tutorial;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.*;

import java.nio.CharBuffer;

/**
 * Created by IntelliJ IDEA.
 * User: edward
 * Date: 5/16/12
 * Time: 4:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class TcpClientHandler extends SimpleChannelHandler {

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        ChannelBuffer buf = (ChannelBuffer) e.getMessage();
        System.out.println(buf.readInt());
        e.getChannel().close();
    }
}
