package group.msg.at.cloud.cloudtrain.adapter.rest;

import org.eclipse.microprofile.auth.LoginConfig;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * JAX-RS configuration class that triggers activation of the JAX-RS feature
 * and applies some configuration to the JAX-RS environment.
 */
@ApplicationScoped
@ApplicationPath("/api")
@LoginConfig(authMethod = "MP-JWT")
public class JaxRsConfiguration extends Application {

}
