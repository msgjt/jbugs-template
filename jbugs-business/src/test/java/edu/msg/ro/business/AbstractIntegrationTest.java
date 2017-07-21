package edu.msg.ro.business;

import java.io.File;
import java.io.IOException;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.runner.RunWith;

/**
 * Abstract class for all integration tests.
 * <p>
 * <b>Important notes:</b>
 * <ol>
 * <li>The tests are run with a maven build with profile
 * '{@code payara-remote}', <b>on the parent module</b></li>
 * <li>The payara server has to be manually started before running the
 * integration tests</li>
 * <li>No application should be deployed!!</li>
 * <li>By default the standard jbugs package 'edu.msg.ro' is used as the common
 * parent package for all EJBs. Overwrite {@link #getEjbPackages()} in order to
 * change that.</li>
 * <li>ddl strategy should be 'drop-and-create'. Change it on your
 * responsability</li>
 * </ol>
 * 
 * @author Andrei Floricel, msg systems ag
 *
 */
@RunWith(Arquillian.class)
public abstract class AbstractIntegrationTest {

	@Deployment
	public static Archive<?> createDeploymentPackage() throws IOException {
		final File[] ejbDependencies = Maven.resolver().loadPomFromFile("pom.xml").importRuntimeDependencies().resolve()
				.withTransitivity().asFile();

		final JavaArchive ejbJar = ShrinkWrap.create(JavaArchive.class, "ejb-jar.jar") //
				.addPackages(true, getEjbPackages()).addAsManifestResource("beans.xml");

		System.out.println(ejbJar.toString(true));

		final WebArchive testWar = ShrinkWrap.create(WebArchive.class, "test.war").addAsLibraries(ejbDependencies)
				.addAsLibrary(ejbJar).addAsWebInfResource("beans.xml");
		System.out.println(testWar.toString(true));

		final EnterpriseArchive ear = ShrinkWrap.create(EnterpriseArchive.class)
				.setApplicationXML("test-application.xml").addAsModule(testWar);
		System.out.println(ear.toString(true));

		return ear;
	}

	public static String[] getEjbPackages() {
		return new String[] { "edu.msg.ro" };
	}

}
