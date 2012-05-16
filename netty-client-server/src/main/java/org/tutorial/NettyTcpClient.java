package org.tutorial;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

/**
 * Created by IntelliJ IDEA.
 * User: edward
 * Date: 5/16/12
 * Time: 4:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class NettyTcpClient {
    
    public static final int port = 8080;

    public static void main(String[] args) {

        ChannelFactory channelFactory = new NioClientSocketChannelFactory(Executors.newCachedThreadPool(),
                                                                          Executors.newCachedThreadPool());
        ClientBootstrap bootstrap = new ClientBootstrap(channelFactory);
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                return Channels.pipeline(new TcpClientHandler());
            }
        });

        bootstrap.setOption("tcpNoDelay", true);
        bootstrap.setOption("keepAlive", true);
        bootstrap.connect(new InetSocketAddress("localhost", port));
                
        
    }

}
