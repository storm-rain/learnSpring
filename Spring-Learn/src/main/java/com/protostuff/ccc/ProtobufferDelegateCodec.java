package com.protostuff.ccc;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.DefaultIdStrategy;
import io.protostuff.runtime.Delegate;
import io.protostuff.runtime.RuntimeEnv;
import io.protostuff.runtime.RuntimeSchema;

import java.sql.Timestamp;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ProtoBuffer编解码
 *
 * @author jiujie
 * @version $Id: ProtobufferCodec.java, v 0.1 2016年7月20日 下午1:52:41 jiujie Exp $
 */
public class ProtobufferDelegateCodec implements Codec
{
    /**
     * 时间戳转换Delegate，解决时间戳转换后错误问题 @author jiujie 2016年7月20日 下午1:52:25
     */
    private final static Delegate<Timestamp> TIMESTAMP_DELEGATE = new TimeStampDelegate();

    private final static Delegate<ListProxy> LIST_PROXY_DELEGATE = new ListProxyDelegate();

    private final static DefaultIdStrategy idStrategy = ((DefaultIdStrategy) RuntimeEnv.ID_STRATEGY);

    private final static ConcurrentHashMap<Class<?>, Schema<?>> cachedSchema = new ConcurrentHashMap<>();

    static
    {
        idStrategy.registerDelegate(TIMESTAMP_DELEGATE);
        idStrategy.registerDelegate(LIST_PROXY_DELEGATE);
    }

    public ProtobufferDelegateCodec()
    {
    }

    @Override
    public short getId()
    {
        return 120;
    }

    @SuppressWarnings("unchecked")
    public static <T> Schema<T> getSchema(Class<T> clazz)
    {
        Schema<T> schema = (Schema<T>) cachedSchema.get(clazz);
        if (schema ==
                null)
        {
            schema = RuntimeSchema.createFrom(clazz,
                    idStrategy);
            cachedSchema.put(clazz,
                    schema);
        }
        return schema;
    }

    @Override
    public <T> byte[] encode(T obj)
    {
        if (obj ==
                null)
        {
            return null;
        }
        @SuppressWarnings("unchecked") Class<T> cls = (Class<T>) obj.getClass();
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        try
        {
            Schema<T> schema = getSchema(cls);
            byte[] bytes = ProtostuffIOUtil.toByteArray(obj,
                    schema,
                    buffer);
            return bytes;
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
    public <T> T decode(byte[] bytes, Class<T> clazz)
    {
        if (bytes ==
                null ||
                bytes.length ==
                        0)
        {
            return null;
        }
        try
        {
            Schema<T> schema = getSchema(clazz);
            //改为由Schema来实例化解码对象，没有构造函数也没有问题
            T message = schema.newMessage();
            ProtostuffIOUtil.mergeFrom(bytes,
                    message,
                    schema);
            return message;
        } catch (Exception e)
        {
            throw new IllegalStateException(e.getMessage(),
                    e);
        }
    }

}