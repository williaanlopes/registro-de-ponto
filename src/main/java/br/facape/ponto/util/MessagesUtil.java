package br.facape.ponto.util;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;

import org.omnifaces.cdi.Startup;
import org.omnifaces.util.Messages;

@Startup
public class MessagesUtil implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PostConstruct
	public void init() {
		Messages.setResolver(new Messages.Resolver() {
			
		    private static final String BASE_NAME = "messages.PTBR";
		    
		    public String getMessage(String message, Object... params) {
		        ResourceBundle bundle = ResourceBundle.getBundle(BASE_NAME, new Locale("pt_BR"));
		        if (bundle.containsKey(message)) {
		            message = bundle.getString(message);
		        }
		        return params.length > 0 ? MessageFormat.format(message, params) : message;
		    }
		    
		});
	}
}
