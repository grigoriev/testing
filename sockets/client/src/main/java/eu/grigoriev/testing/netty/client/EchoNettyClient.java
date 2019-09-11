package eu.grigoriev.testing.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EchoNettyClient {

    public static void main(String[] args) throws Exception {

        String host = "localhost";
        int port = 8888;

        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            for (int i = 0; i < 1000; i++) {
                long start = System.currentTimeMillis();

                Bootstrap bootstrap = new Bootstrap();
                bootstrap.group(workerGroup);
                bootstrap.channel(NioSocketChannel.class);
                bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
                bootstrap.handler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    public void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(
                                new RequestDataEncoder(),
                                new ResponseDataDecoder(),
                                new EchoNettyClientHandler()
                        );
                    }
                });

                ChannelFuture channelFuture = bootstrap.connect(host, port).sync();

                channelFuture.channel().closeFuture().sync();

                long end = System.currentTimeMillis();
                log.info("time - " + (end - start));

            }
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
