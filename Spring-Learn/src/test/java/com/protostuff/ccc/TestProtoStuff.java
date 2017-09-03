package com.protostuff.ccc;

import org.junit.Test;

import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TestProtoStuff
{
    @Test
    public void test()
    {
        User user = new User("ccc",
                2,
                new ListProxy(new ArrayList()));
        //        user.setAge(2);
        //        user.setName("ccc");
        user.addAddress("anhui");

        ProtobufferCodec codec = new ProtobufferCodec();
        byte[] bytes = codec.encode(user);

        User user1 = codec.decode(bytes,
                User.class);

        System.out.println(user1.getName());
        System.out.println(user1.getAddress(0));
    }

    @Test
    public void testListProxy()
    {
        List<String> list = new ArrayList<>();
        ListProxy proxy = new ListProxy(list);
        list.add("ccc");

        ProtobufferCodec codec = new ProtobufferCodec();
        byte[] bytes = codec.encode(proxy);

        List listProxy = codec.decode(bytes,
                ListProxy.class);

        System.out.println(listProxy.get(0));
    }

    @Test
    public void testDelegate()
    {
        User user = new User("ccc",
                2,
                new ListProxy(new ArrayList()));
        //        user.setAge(2);
        //        user.setName("ccc");
        user.addAddress("anhui");

        ProtobufferDelegateCodec codec = new ProtobufferDelegateCodec();

        byte[] bytes = codec.encode(user);

        try
        {
            OutputStream out = new FileOutputStream("D://test.txt");

            out.write(bytes);

            out.close();
        } catch (Exception e)

        {
            e.printStackTrace();
        }

                User user1 = new ProtobufferCodec().decode(bytes,
                       User.class);

                System.out.println(user1.getName());
                System.out.println(user1.getAddress(0));
    }


    @Test
    public void decode()
    {
        byte[] bytes = new byte[16];
        InputStream in = new InputStream()
        {
            @Override
            public int read() throws
                    IOException
            {
                return 0;
            }
        };

        try
        {
             in = new FileInputStream("D://test.txt");

            in.read(bytes);

        } catch (Exception e)
        {
            e.printStackTrace();
        }


        User user1 = new ProtobufferCodec().decode(bytes,
                User.class);

        System.out.println(user1.getName());
        System.out.println(user1.getAddress(0));
    }

    @Test
    public void testTimeStamp()
    {
        Timer timer = new Timer();
        timer.setTimestamp(new Timestamp(System.currentTimeMillis()));

        ProtobufferDelegateCodec codec = new ProtobufferDelegateCodec();
        byte[] bytes = codec.encode(timer);

        Timer timer1 = codec.decode(bytes,
                Timer.class);

        System.out.println(timer1.getTimestamp());
    }
}
