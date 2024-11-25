package com.gabryel.hexagonal.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.gabryel.hexagonal")
public class NamingPackageConventionTest {

    @ArchTest
    public static final ArchRule consumer_reside_only_consumer_package = classes()
            .that()
            .haveNameMatching(".*Consumer")
            .should()
            .resideInAPackage("..adapter.in.consumer")
            .as("Consumer classes should reside inside consumer package in adapter.in package");

    @ArchTest
    public static final ArchRule mapper_reside_only_mapper_package = classes()
            .that()
            .haveNameMatching(".*Mapper")
            .should()
            .resideInAnyPackage("..adapter.in.consumer.mapper", "..adapter.in.controller.mapper", "..adapter.out.client.mapper", "..adapter.out.repository.mapper")
            .as("Mapper classes should reside inside mapper package in controller, client, consumer or repository packages");

    @ArchTest
    public static final ArchRule message_reside_only_message_package = classes()
            .that()
            .haveNameMatching(".*Message")
            .should()
            .resideInAPackage("..adapter.in.consumer.message")
            .as("Message classes should reside inside message package in consumer package");

    @ArchTest
    public static final ArchRule controller_reside_only_controller_package = classes()
            .that()
            .haveNameMatching(".*Controller")
            .should()
            .resideInAPackage("..adapter.in.controller")
            .as("Controller classes should reside inside controller package in adapter.in package");

    @ArchTest
    public static final ArchRule request_reside_only_request_package = classes()
            .that()
            .haveNameMatching(".*Request")
            .should()
            .resideInAnyPackage("..adapter.in.controller.request", "..adapter.out.client.request")
            .as("Request classes should reside inside request package in controller or client packages");

    @ArchTest
    public static final ArchRule response_reside_only_response_package = classes()
            .that()
            .haveNameMatching(".*Response")
            .should()
            .resideInAnyPackage("..adapter.in.controller.response", "..adapter.out.client.response")
            .as("Response classes should reside inside response package in controller or client packages");

    @ArchTest
    public static final ArchRule adapter_reside_only_adapter_package = classes()
            .that()
            .haveNameMatching(".*Adapter")
            .should()
            .resideInAPackage("..adapter.out")
            .as("Adapter classes should reside inside out package in adapter package");

    @ArchTest
    public static final ArchRule client_reside_only_client_package = classes()
            .that()
            .haveNameMatching(".*Client")
            .should()
            .resideInAPackage("..adapter.out.client")
            .as("Client classes should reside inside client package in adapter.out package");

    @ArchTest
    public static final ArchRule repository_reside_only_repository_package = classes()
            .that()
            .haveNameMatching(".*Repository")
            .should()
            .resideInAPackage("..adapter.out.repository")
            .as("Repository classes should reside inside repository package in adapter.out package");

    @ArchTest
    public static final ArchRule entity_reside_only_entity_package = classes()
            .that()
            .haveNameMatching(".*Entity")
            .should()
            .resideInAPackage("..adapter.out.repository.entity")
            .as("Entity classes should reside inside entity package in entity package");

    @ArchTest
    public static final ArchRule usecase_reside_only_usecase_package = classes()
            .that()
            .haveNameMatching(".*UseCase")
            .should()
            .resideInAPackage("..application.core.usecase")
            .as("Usecase classes should reside inside usecase package in core package");

    @ArchTest
    public static final ArchRule input_reside_only_input_package = classes()
            .that()
            .haveNameMatching(".*InputPort")
            .should()
            .resideInAPackage("..application.ports.in")
            .as("InputPort classes should reside inside ports.in package in application package");

    @ArchTest
    public static final ArchRule output_reside_only_output_package = classes()
            .that()
            .haveNameMatching(".*OutputPort")
            .should()
            .resideInAnyPackage("..application.ports.out", "..application.ports.out.kafka")
            .as("OutputPort classes should reside inside ports.out package in application package");

}
