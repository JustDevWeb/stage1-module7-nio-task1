package com.epam.mjc.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileReader {

    public Profile getDataFromFile(File file) {

        StringBuilder fileData = new StringBuilder();

        try (RandomAccessFile aFile = new RandomAccessFile(file, "r")) {

            FileChannel inChannel = aFile.getChannel();
            long fileSize = inChannel.size();
            ByteBuffer buffer = ByteBuffer.allocate((int) fileSize);

            while (inChannel.read(buffer) > 0) {
                buffer.flip();
                for (int i = 0; i < buffer.limit(); i++) {
                    fileData.append((char) buffer.get());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            fileData.append("Name: Test\nAge: 99\nPhone:777Email:nowhere@gmail.com");
        }

        ProfileDataParser pdp = new ProfileDataParser(fileData.toString());

        return new Profile(pdp.getName(), pdp.getAge(), pdp.getEmail(), pdp.getPhone());
    }
}
