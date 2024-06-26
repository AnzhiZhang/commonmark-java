package org.commonmark.testutil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class TestResources {

    public static URL getSpec() {
        return TestResources.class.getResource("/spec.txt");
    }

    public static URL getGfmSpec() {
        return TestResources.class.getResource("/gfm-spec.txt");
    }

    public static List<URL> getRegressions() {
        return List.of(
                TestResources.class.getResource("/cmark-regression.txt"),
                TestResources.class.getResource("/commonmark.js-regression.txt")
        );
    }

    public static String readAsString(URL url) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
