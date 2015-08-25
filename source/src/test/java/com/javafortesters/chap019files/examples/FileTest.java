package com.javafortesters.chap019files.examples;


import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FileTest {


    // when running cross platform there are differences to be aware of
    // the system properties may not have a / at the end
    // and building file paths by hand can be problematic requiring
    // lots of care
    // so we use the Paths.get instead
    // http://docs.oracle.com/javase/7/docs/api/java/nio/file/Paths.html
    // Then use the returned Path object toFile to create the file object
    // Both Path and Paths have been available since Java 1.7
    // https://docs.oracle.com/javase/8/docs/api/java/nio/file/Path.html


    @Test
    public void aNewFileDoesNotCreateAFile() throws IOException {
        File aTempFile = new File("d:/tempJavaForTesters.txt");
        assertThat(aTempFile.exists(), is(false));
    }

    @Test
    public void pathsGetExampleForCrossPlatform() throws IOException {

        String tempDir = System.getProperty("java.io.tmpdir");

        // you would probably just use File for this one
        File theFile = Paths.get(tempDir, "file.txt").toFile();
        assertThat(theFile.getAbsolutePath(),
                    endsWith(File.separator + "file.txt"));

        theFile = Paths.get(tempDir, "temp1", "file.txt").toFile();
        assertThat(theFile.getAbsolutePath(),
                endsWith(String.format("%s%s%1$s%s",
                            File.separator, "temp1", "file.txt")));

        theFile = Paths.get(tempDir, "temp1","temp2", "temp3", "file.txt").toFile();
        assertThat(theFile.getAbsolutePath(),
                endsWith(String.format("%s%s%1$s%s%1$s%s%1$s%s",
                            File.separator, "temp1", "temp2", "temp3", "file.txt")));
    }


/*
    @Test
    public void createAFileAndDeleteIt() throws IOException {
        File aTempFile = new File("d:/tempJavaForTesters.txt");
        assertThat(aTempFile.exists(), is(false));

        aTempFile.createNewFile();
        assertThat(aTempFile.exists(), is(true));

        aTempFile.delete();
        assertThat(aTempFile.exists(), is(false));
    }
*/

    // since the above example is commented out
    // this checks that the basic code works
    // in a platform independent way using Paths
    @Test
    public void createAFileAndDeleteItCodeCheck() throws IOException {

        /* for documentation of simple path
        File aTempFile = Paths.get("d:", "tempJavaForTesters.txt").toFile();
        */

        String tempDir = System.getProperty("java.io.tmpdir");
        File aTempFile = Paths.get(tempDir, "tempJavaForTesters.txt").toFile();

        assertThat(aTempFile.exists(), is(false));

        aTempFile.createNewFile();
        assertThat(aTempFile.exists(), is(true));

        aTempFile.delete();
        assertThat(aTempFile.exists(), is(false));
    }


    @Test
    public void createAFileAndDeleteItAlternativeConstructor() throws IOException {

        String tempDir = System.getProperty("java.io.tmpdir");
        File aTempFile = new File(tempDir, "tempJavaForTesters.txt");
        assertThat(aTempFile.exists(), is(false));

        aTempFile.createNewFile();
        assertThat(aTempFile.exists(), is(true));

        aTempFile.delete();
        assertThat(aTempFile.exists(), is(false));
    }

    @Test
    public void createLongerPathExample(){

        String tempDirectory = System.getProperty("java.io.tmpdir");
        File aFile = new File(tempDirectory);
        aFile = new File(aFile, "1");
        aFile = new File(aFile, "2");
        aFile = new File(aFile, "3");
        aFile = new File(aFile, "4");

        // make it an easy cross platform comparison
        String filePathWithDots = aFile.getAbsolutePath().replace(File.separator, ".");
        assertTrue(filePathWithDots.endsWith(".1.2.3.4"));

        Path aPath = Paths.get(tempDirectory, "1", "2", "3", "4");
        assertEquals(aFile.getAbsolutePath(),
                     aPath.toFile().getAbsolutePath());
    }



    @Test
    public void canonicalVsAbsolute() throws IOException {

        String tempDirectory = System.getProperty("java.io.tmpdir");

        // create a directory path
        // temp\<millis>\1\2\3\4\5
        // temp\<millis>\1
        // temp\<millis>\1\2\3\4\..\..\..
        // temp\<millis>\1\2\..\..\..\1

        String currentMillis = String.valueOf(System.currentTimeMillis());

        File bFile = new File(tempDirectory);
        System.out.println(bFile.getName());

        File aFile = new File(tempDirectory, currentMillis);
        File oneDirectory = new File(aFile, "1");
        aFile = new File(oneDirectory, "2");
        aFile = new File(aFile, "3");
        aFile = new File(aFile, "4");
        aFile = new File(aFile, "5");

        aFile.mkdirs();

        System.out.println(oneDirectory.getAbsolutePath());
        System.out.println(oneDirectory.getCanonicalPath());
        System.out.println(aFile.getAbsolutePath());

        assertTrue(oneDirectory.getCanonicalPath().endsWith(oneDirectory.getAbsolutePath()));

        File relative = new File(tempDirectory, currentMillis);
        relative = new File(relative, "1");
        relative = new File(relative, "2");
        relative = new File(relative, "3");
        relative = new File(relative, "4");
        relative = new File(relative, "..");   //3
        relative = new File(relative, "..");   //2
        relative = new File(relative, "..");   //1

        System.out.println(relative.getAbsolutePath());

        assertTrue(relative.getCanonicalPath().endsWith(oneDirectory.getAbsolutePath()));

        relative = new File(tempDirectory, currentMillis);
        relative = new File(relative, "1");
        relative = new File(relative, "2");
        relative = new File(relative, "..");   //1
        relative = new File(relative, "..");   //millis
        relative = new File(relative, "1");   //1

        System.out.println(relative.getAbsolutePath());

        assertTrue(relative.getCanonicalPath().endsWith(oneDirectory.getAbsolutePath()));
    }


    @Test
    public void mkdirsCreatesIntermediateDirs(){

        String tempDirectory = System.getProperty("java.io.tmpdir");

        File aDirectory = Paths.get(tempDirectory,
                                    Long.toString(System.currentTimeMillis()),
                                    Long.toString(System.currentTimeMillis()))
                                .toFile();

        System.out.println(aDirectory.getAbsolutePath());

        assertThat(aDirectory.mkdir(), is(false));
        assertThat(aDirectory.mkdirs(), is(true));
    }


    @Test
    public void mkdirsCreatesDirectories(){

        String tempDirectory = System.getProperty("java.io.tmpdir");

        File aFilePath = Paths.get(tempDirectory,
                                    Long.toString(System.currentTimeMillis()),
                                    "test.tmp")
                                .toFile();

        System.out.println(aFilePath.getAbsolutePath());

        // mkdir won't create this because it is temp/millis/test.tmp

        assertThat(aFilePath.mkdir(), is(false));
        assertThat(aFilePath.exists(), is(false));

        // mkdir will create because it is just the temp/millis
        File aDirectoryPath = Paths.get(tempDirectory,
                                        Long.toString(System.currentTimeMillis()))
                                    .toFile();

        assertThat(aDirectoryPath.mkdir(), is(true));

    }

    @Test
    public void fileAndPathSeparator(){
        assertTrue("Unrecognised OS file separator",
                        File.separator.equals("\\") ||
                        File.separator.equals("/"));
        assertTrue("Unrecognised OS path separator",
                        File.pathSeparator.equals(";") ||
                        File.pathSeparator.equals(":"));
    }

    @Test
    public void createATempFileAndDeleteOnExit(){

        try {
            File aTempFile = File.createTempFile("prefix", "suffix");
            aTempFile.deleteOnExit();

            System.out.println(aTempFile.getAbsolutePath());

            String tempDirectory = System.getProperty("java.io.tmpdir");

            assertThat( aTempFile.getName().startsWith("prefix"), is(true));
            assertThat( aTempFile.getName().endsWith("suffix"), is(true));

            assertTrue(System.getProperty("java.io.tmpdir").
                    startsWith(aTempFile.getParent()));

            assertThat(aTempFile.getAbsolutePath().endsWith("suffix"),
                       is(true));
            assertThat(aTempFile.getAbsolutePath().startsWith(
                          System.getProperty("java.io.tmpdir")), is(true));

            assertThat(aTempFile.getCanonicalPath().endsWith("suffix"),
                       is(true));
            assertThat(aTempFile.getCanonicalPath().contains(
                    System.getProperty("java.io.tmpdir")), is(true));

            assertThat(aTempFile.exists(), is(true));

            // the prefix needs to be 3 chars or longer otherwise java.lang.IllegalArgumentException is thrown
            String userDirectory = System.getProperty("user.dir");

            aTempFile = File.createTempFile("pre", null,
                                new File(System.getProperty("user.dir")));

            System.out.println(aTempFile.getAbsolutePath());
            aTempFile.deleteOnExit();

            assertThat(aTempFile.getAbsolutePath().endsWith(".tmp"), is(true));
            assertThat(aTempFile.getAbsolutePath().startsWith(userDirectory), is(true));

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }

    @Test
    public void listTempDirectory(){
        File tempDir = new File(System.getProperty("java.io.tmpdir"));

        String[] fileList = tempDir.list();

        for(String fileInList : fileList){
            System.out.println(fileInList);
        }
    }

}