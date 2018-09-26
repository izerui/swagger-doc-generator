package com.izerui.generator;

import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.asciidoctor.Asciidoctor;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;

public class DocTest {

    @Test
    public void gen() throws URISyntaxException {
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                .withOutputLanguage(Language.ZH)
                .build();
//        Swagger2MarkupConverter.from(new URI("http://192.168.1.183:31001/v2/api-docs.json"))
        Swagger2MarkupConverter.from(Paths.get("/Users/serv/dev/github.com/swagger-doc-generator/src/test/resources/api.json"))
                .withConfig(config)
                .build()
                .toFolder(Paths.get("target/docs/"));

        Asciidoctor asciidoctor = Asciidoctor.Factory.create();


    }
}
