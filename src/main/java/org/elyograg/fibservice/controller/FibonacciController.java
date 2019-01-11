package org.elyograg.fibservice.controller;

import java.io.UnsupportedEncodingException;
import java.lang.invoke.MethodHandles;

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

@Controller
public class FibonacciController {
	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	private static final String controlUrlPath = "/control";
	private static final String statusUrlPath = "/status";
	private static final String docidUrlPath = "/docid";
	private static final String pixTestUrlPath = "/pixtest";
	private static final String buildStatusUrlPath = "/buildstatus";

	@SuppressWarnings("rawtypes")
	@RequestMapping(value =
	{ "/", "/index.html" })
	public ResponseEntity mainPage()
	{
		StringBuilder sb = new StringBuilder();
		CommonHtmlBits.appendStrictXhtmlPageBegin(sb, "Fibonacci Generator");
		// TODO: Implement.
		CommonHtmlBits.appendBodyHtmlEnd(sb);
		return responseFromCharSequence(sb);
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value =
	{ "/placeholder" })
	public ResponseEntity placeHolder()
	{
		StringBuilder sb = new StringBuilder();
		CommonHtmlBits.appendStrictXhtmlPageBegin(sb, "Fibonacci Generator");
		sb.append("<a href = ");
		sb.append(CommonHtmlBits.DQ);
		sb.append(statusUrlPath);
		sb.append(CommonHtmlBits.DQ);
		sb.append(">");
		sb.append("Index Status");
		sb.append("</a><br/>");
		sb.append(CommonHtmlBits.NL);
		sb.append("<a href = ");
		sb.append(CommonHtmlBits.DQ);
		sb.append(buildStatusUrlPath);
		sb.append(CommonHtmlBits.DQ);
		sb.append(">");
		sb.append("Build Status");
		sb.append("</a><br/>");
		sb.append(CommonHtmlBits.NL);
		sb.append("<a href = ");
		sb.append(CommonHtmlBits.DQ);
		sb.append(controlUrlPath);
		sb.append(CommonHtmlBits.DQ);
		sb.append(">");
		sb.append("Index Control");
		sb.append("</a><br/>");
		sb.append(CommonHtmlBits.NL);
		sb.append("<a href = ");
		sb.append(CommonHtmlBits.DQ);
		sb.append(docidUrlPath);
		sb.append(CommonHtmlBits.DQ);
		sb.append(">");
		sb.append("DocID");
		sb.append("</a><br/>");
		sb.append(CommonHtmlBits.NL);
		sb.append("<a href = ");
		sb.append(CommonHtmlBits.DQ);
		sb.append(pixTestUrlPath);
		sb.append(CommonHtmlBits.DQ);
		sb.append(">");
		sb.append("Pixolution Test");
		sb.append("</a><br/>");
		sb.append(CommonHtmlBits.NL);
		CommonHtmlBits.appendBodyHtmlEnd(sb);
		return responseFromCharSequence(sb);
	}

	/**
	 * @param cs The {@link CharSequence} to turn into a response.
	 * @return A response entity.
	 */
	@SuppressWarnings("rawtypes")
	private synchronized ResponseEntity responseFromCharSequence(CharSequence cs)
	{
		try
		{
			Resource rsc = new ByteArrayResource(cs.toString().getBytes("UTF-8"));
			return new ResponseEntity<Resource>(rsc, HttpStatus.OK);
		}
		catch (UnsupportedEncodingException e)
		{
			log.error("Could not convert bytes.", e);
			return Common.emptyResponseServerError;
		}
	}
}
