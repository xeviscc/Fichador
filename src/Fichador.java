import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Fichador {

	public static void main(final String[] args) throws Exception {
		final WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER);

		String USER = args[0];
		String PASS = args[1];
		try {
//			DefaultCredentialsProvider userCredentials = new DefaultCredentialsProvider();
//			userCredentials.addCredentials(USER, PASS);
//			webClient.setCredentialsProvider(userCredentials);
//			webClient.set
			webClient.getOptions().setDownloadImages(false);
			webClient.getOptions().setRedirectEnabled(true);
			webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
			System.out.println("INIT");
			HtmlPage page = webClient.getPage("https://atosspain.bodet-software.com/open/login");
			System.out.println("Set User: " + USER);
			HtmlInput inputBoxUsername = page.getHtmlElementById("username");
			inputBoxUsername.setValueAttribute(USER);
			System.out.println("Set Password: " + PASS);
			HtmlInput inputBoxPassword = page.getHtmlElementById("password");
			inputBoxPassword.setValueAttribute(PASS);
			System.out.println("CLick button to enter.");
			final HtmlPage page2 = page.getElementById("btnAction").click();
			System.out.println(page2.asText());
			System.out.println("Get button to fichar, and click.");
			DomElement a = (DomElement) page2.getFirstByXPath("//a[@class='boutonAction']");
			System.out.println(a.asText());
			System.out.println("CLICK");
			a.click();			
			System.out.println("FIN");
		} catch (final FailingHttpStatusCodeException e) {
			System.out.println("FailingHttpStatusCodeException");
			e.printStackTrace();	
		} catch (final MalformedURLException e) {
			System.out.println("MalformedURLException");
			e.printStackTrace();
		} catch (final IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		} catch (final Exception e) {
			System.out.println("Exception");
			e.printStackTrace();
		} finally {
			webClient.close();
			System.out.println("Finished");	
		}
		
	}

}
