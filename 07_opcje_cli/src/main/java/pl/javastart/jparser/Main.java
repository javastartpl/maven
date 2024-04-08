package pl.javastart.jparser;

import java.io.UncheckedIOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import pl.javastart.jparser.io.export.DataExporter;
import pl.javastart.jparser.parser.ExtractedElements;
import pl.javastart.jparser.parser.PageParser;
import pl.javastart.jparser.parser.jsoup.JsoupElementExtractor;
import pl.javastart.jparser.parser.jsoup.JsoupHtmlFetcher;

public class Main {

    public static void main(String[] args) {
        Options options = getOptions();
        try {
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);
            String url = cmd.getOptionValue('u');
            String fileName = cmd.hasOption('f') ? cmd.getOptionValue('f') : null;
            String[] selectors = cmd.hasOption('s') ? cmd.getOptionValues('s') : new String[0];
            run(url, selectors, fileName);
        } catch (ParseException e) {
            printHelp(options);
        } catch (UncheckedIOException e) {  
            System.err.println(e.getMessage());  
        }  
    }

    private static void run(String url, String[] selectors, String fileName) {
        JsoupHtmlFetcher jsoupHtmlFetcher = new JsoupHtmlFetcher();
        JsoupElementExtractor jsoupElementExtractor = new JsoupElementExtractor();
        PageParser pageParser = new PageParser(jsoupElementExtractor, jsoupHtmlFetcher);
        System.out.println("Connecting to " + url);
        ExtractedElements extractedElements = pageParser.extractElements(url, selectors);
        System.out.println("Extracting elements from " + url + " completed.");
        System.out.println("Analyzed selectors: " + extractedElements.elements().keySet());
        System.out.println("Extracted elements:");
        for (Map.Entry<String, List<String>> entry : extractedElements.elements().entrySet()) {
            List<String> elements = entry.getValue();
            if (!elements.isEmpty()) {
                System.out.println(entry.getKey());
                for (int i = 0; i < elements.size(); i++) {
                    System.out.println(" " + i + ": " + elements.get(i));
                }
            }
        }
        if (fileName != null) {
            DataExporter.save(extractedElements, fileName);
            System.out.println("Data exported to file " + fileName);
        }
    }

    private static Options getOptions() {
        Options options = new Options();
        options.addRequiredOption("u", "url", true, "URL to be parsed");
        Option selectorsOption = Option.builder("s")
                .longOpt("selectors")
                .hasArgs()
                .desc("Selectors to be extracted from HTML")
                .build();
        options.addOption(selectorsOption);
        options.addOption("f", "file", true, "Name of the exported file");
        return options;
    }

    private static void printHelp(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("jparser", options);
    }
}
