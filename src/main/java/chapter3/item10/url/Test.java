package chapter3.item10.url;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Test {

    public static void main(String[] args) throws IOException, URISyntaxException {
        // URL and URI test
        String urlSpec1 = "http://127.0.0.1";
        String urlSpec2 = "http://localhost";

        URL url1 = new URL(urlSpec1);
        URL url2 = new URL(urlSpec2);

        System.out.println("URL");
        System.out.println("url1.equals(u2): " + url1.equals(url2));
        System.out.println("url1.hashCode(): " + url1.hashCode());
        System.out.println("url2.hashCode(): " + url2.hashCode());

        System.out.println();

        URI uri1 = new URI(urlSpec1);
        URI uri2 = new URI(urlSpec2);

        System.out.println("URI");
        System.out.println("uri1.equals(uri2): " + uri1.equals(uri2));
        System.out.println("uri1.hashCode(): " + uri1.hashCode());
        System.out.println("uri2.hashCode(): " + uri2.hashCode());

    }
}
