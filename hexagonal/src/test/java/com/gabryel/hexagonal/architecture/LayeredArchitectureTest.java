package com.gabryel.hexagonal.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.boot.test.context.SpringBootTest;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "com.gabryel.hexagonal")
@SpringBootTest
public class LayeredArchitectureTest {

    @ArchTest
    public static final ArchRule layered_architecture_test = layeredArchitecture().consideringAllDependencies()

            // Define layers
            .layer("AdaptersIn").definedBy("..adapter.in..")
            .layer("AdaptersOut").definedBy("..adapter.out..")
            .layer("UseCase").definedBy("..application.core.usecase..")
            .layer("PortsIn").definedBy("..application.ports.in..")
            .layer("PortsOut").definedBy("..application.ports.out..")
            .layer("Configuration").definedBy("..configuration..")

            // Define dependencies
            .whereLayer("AdaptersIn").mayOnlyBeAccessedByLayers("Configuration")
            .whereLayer("AdaptersOut").mayOnlyBeAccessedByLayers("Configuration")
            .whereLayer("UseCase").mayOnlyBeAccessedByLayers("Configuration")
            .whereLayer("PortsIn").mayOnlyBeAccessedByLayers("UseCase", "AdaptersIn")
            .whereLayer("PortsOut").mayOnlyBeAccessedByLayers("UseCase", "AdaptersOut")
            .whereLayer("Configuration").mayNotBeAccessedByAnyLayer();

}
