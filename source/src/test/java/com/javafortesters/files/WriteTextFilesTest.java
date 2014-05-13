package com.javafortesters.files;


import org.junit.Test;

import java.io.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WriteTextFilesTest {

    @Test
    public void outputWithFileWriter() throws IOException {
        File outputFile = File.createTempFile("fileWriter", null);

        FileWriter fileWriter = new FileWriter(outputFile);
        fileWriter.write("Simple Report With OutputWriter");
        fileWriter.write("===============================");
        fileWriter.close();

        assertThat(outputFile.length(), is(62L));
    }

    @Test
    public void outputWithPrintWriter() throws IOException {
        // this writes each string immediately and can be inefficient
        File outputFile = File.createTempFile("printWriter", null);
        FileWriter writer = new FileWriter(outputFile);
        PrintWriter print = new PrintWriter(writer);
        print.println("Simple Report Using PrintWriter");
        print.println("===============================");
        print.close();

        // printl adds end of line chars
        String lineEnd = System.lineSeparator();
        long fileLen = 62L + lineEnd.length() + lineEnd.length();
        assertThat(outputFile.length(), is(fileLen));
    }

    @Test
    public void useFileWriterToCreateTheFile() throws IOException {

        String tempDirectory = System.getProperty("java.io.tmpdir");
        String fileName = "fileWriterCreated" + String.valueOf(System.currentTimeMillis()) + ".tmp";
        File outputFile = new File(tempDirectory, fileName);

        // this writes each string immediately and can be inefficient
        FileWriter writer = new FileWriter(outputFile);
        PrintWriter print = new PrintWriter(writer);
        print.println("fileWriter Create a PrintWriter");
        print.println("===============================");
        print.close();

        // printl adds end of line chars
        String lineEnd = System.lineSeparator();
        long fileLen = 62L + lineEnd.length() + lineEnd.length();
        assertThat(outputFile.length(), is(fileLen));
    }

    @Test
    public void outputWithBufferedPrintWriter() throws IOException {
        // this writes each string to a buffer and makes output more efficient
        File outputFile = File.createTempFile("printWriter", null);
        FileWriter writer = new FileWriter(outputFile);
        BufferedWriter buffer = new BufferedWriter(writer);
        PrintWriter print = new PrintWriter(buffer);

        print.println("Simple Print to Buffered Writer");
        print.println("===============================");
        print.close();

        String lineEnd = System.lineSeparator();
        long fileLen = 62L + lineEnd.length() + lineEnd.length();
        assertThat(outputFile.length(), is(fileLen));
    }


}