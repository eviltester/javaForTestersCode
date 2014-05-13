package com.javafortesters.files;

import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReadTextFilesTest {

    @Test
    public void readATextFileWithBufferedReader() throws IOException {

        File inputFile = writeTheTestDataFile();

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        int lineCount = 0;

        try{
            String line;

            // readLine returns null when it reaches the end of the file
            while((line = reader.readLine())!=null){
                // readline strips off the end of line characters
                System.out.println("line number " + line.replace("line ",""));
                lineCount ++;
            }

            assertThat(lineCount, is(5));

        }finally{
            reader.close();
        }
    }


    @Test
    public void outputFileToSystemOutWithBufferedReader() throws IOException {

        File inputFile = writeTheTestDataFile();
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        try{
            String line;
            while((line = reader.readLine())!=null){
                System.out.println(line);
            }
        }finally{
            reader.close();
        }
    }

    private File writeTheTestDataFile() throws IOException {
        File outputFile = File.createTempFile("forReading", null);
        PrintWriter print = new PrintWriter(
                                new BufferedWriter(
                                    new FileWriter(outputFile)));

        for(int lineNumber = 1; lineNumber < 6; lineNumber++){
            print.println("line " + lineNumber);
        }

        print.close();
        return outputFile;
    }
}