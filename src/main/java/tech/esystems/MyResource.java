package tech.esystems;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import tech.esystems.CpfValidator;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Got it!";
	}

	@GET
	@Path("validarcpf")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean validarCPF(@DefaultValue("9999999999") @QueryParam("number") String nuCpf) {
		return CpfValidator.isValidCPF(nuCpf);
	}
}
