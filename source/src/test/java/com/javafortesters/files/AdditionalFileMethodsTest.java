package com.javafortesters.files;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AdditionalFileMethodsTest {


    @Test
    public void spaceMethods() throws IOException {

        File temp = new File(System.getProperty("java.io.tmpdir"));

        long freeSpace = temp.getFreeSpace();
        long totalSpace = temp.getTotalSpace();
        long usableSpace = temp.getUsableSpace();

        File outputFile = writeTheTestDataFile(5);
        assertThat(outputFile.length(), is(expectedFileSize(5)));

        System.out.println("Length " + outputFile.length() );
        System.out.println("Free " + freeSpace );
        System.out.println("Total " + totalSpace );
        System.out.println("Usable " + usableSpace);
    }

    private long expectedFileSize(int lines){
        String lineEnd = System.lineSeparator();
        return (("line x".length() + lineEnd.length())*lines);
    }

    private File writeTheTestDataFile(int lines) throws IOException {
        File outputFile = File.createTempFile("forReading" + lines + "_", null);
        PrintWriter print = new PrintWriter(new BufferedWriter( new FileWriter(outputFile)));

        for(int line=0; line<lines; line++){
            print.println("line " + lines);
        }

        print.close();

        return outputFile;
    }



}