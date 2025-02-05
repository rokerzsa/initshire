package com.redyhire.application.config;

import static com.redyhire.application.config.Arguments.*;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

public class ArgumentConfiguration {

    private final String[] args;

    private Namespace argumentNamespace;

    public ArgumentConfiguration(String[] args) {
        this.args = args;
        __initArgumentParser(args);
    }

    public <T> T getArgumentValue(Arguments argument) {
        return argumentNamespace.get(argument.name().toLowerCase());
    }

    private void __initArgumentParser(String[] args) {
        ArgumentParser parser = ArgumentParsers.newFor("Main")
                .build()
                .defaultHelp(true)
                .description("Question Bank Uploader for Redyhire Library");
        parser.addArgument("-c", "--app-config")
                .metavar(APP_CONFIG.name())
                .setDefault("app-config.json")
                .help(
                        "This argument is used for defining the config file with which the new application will be created");
        try {
           this.argumentNamespace = parser.parseArgs(args);
        } catch (ArgumentParserException e) {
            parser.handleError(e);
            System.exit(1);
        }
    }
}
