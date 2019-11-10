package Libs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class fileIO {
    public static Stream<String> readFile(String path) throws IOException {
        return Files
                .lines(Paths.get(path))
                .map(String::trim)
                ;
    }

    public static void writeFile(String path, String context, boolean isOverride) throws IOException {
        OpenOption[] opts;

        if (isOverride){
            opts = new OpenOption[]{StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING};
        }
        else{
            opts = new OpenOption[]{StandardOpenOption.APPEND};
        }

        Files.write(Paths.get(path),context.getBytes(),opts);
    }
}
