package com.javafortesters.files;


import org.junit.Test;

import java.io.*;

import java.nio.file.Files;

// for REPLACE_EXISTING
import static java.nio.file.StandardCopyOption.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FilesTest {

    @Test
    public void copyFile() throws IOException {

        File copyThis = writeTheTestDataFile();
        File toThis = new File(copyThis.getCanonicalPath() + ".copy");

        assertThat(toThis.exists(), is(false));

        Files.copy(copyThis.toPath(), toThis.toPath());

        assertThat(toThis.exists(), is(true));
        assertThat(copyThis.length(), is(toThis.length()));
    }

    @Test
    public void moveFile() throws IOException {

        File moveThis = writeTheTestDataFile();
        File toThis = new File(moveThis.getCanonicalPath() + ".moved");

        assertThat(moveThis.exists(), is(true));
        assertThat(toThis.exists(), is(false));

        Files.move(moveThis.toPath(), toThis.toPath(),
                    REPLACE_EXISTING, ATOMIC_MOVE);

        assertThat(toThis.exists(), is(true));
        assertThat(moveThis.exists(), is(false));
    }



    private File writeTheTestDataFile() throws IOException {
        File outputFile = File.createTempFile("forReading", null);
        PrintWriter print = new PrintWriter(new BufferedWriter( new FileWriter(outputFile)));

        for(int lineNumber = 1; lineNumber < 6; lineNumber++){
            print.println("line " + lineNumber);
        }

        print.close();
        return outputFile;
    }

}