package me.miak;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tester {
    public static void main(String[] args) throws IOException {
        String dir = "./tests";
        boolean hasFailedTest = false;
        for (String file : getDirFilenames(dir)) {
            String filePath = dir + '/' + file;
            System.out.println("Testing: " + file);
            String input = Files.readString(Path.of(filePath));
            Pattern p = Pattern.compile("[/][/][/] (.*)$", Pattern.MULTILINE);
            Matcher m = p.matcher(input);
            StringBuilder expected = new StringBuilder();
            while (m.find()) {
                expected.append(m.group(1)).append('\n');
            }
            CharStream inStream = CharStreams.fromString(input);
            OutputStream outStream = new ByteArrayOutputStream();
            BufferedWriter outWriter = new BufferedWriter(new OutputStreamWriter(outStream));
            Main.runParser(inStream, outWriter);
            outWriter.flush();
            String result = outStream.toString();
            if(Objects.equals(result, expected.toString())) System.out.println("Passed ✔️\n");
            else{
                hasFailedTest = true;
                System.out.println("Failed:");
                System.out.println("Expected:\n" + expected);
                System.out.println("Got:\n" + result);
            }
        }
        if(!hasFailedTest) System.out.println("\uD83C\uDFC6 All test passed \uD83C\uDFC6");
    }

    private static Set<String> getDirFilenames(String dir) {
        Set<String> fileList = new HashSet<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir))) {
            for (Path path : stream) {
                if (!Files.isDirectory(path)) {
                    fileList.add(path.getFileName().toString());
                }
            }
        } catch (IOException e) {
            System.out.println("Invalid directory name");
            e.printStackTrace();
        }
        return fileList;
    }
}
