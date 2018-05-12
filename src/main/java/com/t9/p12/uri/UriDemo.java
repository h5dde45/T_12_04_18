package com.t9.p12.uri;

import java.net.URI;
import java.net.URISyntaxException;

public class UriDemo {
    public static void main(String[] args) throws URISyntaxException {
        dumpUriComponents(new URI("mailto:tmvf@yandex.ru"));
        URI base0 = new URI("https://yandex.ru/pogoda/saint-petersburg");
        dumpUriComponents(base0);
        URI base = new URI("https://translate.yandex.ru/?lang=ru-en&text=%D0%BA%D1%83%D0%BF%D0%B8%D1%82%D1%8C");
        dumpUriComponents(base);

        URI resolved = base0.resolve("../saint-petersburg");
        dumpUriComponents(resolved);

        URI relativize = base0.relativize(new URI("https://yandex.ru/pogoda/saint-petersburg/details#14"));
        dumpUriComponents(relativize);

    }

    private static void dumpUriComponents(URI uri) {
        System.out.println("-- " + uri + " --");
        System.out.println("schema:                "+uri.getScheme() );
        System.out.println("schema specific part:  "+uri.getSchemeSpecificPart());
        System.out.println("authority:             "+uri.getAuthority());
        System.out.println("user info:             "+uri.getUserInfo());
        System.out.println("host:                  "+uri.getHost());
        System.out.println("port:                  "+uri.getPort());
        System.out.println("path:                  "+uri.getPath());
        System.out.println("query:                 "+uri.getQuery());
        System.out.println("fragment:                  "+uri.getFragment());
        System.out.println();
    }
}
