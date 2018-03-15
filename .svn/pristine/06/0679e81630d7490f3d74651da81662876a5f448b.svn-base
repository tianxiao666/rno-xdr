package com.hgicreate.rno.repository.io;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * Created by hadoop on 17-1-14.
 */
public class CsvResponseWriter extends Writer {
    private HttpServletResponse response;
    private String fileName;
    private Writer writer;
//    private OutputStream outputStream;

    public CsvResponseWriter(HttpServletResponse response, String fileName) throws IOException {
        this.response = response;
        this.fileName = fileName;
        this.initResponse();
        this.writer = this.response.getWriter();
//        this.write(getChars(new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF}));
    }

    public void setContent(String csvContent) throws IOException {
        PrintWriter writer = this.response.getWriter();
        writer.println(csvContent);
    }

    private void initResponse() throws UnsupportedEncodingException {
//        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes("GBK"), "iso8859-1"));
    }
    private char[] getChars (byte[] bytes) {
        Charset cs = Charset.forName ("UTF-8");
        ByteBuffer bb = ByteBuffer.allocate (bytes.length);
        bb.put (bytes);
        bb.flip ();
        CharBuffer cb = cs.decode (bb);

        return cb.array();
    }
    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        this.writer.write(cbuf, off, len);
    }

    @Override
    public void flush() throws IOException {
        this.flush();
    }

    @Override
    public void close() throws IOException {
        this.close();
    }
}
