package org.elyograg.fibservice.controller;

import java.io.UnsupportedEncodingException;
import java.lang.invoke.MethodHandles;
import java.util.List;

import org.elyograg.fibservice.util.Common;
import org.elyograg.fibservice.util.CommonHtmlBits;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FibonacciController {
	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = { "/", "/index.html" })
	public ResponseEntity mainPage(@RequestParam(value = "input", required = false) final String paramInput) {
		String input = null;
		if (paramInput == null || paramInput.length() < 1) {
			input = "";
		} else {
			input = paramInput;
		}

		StringBuilder sb = new StringBuilder();
		CommonHtmlBits.appendStrictXhtmlPageBegin(sb, "Fibonacci Generator");
		sb.append("<form action=");
		sb.append(CommonHtmlBits.DQ);
		sb.append("/");
		sb.append(CommonHtmlBits.DQ);
		sb.append(">");
		sb.append(CommonHtmlBits.NL);
		sb.append("  Input:<br>");
		sb.append(CommonHtmlBits.NL);
		sb.append("  <input type=");
		sb.append(CommonHtmlBits.DQ);
		sb.append("text");
		sb.append(CommonHtmlBits.DQ);
		sb.append(" name=");
		sb.append(CommonHtmlBits.DQ);
		sb.append("input");
		sb.append(CommonHtmlBits.DQ);
		sb.append(" value=");
		sb.append(CommonHtmlBits.DQ);
		sb.append(input);
		sb.append(CommonHtmlBits.DQ);
		sb.append(">");
		sb.append(CommonHtmlBits.NL);
		sb.append("  <input type=");
		sb.append(CommonHtmlBits.DQ);
		sb.append("submit");
		sb.append(CommonHtmlBits.DQ);
		sb.append(" value=");
		sb.append(CommonHtmlBits.DQ);
		sb.append("Submit");
		sb.append(CommonHtmlBits.DQ);
		sb.append(">");
		sb.append(CommonHtmlBits.NL);
		sb.append("</form>");
		sb.append(CommonHtmlBits.NL);

		int inputValue = Integer.MIN_VALUE;
		try {
			if (!input.equals("")) {
				inputValue = Integer.parseInt(input);
			}
		} catch (Exception e) {
			log.error("Exception encountered while parsing Fibonacci input. Proceeding.", e);
		}

		if (inputValue < 1) {
			if (!input.equals("")) {
				// output error message
				sb.append("<p>");
				sb.append(CommonHtmlBits.NL);
				sb.append("The input value ");
				sb.append(CommonHtmlBits.DQ);
				sb.append(input);
				sb.append(CommonHtmlBits.DQ);
				sb.append(" was not useful.");
				sb.append("</p>");
				sb.append(CommonHtmlBits.NL);
			}
		} else {
			List<Long> sequence = Common.getFibonacciSequence(inputValue);
			// output the sequence.
			sb.append("<p>");
			sb.append(CommonHtmlBits.NL);
			sb.append("Sequence:<br/>");
			sb.append(CommonHtmlBits.NL);

			for (Long i : sequence) {
				sb.append("&nbsp;");
				sb.append(i);
				sb.append("<br/>");
				sb.append(CommonHtmlBits.NL);
			}
			sb.append("</p>");
			sb.append(CommonHtmlBits.NL);
		}

		CommonHtmlBits.appendBodyHtmlEnd(sb);
		log.info("Fibonacci page loaded with value \"{}\"", input);
		return responseFromCharSequence(sb);
	}

	/**
	 * @param cs The {@link CharSequence} to turn into a response.
	 * @return A response entity.
	 */
	@SuppressWarnings("rawtypes")
	private synchronized ResponseEntity responseFromCharSequence(CharSequence cs) {
		try {
			Resource rsc = new ByteArrayResource(cs.toString().getBytes("UTF-8"));
			return new ResponseEntity<Resource>(rsc, HttpStatus.OK);
		} catch (UnsupportedEncodingException e) {
			log.error("Could not convert bytes.", e);
			return Common.emptyResponseServerError;
		}
	}
}
