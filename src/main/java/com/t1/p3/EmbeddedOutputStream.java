package com.t1.p3;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EmbeddedOutputStream extends OutputStream{
    public EmbeddedOutputStream(DataOutputStream outputStream)  {
    }

    @Override
    public void write(int b) throws IOException {

    }
}
