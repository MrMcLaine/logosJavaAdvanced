package org.advanced.HW3_logger;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class CustomLoggedFile {
    private static final Logger LOG = Logger.getLogger(CustomLoggedFile.class);

    public static void main(String[] args) {
        logWithDomConfigurator();
    }

    public static void logWithDomConfigurator() {
        DOMConfigurator.configure("loggerConfigHW3.xml");
        LOG.trace("Trace message");
        LOG.debug("Debug message");
        LOG.info("Info message");
        LOG.warn("Warning message");
        LOG.error("Error message");
    }
}
