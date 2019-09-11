package eu.grigoriev.testing.netty.server;

import java.nio.charset.StandardCharsets;
import java.util.List;

import eu.grigoriev.testing.sockets.model.RequestData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

public class RequestDataDecoder extends ReplayingDecoder<RequestData> {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
        RequestData requestData = new RequestData();
        requestData.setIntValue(in.readInt());
        int length = in.readInt();
        requestData.setStringValue(in.readCharSequence(length, StandardCharsets.UTF_8).toString());
        out.add(requestData);
    }
}
