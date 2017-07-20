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
 * '{@code integration-tests}', <b>on the parent module</b></li>
 * <li>The tests are run with a maven build with profile
 * '{@code integration-tests}'</li>
 * <li>The payara server has to be manually started before running the
 * integration tests</li>
 * <li>By default the standard jbugs package 'edu.msg.ro' is used as the common
 * parent package for all EJBs. Overwrite {@link #getEjbPackages()} in order to
 * change that.</li>
 * </ol>
 * 
 * @author floricea
 *
 */
@RunWith(Arquillian.class)
public abstract class AbstractIntegrationTest {

	@Deployment
	public static Archive<?> createDeploymentPackage() throws IOException {
		File[] ejbDependencies = Maven.resolver().loadPomFromFile("pom.xml").importRuntimeDependencies().resolve()
				.withTransitivity().asFile();

		final JavaArchive ejbJar = ShrinkWrap.create(JavaArchive.class, "ejb-jar.jar") //
				.addPackages(true, getEjbPackages());

		final WebArchive testWar = ShrinkWrap.create(WebArchive.class, "test.war").addAsLibraries(ejbDependencies)
				.addAsLibrary(ejbJar);

		final EnterpriseArchive ear = ShrinkWrap.create(EnterpriseArchive.class)
				.setApplicationXML("test-application.xml").addAsModule(testWar);

		return ear;
	}

	public static String[] getEjbPackages() {
		return new String[] { "edu.msg.ro" };
	}

}
