package com.caseStudy2.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports",
        },
        strict = true,
        features = "src/test/resources/features",
        glue = "com/caseStudy2/step_definitions",
        dryRun = false,
        tags = "@wip"
)

public class CukesRunner {
}
