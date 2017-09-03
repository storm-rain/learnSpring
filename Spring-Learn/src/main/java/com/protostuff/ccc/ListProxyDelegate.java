package com.protostuff.ccc;

import io.protostuff.*;
import io.protostuff.WireFormat.FieldType;
import io.protostuff.runtime.Delegate;
import javafx.beans.property.ListProperty;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class ListProxyDelegate implements Delegate
{
    @Override
    public FieldType getFieldType()
    {
        return FieldType.BYTES;
    }

    @Override
    public ArrayList readFrom(Input input) throws
            IOException
    {

        try
        {
            Schema<ArrayList> schema = ProtobufferDelegateCodec.getSchema(ArrayList.class);
            ArrayList message = new ArrayList();
            ProtostuffIOUtil.mergeFrom(input.readByteArray(),
                    message,
                    schema);
            return message;
        } catch (Exception e)
        {
            throw new IllegalStateException(e.getMessage(),
                    e);
        }
    }

    @Override
    public void writeTo(Output output, int number, Object value, boolean repeated) throws
            IOException
    {
        List list = ((ListProxy)value).getList();
        Class cls = (Class) list.getClass();
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        try
        {
            Schema schema = ProtobufferDelegateCodec.getSchema(cls);
            byte[] bytes = ProtostuffIOUtil.toByteArray(list,
                    schema,
                    buffer);
            output.writeByteArray(number,bytes,repeated);
        } catch (Exception e)
        {
            throw new IllegalStateException(e.getMessage(),
                    e);
        } finally
        {
            buffer.clear();
        }

    }

    @Override
    public void transfer(Pipe pipe, Input input, Output output, int number, boolean repeated) throws
            IOException
    {
        output.writeObject(number,input.readByteArray(),ProtobufferDelegateCodec.getSchema(byte[].class),repeated);
    }

    @Override
    public Class<?> typeClass()
    {
        return ListProxy.class;
    }
}
