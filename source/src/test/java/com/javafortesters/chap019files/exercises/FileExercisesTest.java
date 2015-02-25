package com.javafortesters.chap019files.exercises;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FileExercisesTest {

    @Test
    public void createTempFileVaryTheParameters() throws IOException {
        // on windows these files are in %TEMP%
        File temp1 = File.createTempFile("temp1", null);
        File temp2 = File.createTempFile("temp2OutFile", ".out");

        assertThat(temp1.exists(), is(true));
        assertThat(temp2.exists(), is(true));

        temp1.deleteOnExit();
        temp2.deleteOnExit();
    }


    @Test
    public void writeOutTheFileListRoots(){
        File[] roots = File.listRoots();
        Assert.assertTrue(roots.length > 0);

        for(File aFile : roots){
            System.out.println(aFile.getAbsolutePath());
        }
    }


    @Test
    public void createATempFileWithCustomCode() throws IOException {

        String directory = System.getProperty("java.io.tmpdir");
        String fileName = "prefix" + System.currentTimeMillis() + ".tmp";

        File aTempFile = new File(directory, fileName);
        assertThat(aTempFile.exists(), is(false));

        aTempFile.createNewFile();
        assertThat(aTempFile.exists(), is(true));

        aTempFile.delete();
        assertThat(aTempFile.exists(), is(false));
    }



    @Test
    public void writeATestToCheckCanonicalConversion() throws IOException {

        File absolute1 = new File("C:/1/2/3/4/../../..");
        File absolute2 = new File("C:/1/2/../../1");
        File canonical = new File("C:/1");

        assertThat(canonical.getAbsolutePath(),
                is(canonical.getCanonicalPath()));
        assertThat(canonical.getAbsolutePath(),
                is(absolute1.getCanonicalPath()));
        assertThat(canonical.getAbsolutePath(),
                is(absolute2.getCanonicalPath()));

        assertThat(absolute1.getAbsolutePath().contains(".."), is(true));
        assertThat(absolute2.getAbsolutePath().contains(".."), is(true));
    }


    @Test
    public void checkThatTheTempDirectoryIsADirectory(){
        File tempDir = new File(System.getProperty("java.io.tmpdir"));

        assertThat(tempDir.isDirectory(), is(true));
        assertThat(tempDir.isFile(), is(false));
    }

    @Test
    public void exerciseWriteToAPrintWriterThenAppend() throws IOException {
        File outputFile = File.createTempFile("printWriterPrint", null);

        System.out.println("Check file " + outputFile.getAbsolutePath());

        FileWriter writer = new FileWriter(outputFile);
        BufferedWriter buffer = new BufferedWriter(writer);
        PrintWriter print = new PrintWriter(buffer);

        print.println("Append Print to Buffered Writer");

        print.close();

        // append to the file
        writer = new FileWriter(outputFile, true);
        buffer = new BufferedWriter(writer);
        print = new PrintWriter(buffer);
        print.println("===============================");
        print.close();

        String lineEnd = System.lineSeparator();
        long fileLen = 62L + lineEnd.length() + lineEnd.length();
        assertThat(outputFile.length(), is(fileLen));
    }

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
        File outputFile = File.createTempFile(
                                    "forReading" + lines + "_", null);
        PrintWriter print = new PrintWriter(
                                new BufferedWriter(
                                        new FileWriter(outputFile)));
        for(int line=0; line<lines; line++){
            print.println("line " + lines);
        }
        print.close();
        return outputFile;
    }



    @Test
    public void listTempDirectory(){
        File tempDir = new File(System.getProperty("java.io.tmpdir"));
        File[] fileList = tempDir.listFiles();

        for(File fileInList : fileList){
            String outputString = "";
            if(fileInList.isDirectory()){
                outputString = outputString + "DIR: ";
            }else{
                outputString = outputString + "FIL: ";
            }

            outputString = outputString + fileInList.getName();
            System.out.println(outputString);
        }
    }


    @Test
    public void listTempDirectoryAttribs(){
        File tempDir = new File(System.getProperty("java.io.tmpdir"));
        File[] fileList = tempDir.listFiles();

        for(File fileInList : fileList){
            String outputString = "";
            if(fileInList.isDirectory()){
                outputString = outputString + "DIR: ";
            }else{
                outputString = outputString + "FIL: ";
            }

            if(fileInList.canRead()){
                outputString = outputString + "r";
            }else{
                outputString = outputString + "-";
            }

            if(fileInList.canWrite()){
                outputString = outputString + "w";
            }else{
                outputString = outputString + "-";
            }

            if(fileInList.canExecute()){
                outputString = outputString + "x";
            }else{
                outputString = outputString + "-";
            }

            outputString = outputString + " - " + fileInList.getName();

            SimpleDateFormat sdf = new SimpleDateFormat("y M d HH:mm:ss.SSS");
            String lastModified =
                            sdf.format(new Date(fileInList.lastModified()));

            outputString = outputString + " => " + lastModified;
            System.out.println(outputString);
        }
    }
}