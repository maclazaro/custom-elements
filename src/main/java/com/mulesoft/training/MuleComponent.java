package com.mulesoft.training;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mule.api.annotations.param.InboundHeaders;
import org.mule.api.annotations.param.Payload;

public class MuleComponent {

	public Map<String, String> processMap(Map<String, String> input) {
		// reflection
		// processMap implementation
		input.put("processed by", "processMap");
		return input;
	}

	public Map<String, String> processArray(List<String> input) {
		// reflection
		// processArray implementation
		Map<String, String> output = new HashMap<String, String>();
		output.put("message", input.get(0));
		output.put("processedBy", "processArray");
		return output;
	}

	public Map<String, String> processString(String input) {
		// reflection
		// processString implementation
		Map<String, String> output = new HashMap<String, String>();
		output.put("message", input);
		output.put("processedBy", "processString");
		return output;
	}

	public Map<String, String> processAll(@Payload Object input, @InboundHeaders("http.method") String method) {
		// annotation
		// will take precedence over reflection
		// processAll implementation
		Map<String, String> output = new HashMap<String, String>();
		output.put("message", input.toString());
		output.put("processedBy", "processAll");
		output.put("http.method", method);
		return output;
	}

	public Map<String, String> processString2() {
		// processString2 implementation
		return null;
	}

}
