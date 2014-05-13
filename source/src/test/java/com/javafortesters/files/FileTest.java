package com.javafortesters.files;


import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FileTest {



    @Test
    public void aNewFileDoesNotCreateAFile() throws IOException {

        File aTempFile = new File("d:/tempJavaForTesters.txt");

        assertThat(aTempFile.exists(), is(false));
    }


    @Test
    public void createAFileAndDeleteIt() throws IOException {

        File aTempFile = new File("d:/tempJavaForTesters.txt");

            assertThat(aTempFile.exists(), is(false));

        aTempFile.createNewFile();

            assertThat(aTempFile.exists(), is(true));

        aTempFile.delete();

            assertThat(aTempFile.exists(), is(false));
    }

    @Test
    public void createAFileAndDeleteItAlternativeConstructor() throws IOException {

        File aTempFile = new File("d:", "tempJavaForTesters.txt");

        assertThat(aTempFile.exists(), is(false));

        aTempFile.createNewFile();

        assertThat(aTempFile.exists(), is(true));

        aTempFile.delete();

        assertThat(aTempFile.exists(), is(false));
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
        System.out.println(aFile.getAbsolutePath());

        assertThat(oneDirectory.getAbsolutePath(), is(oneDirectory.getCanonicalPath()));

        File relative = new File(tempDirectory, currentMillis);
        relative = new File(relative, "1");
        relative = new File(relative, "2");
        relative = new File(relative, "3");
        relative = new File(relative, "4");
        relative = new File(relative, "..");   //3
        relative = new File(relative, "..");   //2
        relative = new File(relative, "..");   //1

        System.out.println(relative.getAbsolutePath());

        assertThat(oneDirectory.getAbsolutePath(), is(relative.getCanonicalPath()));

        relative = new File(tempDirectory, currentMillis);
        relative = new File(relative, "1");
        relative = new File(relative, "2");
        relative = new File(relative, "..");   //1
        relative = new File(relative, "..");   //millis
        relative = new File(relative, "1");   //1

        System.out.println(relative.getAbsolutePath());

        assertThat(oneDirectory.getAbsolutePath(), is(relative.getCanonicalPath()));
    }


    @Test
    public void mkdirsCreatesIntermediateDirs(){

        String tempDirectory = System.getProperty("java.io.tmpdir");
        String newDirectoryStructure =  tempDirectory +
                                        System.currentTimeMillis() +
                                        File.separator +
                                        System.currentTimeMillis();
        File aDirectory = new File(newDirectoryStructure);

        System.out.println(aDirectory.getAbsolutePath());

        assertThat(aDirectory.mkdir(), is(false));
        assertThat(aDirectory.mkdirs(), is(true));
    }


    @Test
    public void mkdirsCreatesDirectories(){

        String tempDirectory = System.getProperty("java.io.tmpdir");

        String newDirectoryStructure =  tempDirectory +
                                        System.currentTimeMillis();
                                        //File.separator +
                                        //System.currentTimeMillis();

        System.out.println(newDirectoryStructure);

        // mkdir won't create this because it is temp/millis/test.tmp
        File aDirectory = new File(newDirectoryStructure, "test.tmp");
        assertThat(aDirectory.mkdir(), is(false));
        assertThat(aDirectory.exists(), is(false));

        // will create because it is just the temp/millis
        aDirectory = new File(newDirectoryStructure);
        assertThat(aDirectory.mkdir(), is(true));

    }

    @Test
    public void fileAndPathSeparator(){
        assertEquals("Are you running this on windows?",
                     "\\", File.separator);
        assertEquals("Are you running this on windows?",
                     ";", File.pathSeparator);
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

            assertThat( aTempFile.getParent() + File.separator,
                        is(System.getProperty("java.io.tmpdir")));

            assertThat(aTempFile.getAbsolutePath().endsWith("suffix"), is(true));
            assertThat(aTempFile.getAbsolutePath().startsWith(
                          System.getProperty("java.io.tmpdir")), is(true));

            assertThat(aTempFile.getCanonicalPath().endsWith("suffix"), is(true));
            assertThat(aTempFile.getCanonicalPath().startsWith(
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