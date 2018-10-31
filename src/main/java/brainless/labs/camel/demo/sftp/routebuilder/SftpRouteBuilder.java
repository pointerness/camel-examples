package brainless.labs.camel.demo.sftp.routebuilder;

import java.io.File;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.file.GenericFile;
import org.springframework.stereotype.Service;

@Service
public class SftpRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("{{sftp.client}}").process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				GenericFile< File>file = exchange.getIn().getBody(GenericFile.class);
				System.out.println(file.getAbsoluteFilePath());
			}
		});
	}

}
