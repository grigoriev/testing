package eu.grigoriev.testing.netty.client;

import java.nio.charset.StandardCharsets;
import java.util.List;

import eu.grigoriev.testing.sockets.model.ResponseData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

public class ResponseDataDecoder extends ReplayingDecoder<ResponseData> {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        ResponseData responseData = new ResponseData();
        responseData.setIntValue(in.readInt());
        int length = in.readInt();
        responseData.setStringValue(in.readCharSequence(length, StandardCharsets.UTF_8).toString());
        out.add(responseData);
    }
}
