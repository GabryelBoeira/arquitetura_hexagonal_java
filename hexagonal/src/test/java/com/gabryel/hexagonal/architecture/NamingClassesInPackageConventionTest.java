package com.gabryel.hexagonal.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.gabryel.hexagonal")
public class NamingClassesInPackageConventionTest {

    @ArchTest
    public static final ArchRule should_be_suffixed_consumer = classes()
            .that()
            .resideInAPackage("..consumer")
            .should()
            .haveSimpleNameEndingWith("Consumer");

    @ArchTest
    public static final ArchRule should_be_suffixed_mapper = classes()
            .that()
            .resideInAPackage("..mapper")
            .should()
            .haveSimpleNameEndingWith("Mapper")
            .orShould()
            .haveSimpleNameEndingWith("MapperImpl");

    @ArchTest
    public static final ArchRule should_be_suffixed_message = classes()
            .that()
            .resideInAPackage("..message")
            .should()
            .haveSimpleNameEndingWith("Message");

    @ArchTest
    public static final ArchRule should_be_suffixed_controller = classes()
            .that()
            .resideInAPackage("..controller")
            .should()
            .haveSimpleNameEndingWith("Controller");

    @ArchTest
    public static final ArchRule should_be_suffixed_request = classes()
            .that()
            .resideInAPackage("..request")
            .should()
            .haveSimpleNameEndingWith("Request");

    @ArchTest
    public static final ArchRule should_be_suffixed_response = classes()
            .that()
            .resideInAPackage("..response")
            .should()
            .haveSimpleNameEndingWith("Response");

    @ArchTest
    public static final ArchRule should_be_suffixed_client = classes()
            .that()
            .resideInAPackage("..client")
            .should()
            .haveSimpleNameEndingWith("Client");

    @ArchTest
    public static final ArchRule should_be_suffixed_repository = classes()
            .that()
            .resideInAPackage("..repository")
            .should()
            .haveSimpleNameEndingWith("Repository");

    @ArchTest
    public static final ArchRule should_be_suffixed_entity = classes()
            .that()
            .resideInAPackage("..entity")
            .should()
            .haveSimpleNameEndingWith("Entity");

    @ArchTest
    public static final ArchRule should_be_suffixed_adapter = classes()
            .that()
            .resideInAPackage("..adapter.out")
            .should()
            .haveSimpleNameEndingWith("Adapter");

    @ArchTest
    public static final ArchRule should_be_suffixed_usecase = classes()
            .that()
            .resideInAPackage("..usecase")
            .should()
            .haveSimpleNameEndingWith("UseCase");

    @ArchTest
    public static final ArchRule should_be_suffixed_input_port = classes()
            .that()
            .resideInAPackage("..ports.in")
            .should()
            .haveSimpleNameEndingWith("InputPort");

    @ArchTest
    public static final ArchRule should_be_suffixed_output_port = classes()
            .that()
            .resideInAPackage("..ports.out")
            .should()
            .haveSimpleNameEndingWith("OutputPort");

    @ArchTest
    public static final ArchRule should_be_suffixed_config = classes()
            .that()
            .resideInAPackage("..configuration..")
            .should()
            .haveSimpleNameEndingWith("Config");


}
